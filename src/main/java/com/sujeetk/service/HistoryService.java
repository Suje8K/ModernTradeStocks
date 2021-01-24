package com.sujeetk.service;

import com.sujeetk.YahooConstants;
import com.sujeetk.dto.CandleData;
import com.sujeetk.dto.QuoteHistoryChartDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class HistoryService {

    private static final Logger logger = LoggerFactory.getLogger(HistoryService.class);

    //Delimiter used in CSV file
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "TIME_EPOCH,O,L,C,H";

    @Autowired
    RestTemplate restTemplate;

    public QuoteHistoryChartDto getHistory(String quoteName, String interval, String range, boolean writeToFile) {
        String [] ranges = {"1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd", "max"};
        boolean rangeBool = Arrays.asList(ranges).contains(range);
        String [] intervals = {"1m", "2m", "5m", "15m", "30m", "60m", "1d"};
        boolean intervalBool = Arrays.asList(intervals).contains(interval);
        if (! rangeBool && intervalBool) {
            return new QuoteHistoryChartDto();
        } else {

            UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(YahooConstants.YAHOO_FINANCE_BASE_URL)
                    .path(YahooConstants.YF_PATH_V8 + YahooConstants.YF_CHART_PATH + "/" + quoteName)
                    .queryParam(YahooConstants.SYMBOL, quoteName)
                    .queryParam(YahooConstants.REGION, YahooConstants.REGION_VAL)
                    .queryParam(YahooConstants.LANG, YahooConstants.LANG_VAL)
                    .queryParam(YahooConstants.INCLUDE_PRE_POST, false)
                    .queryParam(YahooConstants.INTERVAL, interval)
                    .queryParam(YahooConstants.PERIOD1, "")
                    .queryParam(YahooConstants.PERIOD2, "")
                    .queryParam(YahooConstants.RANGE, range)
                    .queryParam(YahooConstants.USEYFID, true)
                    .queryParam(YahooConstants.CORS_DOMAIN, YahooConstants.CORS_DOMAIN_VAL)
                    .queryParam(YahooConstants.EVENTS, YahooConstants.EVENTS_VAL);
            URI uri = builder.build().toUri();
            logger.debug("URI is - {}", uri);
            QuoteHistoryChartDto quoteHistoryChartDto = restTemplate.getForObject(uri, QuoteHistoryChartDto.class);
            if (writeToFile && quoteHistoryChartDto != null)
                writeDataToFile(quoteHistoryChartDto);
            return quoteHistoryChartDto;
        }
    }

    public void writeDataToFile(QuoteHistoryChartDto quoteHistoryChartDto) {
        String currTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MMdd.HHmm.ss"));
        logger.debug("Time is - {}", currTime);
        try {
            String historicalDataPath = System.getProperty("user.home").concat(File.separator + "historical_data");
            File directory = new File(historicalDataPath);
            if (! directory.exists()){
                boolean status = directory.mkdir();
                logger.debug("Directory Creation status - {}", status);
            }
            logger.debug("System Home Path is - {}", historicalDataPath);
            File historicalDataFile = new File(
                    historicalDataPath.concat(File.separator + "TradeData.") +
                            quoteHistoryChartDto.getChart().getResult()[0].getMeta().getSymbol() + "." +
                            currTime +
                            ".csv"
            );

            if (historicalDataFile.createNewFile()) {
                logger.debug("File Created - {}", historicalDataFile.getName());
                try (FileWriter fw = new FileWriter(historicalDataFile)) {
                    fw.write(FILE_HEADER);
                    fw.write(NEW_LINE_SEPARATOR);
                    CandleData[] candleData = quoteHistoryChartDto.getChart().getResult()[0].getIndicators().getCandleData();
                    long[] timestamp = quoteHistoryChartDto.getChart().getResult()[0].getTimestamp();
                    for (int i = 0; i < timestamp.length; i++) {
                        long epochTime = timestamp[i];
                        float low = candleData[0].getLow()[i];
                        float high = candleData[0].getHigh()[i];
                        float open = candleData[0].getOpen()[i];
                        float close = candleData[0].getClose()[i];
                        fw.write(String.valueOf(epochTime));
                        fw.write(COMMA_DELIMITER);
                        fw.write(String.valueOf(open));
                        fw.write(COMMA_DELIMITER);
                        fw.write(String.valueOf(low));
                        fw.write(COMMA_DELIMITER);
                        fw.write(String.valueOf(close));
                        fw.write(COMMA_DELIMITER);
                        fw.write(String.valueOf(high));
                        fw.write(NEW_LINE_SEPARATOR);
                    }
                }
            } else {
                logger.debug("File already exists.");
            }
        } catch (IOException e) {
            logger.debug("An error occurred. {}", e.getMessage());
        }
    }
}
