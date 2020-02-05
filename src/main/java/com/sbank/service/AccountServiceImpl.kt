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
        account.amount = getAmount(account)
        return account
    }

    override fun findAll(): Iterable<Account> {
        val accounts: MutableIterable<Account> = repo.findAll()
        accounts.forEach { account -> account.amount = getAmount(account) }
        return accounts
    }

    private fun getAmount(account: Account) =
            transferRepository
                    .findAll()
                    .filter { it.toAccountId == account.id }
                    .fold(BigDecimal.ZERO) { sum, it -> sum.plus(it.number) }

}

