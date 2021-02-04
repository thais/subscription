package com.example.subscription.service

import com.example.subscription.model.Product
import com.example.subscription.model.SubsRequest
import com.example.subscription.model.Subscription
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface SubscriptionService {
    fun create(@RequestBody subscription: SubsRequest): Subscription

    fun findAll() : List<Subscription>
}