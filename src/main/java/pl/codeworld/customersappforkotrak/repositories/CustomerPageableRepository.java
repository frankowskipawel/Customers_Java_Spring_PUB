package pl.codeworld.customersappforkotrak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.codeworld.customersappforkotrak.entities.Customer;

@Repository
public interface CustomerPageableRepository extends PagingAndSortingRepository<Customer, Integer> {

    Page<Customer> findAllByNameContaining(Pageable pageable, String name);
}
