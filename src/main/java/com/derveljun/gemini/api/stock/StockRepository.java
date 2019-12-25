package com.derveljun.gemini.api.stock;

import com.derveljun.gemini.api.stock.dto.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Stock findByStockCode(String stockCode);
    void deleteByStockCode(String stockCode);

}
