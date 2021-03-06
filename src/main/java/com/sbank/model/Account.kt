package com.sbank.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Account(
        @field:NotBlank
        val name: String,

        @field:NotNull
        val currency: Currency,

        var amount: BigDecimal = BigDecimal.ZERO,

        var cardId: Int? = null,

        @field:ManyToOne @JsonIgnore
        var user: User? = null,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null)