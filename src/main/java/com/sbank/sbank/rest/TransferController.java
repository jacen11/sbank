package com.sbank.sbank.rest;

import com.sbank.sbank.model.Transfer;
import com.sbank.sbank.service.TransferService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/transfer/{transferId}")
    public @ResponseBody
    Transfer getTransfer(@PathVariable @Valid Long transferId) {
        return transferService.getTransfer(transferId);
    }

    @PostMapping("/createTransfer")
    public Transfer createTransfer(@Valid @RequestBody Transfer transfer) {
        return transferService.createTransfer(transfer);
    }
}
