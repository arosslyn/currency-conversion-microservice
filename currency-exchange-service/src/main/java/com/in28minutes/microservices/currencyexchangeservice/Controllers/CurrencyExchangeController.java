package com.in28minutes.microservices.currencyexchangeservice.Controllers;

import com.in28minutes.microservices.currencyexchangeservice.Models.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.Repositories.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment environment; // allows us to access properties from application.properties.
    @Autowired
    ExchangeValueRepository exchangeValueRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}", exchangeValue);
        return exchangeValue;
    }
}
