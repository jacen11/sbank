package com.sbank.rest

import com.sbank.model.Currency
import com.sbank.model.Transfer
import com.sbank.service.TransferService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
@RequestMapping("/api/dev")
class DevelopController(val transferService: TransferService) {

    @PutMapping("/refill")
    fun refill(account: Long, number: BigDecimal): Transfer? {
        val transfer = Transfer(Currency.USD, 1L, account, number)
        return transferService.createTransfer(transfer)
    }

}