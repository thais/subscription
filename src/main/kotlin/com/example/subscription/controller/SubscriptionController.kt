package com.example.subscription.controller

import com.example.subscription.model.SubsRequest
import com.example.subscription.model.Subscription
import com.example.subscription.service.SubscriptionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscription")
class SubscriptionController(private val service: SubscriptionService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody subscription: SubsRequest): Subscription = service.create(subscription)

    @GetMapping
    fun getAll(): List<Subscription> = service.findAll()
}