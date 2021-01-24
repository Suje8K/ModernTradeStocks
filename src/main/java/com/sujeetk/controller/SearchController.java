package com.sujeetk.controller;

import com.sujeetk.dto.Quote;
import com.sujeetk.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/")
public class SearchController {

    @Autowired
    private SearchService search;

    @GetMapping("/quote/{quoteName}")
    public ResponseEntity<Quote> searchQuote(@PathVariable String quoteName){
        return ResponseEntity.status(HttpStatus.OK).body(search.findQuote(quoteName));
    }
}
