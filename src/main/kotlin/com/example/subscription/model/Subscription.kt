package com.example.subscription.model

import javax.persistence.*


@Entity(name = "subscription")
data class Subscription(
        @Id @GeneratedValue
        val id: Long? = null,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        val product: Product,
        val name: String)
