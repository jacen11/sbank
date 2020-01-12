package com.sbank.sbank.service;

import com.sbank.sbank.model.Transfer;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    Transfer createTransfer(Transfer transfer);

    Transfer getTransfer(Long transferId);
}
