package com.sbank.sbank.service;

import com.sbank.sbank.model.Transfer;
import com.sbank.sbank.repostory.TransferRepository;
import com.sbank.sbank.service.TransferService;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    final TransferRepository repo;

    public TransferServiceImpl(TransferRepository repo) {
        this.repo = repo;
    }

    @Override
    public Transfer createTransfer(Transfer transfer) {
        return repo.save(transfer);
    }

    @Override
    public Transfer getTransfer(Long transferId) {
        return repo.findById(transferId).orElse(null);
    }
}
