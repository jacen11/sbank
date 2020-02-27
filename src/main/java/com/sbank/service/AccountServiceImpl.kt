package com.sbank.service

import com.sbank.model.Account
import com.sbank.repostory.AccountRepository
import com.sbank.repostory.UserRepository
import com.sbank.repostory.TransferRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class AccountServiceImpl(private val repo: AccountRepository,
                         private val transferRepository: TransferRepository,
                         private val userRepository: UserRepository) : AccountService {
    @Transactional
    override fun createAccount(userId: Long, account: Account): Account? {
        account.user = userRepository.findById(userId).get()
        return repo.save(account)
    }

    override fun updateAccount(account: Account): Account {
        return repo.save(account)
    }

    override fun getAccount(userId: Long, accountId: Long): Account? {
        return repo.findByIdAndUserId(accountId, userId).get()
    }

    override fun findAll(): Iterable<Account> {
        val accounts: MutableIterable<Account> = repo.findAll()
        accounts.forEach { account -> account.amount = getAmount(account) }
        return accounts
    }

    private fun getAmount(account: Account) =
            transferRepository
                    .findAllByAccountId(account.id)
                    .fold(BigDecimal.ZERO) { sum, it -> sum.plus(it.number) }
}
