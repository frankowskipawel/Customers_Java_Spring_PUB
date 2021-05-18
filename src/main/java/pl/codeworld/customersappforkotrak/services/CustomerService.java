package pl.codeworld.customersappforkotrak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.codeworld.customersappforkotrak.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer findById(int id);
    Customer insert(Customer customer);
    Customer update(Customer customer);
    void delete(Customer customer);
    Page<Customer> findAllByNameContaining(Pageable pageable, String name);
}
