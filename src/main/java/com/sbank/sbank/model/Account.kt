package com.sbank.sbank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Account(
        @field:NotBlank val name: String,
        @field:NotNull val number: String,
        @field:NotNull val currency: Currency,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null)