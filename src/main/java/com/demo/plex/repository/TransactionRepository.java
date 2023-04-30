package com.demo.plex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.demo.plex.dto.AverageData;
import com.demo.plex.entity.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>,RevisionRepository<Transaction, Long, Long>, JpaSpecificationExecutor<Transaction> {

	@Query("SELECT new com.demo.plex.dto.AverageData(sum(quantity) AS count, sum(price * quantity) AS totalPrice) FROM Transaction WHERE token = :token")
	Optional<AverageData> findTotalPriceAndCountByToken(String token);
	
	@Query("SELECT sum(price * quantity) FROM Transaction")
	Optional<Double> findTotalVolume();

}
