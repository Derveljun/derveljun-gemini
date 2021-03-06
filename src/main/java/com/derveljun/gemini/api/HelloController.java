package com.derveljun.gemini.api;

import com.derveljun.gemini.api.stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
public class HelloController {

    StockService stockService;

    @Autowired
    public HelloController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Welcome my Project";
    }

}
