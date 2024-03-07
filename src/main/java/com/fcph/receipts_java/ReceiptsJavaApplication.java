package com.fcph.receipts_java;

import com.fcph.receipts_java.model.Receipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReceiptsJavaApplication {

    public static List<Receipt> receiptsMemory;
    public static void main(String[] args) {
        receiptsMemory = new ArrayList<>();
        SpringApplication.run(ReceiptsJavaApplication.class, args);
    }

}
