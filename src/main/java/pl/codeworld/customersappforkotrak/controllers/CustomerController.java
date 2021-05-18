package pl.codeworld.customersappforkotrak.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.codeworld.customersappforkotrak.dtos.CustomerDto;
import pl.codeworld.customersappforkotrak.entities.Customer;
import pl.codeworld.customersappforkotrak.enums.CustomerType;
import pl.codeworld.customersappforkotrak.services.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<Customer> findAllPagination(@PathVariable int page, @RequestParam(required = false) String name) {
        if (name==null){name="";}
        Pageable pageable = PageRequest.of(page, 10, Sort.by("name").ascending());
        Page<Customer> customerPage = customerService.findAllByNameContaining(pageable, name);
       return customerPage;
    }


    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = customerService.findById(id);
        } catch (NoSuchElementException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        return customer;
    }

    @PostMapping
    public Customer insert(@RequestBody CustomerDto customerDto) {
        if (customerDto.getType() == CustomerType.COMPANY) {
            return customerService.insert(customerDto.toCustomerBusiness());
        } else if (customerDto.getType() == CustomerType.PERSON) {
            return customerService.insert(customerDto.toCustomerPerson());
        }
        return null;
    }

    @PutMapping
    public Customer update(@RequestBody CustomerDto customerDto) {
        if (customerDto.getType() == CustomerType.COMPANY) {
            return customerService.insert(customerDto.toCustomerBusiness());
        } else if (customerDto.getType() == CustomerType.PERSON) {
            return customerService.insert(customerDto.toCustomerPerson());
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(customerService.findById(id));
    }
}
