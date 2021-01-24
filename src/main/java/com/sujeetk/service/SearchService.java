package com.sujeetk.service;

import com.sujeetk.YahooConstants;
import com.sujeetk.dto.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    RestTemplate restTemplate;

    public Quote findQuote(String quoteName) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(YahooConstants.YAHOO_FINANCE_BASE_URL)
                .path(YahooConstants.YF_PATH_V1 + YahooConstants.YF_SEARCH_PATH)
                .queryParam(YahooConstants.Q_PRM, quoteName)
                .queryParam(YahooConstants.QUOTE_COUNT, 5)
                .queryParam(YahooConstants.NEWS_COUNT, 0)
                .queryParam(YahooConstants.ENABLE_FUZZY, false)
                .queryParam(YahooConstants.QUOTES_QUERY_ID, YahooConstants.QUOTES_QUERY_ID_VAL)
                .queryParam(YahooConstants.ENABLE_NAV_LINKS, false)
                .queryParam(YahooConstants.VESPA_NEWS_TIMEOUTS, YahooConstants.VESPA_NEWS_TIMEOUTS_VAL);
        URI uri = builder.build().toUri();
        logger.debug("URI is - {}", uri);
        return restTemplate.getForObject(uri, Quote.class);
    }
}
