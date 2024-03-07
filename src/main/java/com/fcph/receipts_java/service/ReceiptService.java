package com.fcph.receipts_java.service;

import com.fcph.receipts_java.ReceiptsJavaApplication;
import com.fcph.receipts_java.constants.ReceiptConstants;
import com.fcph.receipts_java.model.Receipt;
import com.fcph.receipts_java.model.response.ReceiptId;
import com.fcph.receipts_java.service.impl.IReceiptService;
import com.fcph.receipts_java.utils.ReceiptRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService implements IReceiptService {

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Receipt> getAllReceipts() throws Exception {
        try {
            if (ReceiptsJavaApplication.receiptsMemory.isEmpty()) {
                throw new Exception(ReceiptConstants.NOT_DATA);
            }

            return ReceiptsJavaApplication.receiptsMemory;
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Receipt getReceiptById(String id) throws Exception {
        try {
            if(ReceiptsJavaApplication.receiptsMemory.isEmpty()) {
                throw new Exception(ReceiptConstants.RECEIPT_NOT_FOUND);
            }

            return ReceiptsJavaApplication.receiptsMemory.stream().filter(item -> item.getId().equals(id)).findFirst().get();
        }
        catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    /**
     * @param receipt
     * @return
     * @throws Exception
     */
    @Override
    public ReceiptId addReceipt(Receipt receipt) throws Exception {
        try {
            ReceiptId receiptId = ReceiptId.builder().id(String.valueOf(UUID.randomUUID())).build();
            receipt.setId(receiptId.getId());
            receipt.setPoints(ReceiptRules.calculatePoints(receipt));
            ReceiptsJavaApplication.receiptsMemory.add(receipt);
            return receiptId;
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
