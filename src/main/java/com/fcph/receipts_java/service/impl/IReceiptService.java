package com.fcph.receipts_java.service.impl;

import com.fcph.receipts_java.model.Receipt;
import com.fcph.receipts_java.model.response.ReceiptId;
import com.fcph.receipts_java.model.response.ReceiptPoints;

import java.util.List;

public interface IReceiptService {

    public List<Receipt> getAllReceipts() throws Exception;

    public Receipt getReceiptById(String id) throws Exception;

    public ReceiptId addReceipt(Receipt receipt) throws Exception;


}
