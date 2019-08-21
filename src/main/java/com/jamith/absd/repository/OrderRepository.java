package com.jamith.absd.repository;

import com.jamith.absd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value = "SELECT COUNT(*) FROM T_ORDER",nativeQuery = true)
    Integer getCount();
}
