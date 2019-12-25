package com.derveljun.gemini.api.stock.dto;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true, name="stock_code")
    private String stockCode;

    @Column(length = 20, nullable = false, name="stock_name")
    private String stockName;

}
