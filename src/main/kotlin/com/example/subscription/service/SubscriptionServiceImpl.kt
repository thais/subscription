package com.example.subscription.service

import com.example.subscription.model.Product
import com.example.subscription.model.SubscriptionRequest
import com.example.subscription.model.Subscription
import com.example.subscription.model.SubscriptionStatus
import com.example.subscription.repository.ProductRepository
import com.example.subscription.repository.SubscriptionRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class SubscriptionServiceImpl(private val repository: SubscriptionRepository, private val product: ProductRepository) : SubscriptionService {
    override fun create(subscription: SubscriptionRequest): Subscription {
        val product = product.getOne(subscription.id)
        return repository.save(
                Subscription(product = product,
                        name = subscription.name,
                        start = LocalDate.parse(subscription.start),
                        duration = subscription.duration,
                        expiration = LocalDate.parse(subscription.start).plusDays(subscription.duration.toLong()),
                        status = SubscriptionStatus.ACTIVE))
    }

    override fun findAll(): List<Subscription> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Subscription> = repository.findById(id)


    override fun changeStatus(id: Long, status: SubscriptionStatus): Optional<Subscription> {
        val optional = getById(id)
        if (optional.isEmpty) Optional.empty<Subscription>()

        return optional.map {
            val subscription = it.copy(status = status)
            repository.save(subscription)
        }
    }
}