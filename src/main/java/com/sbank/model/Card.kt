package com.sbank.model

import javax.persistence.*

@MappedSuperclass
abstract class Card(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                    open val id: Long? = null)