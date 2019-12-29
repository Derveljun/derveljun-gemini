package com.derveljun.gemini.api.stock;

import com.derveljun.gemini.api.stock.dto.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StockService {

    StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock searchStock(String stockCode) {
        return stockRepository.findByStockCode(stockCode);
    }

    public List<Stock> searchStockList(String stockName) {
        return stockRepository.findAllByStockNameIsLikeOrderByStockCode(stockName + "%");
    }

    public boolean createStock(Stock stock) {
        stockRepository.save(stock);
        return true;
    }

    public boolean modifyStock(Stock stock) {
        stockRepository.save(stock);
        return true;
    }

    public boolean removeStock(String stockCode) {
        stockRepository.deleteByStockCode(stockCode);
        return stockRepository.count() == 0;
    }

}
