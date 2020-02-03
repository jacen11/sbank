package com.sbank.service

import com.sbank.exceptions.NotFoundException
import com.sbank.model.Account
import com.sbank.repostory.AccountRepository
import com.sbank.repostory.TransferRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountServiceImpl(private val repo: AccountRepository, private val transferRepository: TransferRepository) : AccountService {
    override fun createAccount(account: Account): Account {
        return repo.save(account)
    }

    override fun updateAccount(account: Account): Account {
        return repo.save(account)
    }

    override fun getAccount(accountId: Long): Account {
        val account = repo.findById(accountId).orElseThrow { NotFoundException() }
        account.amount = transferRepository.findAll().filter { it.toAccountId == account.id }.sumBy { it.number }
        return account
    }

    override fun findAll(): Iterable<Account> {
        return repo.findAll()
    }
}

private inline fun <T> Iterable<T>.sumBy(selector: (T) -> BigDecimal): BigDecimal {
    val sum: BigDecimal = BigDecimal.ZERO
    for (element in this) {
        sum.plus(selector(element))
    }
    return sum
}
