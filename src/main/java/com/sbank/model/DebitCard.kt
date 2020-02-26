package com.sbank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class DebitCard(override val id:Long?=null,
                     var name:String? = null) : Card(id)