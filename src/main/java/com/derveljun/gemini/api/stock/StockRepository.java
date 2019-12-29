package com.derveljun.gemini.api.stock;

import com.derveljun.gemini.api.stock.dto.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Stock findByStockCode(String stockCode);
    List<Stock> findAllByStockNameIsLikeOrderByStockCode(String stockName);
    void deleteByStockCode(String stockCode);

}
