package com.demo.plex.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.plex.dto.AverageData;
import com.demo.plex.repository.TransactionRepository;
import com.demo.plex.service.TransactionService;
import com.demo.plex.util.NumberFormatUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Double getAveragePrice(String token) {
		AverageData averageData = transactionRepository.findTotalPriceAndCountByToken(token).get();
		if(Objects.nonNull(averageData.getCount()) && averageData.getCount()>0)
			return NumberFormatUtil.truncateToTwoDecimalPlaces(averageData.getTotalPrice()/averageData.getCount());	
		return 0.0;
	}

	@Override
	public Double getTotalVoulme() {
		Optional<Double> totalVolumeOptional = transactionRepository.findTotalVolume();
		if (totalVolumeOptional.isPresent())
			return totalVolumeOptional.get();
		return 0.0;
	}

	
}
