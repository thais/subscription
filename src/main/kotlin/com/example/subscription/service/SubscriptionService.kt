package com.example.subscription.service

import com.example.subscription.model.SubscriptionRequest
import com.example.subscription.model.Subscription
import org.springframework.web.bind.annotation.RequestBody

interface SubscriptionService {
    fun create(@RequestBody subscription: SubscriptionRequest): Subscription

    fun findAll() : List<Subscription>
}