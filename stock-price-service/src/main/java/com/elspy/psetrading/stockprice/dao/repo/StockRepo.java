package com.elspy.psetrading.stockprice.dao.repo;

import com.elspy.psetrading.stockprice.dao.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends CrudRepository<Stock, String>, JpaSpecificationExecutor<Stock>, JpaRepository<Stock,String> {
}
