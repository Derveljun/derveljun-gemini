package com.derveljun.gemini.api.stock;

import com.derveljun.gemini.api.stock.dto.Stock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockServiceTest {

    @Autowired
    StockService stockService;

    Stock testStock = Stock.builder().stockCode("028202").stockName("데르벨준(주)").build();

    @Test
    void searchStock() {
        assertTrue(stockService.createStock(testStock));
        assertEquals("028202", stockService.searchStock(testStock).getStockCode());
    }

    @Transactional
    @Test
    void createStock() {
        assertTrue(stockService.createStock(testStock));
        assertTrue(stockService.removeStock(testStock.getStockCode()));
    }

    @Transactional
    @Test
    void modifyStock() {
        var redefine = "(주) 데르벨준";
        testStock.setStockName(redefine);
        assertTrue(stockService.modifyStock(testStock));
        assertEquals(redefine, stockService.searchStock(testStock).getStockName());
        assertTrue(stockService.removeStock(testStock.getStockCode()));
    }

    @Transactional
    @Test
    void removeStock() {
        assertTrue(stockService.createStock(testStock));
        assertTrue(stockService.removeStock(testStock.getStockCode()));
    }
}