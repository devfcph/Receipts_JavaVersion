package com.fcph.receipts_java.controller;

import com.fcph.receipts_java.constants.ReceiptConstants;
import com.fcph.receipts_java.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping(ReceiptConstants.API)
public class ReceiptController {

    @Autowired
    ReceiptService service;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Hey! I'm available :)");
    }
}
