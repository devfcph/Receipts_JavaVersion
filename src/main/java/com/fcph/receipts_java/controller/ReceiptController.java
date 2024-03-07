package com.fcph.receipts_java.controller;

import com.fcph.receipts_java.constants.ReceiptConstants;
import com.fcph.receipts_java.model.Receipt;
import com.fcph.receipts_java.model.response.ReceiptId;
import com.fcph.receipts_java.service.ReceiptService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@RestController
@RequestMapping(ReceiptConstants.API)
public class ReceiptController {

    @Autowired
    ReceiptService service;

    @GetMapping("/health")
    public ResponseEntity<Object> healthCheck() {
        JsonObject json = new JsonObject();
        return new ResponseEntity<>("Hey! I'm available :)", HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<Object> getReceipts() {
        try {
            List<Receipt> response = service.getAllReceipts();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return  new ResponseEntity<>("Bad request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getReceiptById(@PathVariable String id) {
        try {
            Receipt response = service.getReceiptById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return  new ResponseEntity<>("Bad request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/process")
    public ResponseEntity<Object> processReceipt(@RequestBody Receipt receipt) {
        try {
            ReceiptId response = service.addReceipt(receipt);
            return  new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return  new ResponseEntity<>("Bad request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
