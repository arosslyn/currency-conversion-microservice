package com.in28minutes.microservices.currencyexchangeservice.Repositories;

import com.in28minutes.microservices.currencyexchangeservice.Models.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository <ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
