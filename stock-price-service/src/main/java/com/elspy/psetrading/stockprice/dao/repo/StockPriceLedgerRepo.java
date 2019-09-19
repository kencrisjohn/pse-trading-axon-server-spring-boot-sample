package com.elspy.psetrading.stockprice.dao.repo;

import com.elspy.psetrading.stockprice.dao.domain.StockPriceLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockPriceLedgerRepo extends CrudRepository<StockPriceLedger, String>, JpaSpecificationExecutor<StockPriceLedger>, JpaRepository<StockPriceLedger,String> {
    Optional<StockPriceLedger> findTopByOrderByCreateTimeDesc();
}
