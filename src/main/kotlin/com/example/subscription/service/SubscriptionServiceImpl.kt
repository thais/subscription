package com.example.subscription.service

import com.example.subscription.model.SubsRequest
import com.example.subscription.model.Subscription
import com.example.subscription.repository.ProductRepository
import com.example.subscription.repository.SubscriptionRepository
import org.springframework.stereotype.Service

@Service
class SubscriptionServiceImpl(private val repository: SubscriptionRepository
                              , private val product: ProductRepository) : SubscriptionService {
    override fun create(subscription: SubsRequest): Subscription {
        val product = product.getOne(subscription.id)
        return repository.save(Subscription(product = product, name = subscription.name))
    }

    override fun findAll(): List<Subscription> {
        return repository.findAll()
    }
}