package com.derveljun.gemini.api.stock;

import com.derveljun.gemini.api.stock.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StockController {

    StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @PostMapping("/stock")
    public Stock postStock(@RequestBody Stock stock){
        stockService.createStock(stock);
        return stockService.searchStock(stock.getStockCode());
    }

    @PutMapping("/stock")
    public Stock putStock(@RequestBody Stock stock){
        stockService.modifyStock(stock);
        return stockService.searchStock(stock.getStockCode());
    }

    @DeleteMapping("/stock")
    public boolean deleteStock(@RequestBody Stock stock){
        return stockService.removeStock(stock.getStockCode());
    }

    @GetMapping("/stock/{stockCode}")
    public Stock stock(@PathVariable String stockCode){
        return stockService.searchStock(stockCode);
    }

    @GetMapping(value = "/stocks/{stockName}")
    public List<Stock> stocks(@PathVariable String stockName){
        return stockService.searchStockList(stockName);
    }

}
