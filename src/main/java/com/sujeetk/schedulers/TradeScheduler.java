package com.sujeetk.schedulers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujeetk.dto.QuoteHistoryChartDto;
import com.sujeetk.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TradeScheduler {
    private static final Logger logger = LoggerFactory.getLogger(TradeScheduler.class);

    @Autowired
    private HistoryService historyService;

    @Scheduled(cron = "0 45 15 ? * MON-FRI", zone="Asia/Kolkata")
    public void reportCurrentTime() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            QuoteHistoryChartDto quoteChartHistory = historyService.getHistory("%5ENSEI", "1m", "1d", true);
            String data = mapper.writeValueAsString(quoteChartHistory);
            logger.info("The data is now {}", data);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
