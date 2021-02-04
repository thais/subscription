package com.example.subscription.model

import java.time.LocalDate
import javax.persistence.*


@Entity(name = "subscription")
data class Subscription(
        @Id @GeneratedValue
        val id: Long? = null,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        val product: Product,
        val name: String,
        val start: LocalDate,
        val duration: Int,
        val status: SubscriptionStatus,
        val expiration: LocalDate)

enum class SubscriptionStatus { ACTIVE, PAUSED, CANCELED }
