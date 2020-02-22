package com.sbank.service;

import com.sbank.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer createTransfer(Transfer transfer);

    Transfer getTransfer(Long transferId);

    List<Transfer> getAll();
}
