package com.example.ryzhkov.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private List<String> stringList = null;
    private Map<Integer, String> stringMap = null;
    private int mapKeyCounter = 1;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (stringList == null) {
            stringList = new ArrayList<>();
        }
        stringList.add(s);
        return String.format("Элемент '%s' успешно добавлен в ArrayList!", s);
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        if (stringList == null) {
            return new ArrayList<>();
        }
        return stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (stringMap == null) {
            stringMap = new HashMap<>();
        }
        stringMap.put(mapKeyCounter++, s);
        return String.format("Элемент '%s' успешно добавлен в HashMap!", s);
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        if (stringMap == null) {
            return new HashMap<>();
        }
        return stringMap;
    }
    
    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        int listSize = (stringList != null) ? stringList.size() : 0;
        int mapSize = (stringMap != null) ? stringMap.size() : 0;

        return String.format("Количество элементов в ArrayList: %d, в HashMap: %d", listSize, mapSize);
    }
}