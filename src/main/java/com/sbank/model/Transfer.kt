package com.sbank.model

import org.hibernate.validator.constraints.Length
import org.springframework.lang.NonNull
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

@Entity
@Table(name = "transfer")
data class Transfer(
        @field:NotNull
        val currency: Currency? = null,

        @field:NonNull
        val fromAccountId: Long,

        @field:NonNull
        val toAccountId: Long,

        @field:Length(max = 2048, message = "Message too long (more than 2kB)")
        val message:String,

        @field:Digits(integer = 24, fraction = 0, message = "Не более 24-х знаков") @field:NotNull
        val number: BigDecimal = BigDecimal.ZERO,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null)
