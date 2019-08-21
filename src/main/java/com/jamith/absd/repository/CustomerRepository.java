package com.jamith.absd.repository;

import com.jamith.absd.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    Customer findTopById(String id);

    @Query(value = "SELECT COUNT(*) FROM T_CUSTOMER",nativeQuery = true)
    Integer getCount();
}
