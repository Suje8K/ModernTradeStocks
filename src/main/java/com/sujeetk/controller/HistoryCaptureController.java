package com.sujeetk.controller;

import com.sujeetk.dto.QuoteHistoryChartDto;
import com.sujeetk.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history/")
public class HistoryCaptureController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/quote/{quoteName}")
    public ResponseEntity<QuoteHistoryChartDto> fetchHistoricalData(
            @PathVariable String quoteName,
            @RequestParam String interval,
            @RequestParam String range,
            @RequestParam boolean writeToFile
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(historyService.getHistory(quoteName, interval, range, writeToFile));
    }
}
