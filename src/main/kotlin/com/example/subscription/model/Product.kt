package com.example.subscription.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "products")
data class Product(
        @Id @GeneratedValue
        val id: Long? = null,
        val name: String,
        val duration: Int,
        val price: Double,
        val tax: Double
)