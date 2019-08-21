package com.jamith.absd.repository;

import com.jamith.absd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Item findTopByCode(String code);

    @Modifying
    @Query(value = "UPDATE T_ITEM SET QTY_ON_HAND = ?1 WHERE CODE = ?2",nativeQuery = true)
    Integer updateQTY(Integer qty, String code);

    @Query(value = "SELECT COUNT(*) FROM T_ITEM",nativeQuery = true)
    Integer getCount();
}
