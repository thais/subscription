package com.example.subscription.service

import com.example.subscription.model.Product
import com.example.subscription.model.SubscriptionRequest
import com.example.subscription.model.Subscription
import com.example.subscription.model.SubscriptionStatus
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface SubscriptionService {
    fun create(@RequestBody subscription: SubscriptionRequest): Subscription

    fun findAll() : List<Subscription>

    fun getById(id: Long): Optional<Subscription>

    fun changeStatus(id: Long, status: SubscriptionStatus) : Optional<Subscription>

}