package com.sbank.rest;

import com.sbank.model.Transfer;
import com.sbank.service.TransferService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public List<Transfer> getAllTransfer() {
        return transferService.getAll();
    }

    @GetMapping("/{id}")
    public     Transfer getTransfer(@Valid @PathVariable("id") Long id) {
        return transferService.getTransfer(id);
    }

    @PostMapping
    public Transfer createTransfer(@Valid @RequestBody Transfer transfer) {
        return transferService.createTransfer(transfer);
    }
}
