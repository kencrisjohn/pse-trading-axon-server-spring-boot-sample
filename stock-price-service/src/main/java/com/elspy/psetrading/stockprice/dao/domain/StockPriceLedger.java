package com.elspy.psetrading.stockprice.dao.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
@Table
@Data
@NoArgsConstructor
public class StockPriceLedger implements Serializable {

    @Id
    private String stockCode;
    private Double currPrice;
    private Double oldPrice;
    private Double percentageChange;
    @CreationTimestamp
    private LocalDateTime createTime;


}
