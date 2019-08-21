package com.jamith.absd.service;

import com.jamith.absd.dto.ItemDto;
import com.jamith.absd.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<ItemDto> getAllItems();

    boolean saveItem(ItemDto dto);

    boolean updateItem(ItemDto dto);

    boolean deleteItem(String code);

    Item getItemByCode(String code);

    boolean updateItemQty(Integer qty, String code);

    Integer getCount();
}
