package com.fcph.receipts_java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {

    private String id;
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private String total;
    private Integer points;
    private List<ReceiptItem> Items;

}
