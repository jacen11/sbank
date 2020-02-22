package com.sbank.service;

import com.sbank.model.Transfer;
import com.sbank.repostory.TransferRepository;
import com.sbank.service.TransferService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Transfer> getAll() {
        return repo.findAll();
    }
}
