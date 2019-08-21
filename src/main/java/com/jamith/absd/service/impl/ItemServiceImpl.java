package com.jamith.absd.service.impl;

import com.jamith.absd.dto.ItemDto;
import com.jamith.absd.entity.Item;
import com.jamith.absd.repository.ItemRepository;
import com.jamith.absd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream().map(Item::getItemDto).collect(Collectors.toList());
    }

    @Override
    public boolean saveItem(ItemDto dto) {
        Item item = new Item();
        item.setCode(dto.getCode());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setUnitPrice(dto.getPrice());
        item.setQtyOnHand(dto.getQty());
        itemRepository.save(item);
        return true;
    }

    @Override
    public boolean updateItem(ItemDto dto) {
        Item item = itemRepository.findTopByCode(dto.getCode());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setUnitPrice(dto.getPrice());
        item.setQtyOnHand(dto.getQty());
        itemRepository.save(item);
        return true;
    }

    @Override
    public boolean deleteItem(String code) {
        Item item = itemRepository.findTopByCode(code);
        itemRepository.delete(item);
        return true;
    }

    @Override
    public Item getItemByCode(String code) {
        return itemRepository.findTopByCode(code);
    }

    @Override
    public boolean updateItemQty(Integer qty, String code) {
        itemRepository.updateQTY(qty, code);
        return true;
    }

    @Override
    public Integer getCount() {
        return itemRepository.getCount();
    }
}
