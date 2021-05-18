package pl.codeworld.customersappforkotrak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.codeworld.customersappforkotrak.entities.Customer;
import pl.codeworld.customersappforkotrak.repositories.CustomerPageableRepository;
import pl.codeworld.customersappforkotrak.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerPageableRepository customerPageableRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerPageableRepository customerPageableRepository) {
        this.customerRepository = customerRepository;
        this.customerPageableRepository = customerPageableRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAllByNameContaining(Pageable pageable, String name) {
        return customerPageableRepository.findAllByNameContaining(pageable, name);
    }
}
