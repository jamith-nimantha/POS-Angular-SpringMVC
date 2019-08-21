package com.jamith.absd.controller;

import com.jamith.absd.dto.ItemDto;
import com.jamith.absd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity getAllItems(){
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseBody
    public ResponseEntity getCount(){
        return new ResponseEntity(itemService.getCount(), HttpStatus.OK);
    }

    @PostMapping("save")
    @ResponseBody
    public ResponseEntity saveItem(@RequestBody ItemDto itemDto){
        return new ResponseEntity(itemService.saveItem(itemDto),HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity updateItem(@RequestBody ItemDto itemDto){
        return new ResponseEntity(itemService.updateItem(itemDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    @ResponseBody
    public ResponseEntity deleteItem(@PathVariable String code){
        return new ResponseEntity(itemService.deleteItem(code),HttpStatus.OK);
    }
}
