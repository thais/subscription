package com.example.subscription.repository

import com.example.subscription.model.Product
import com.example.subscription.model.Subscription
import org.springframework.data.jpa.repository.JpaRepository

interface SubscriptionRepository : JpaRepository<Subscription, Long>