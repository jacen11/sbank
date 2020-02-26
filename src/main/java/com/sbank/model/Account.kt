package com.sbank.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Account(
        @field:NotBlank val name: String,
        @field:NotNull val currency: Currency,
        var amount: BigDecimal = BigDecimal.ZERO,
        var cardId: Int? = null,
//        val user: User,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null)