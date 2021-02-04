package com.example.subscription.controller

import com.example.subscription.model.SubscriptionRequest
import com.example.subscription.model.Subscription
import com.example.subscription.model.SubscriptionStatus
import com.example.subscription.service.SubscriptionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscription")
class SubscriptionController(private val service: SubscriptionService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody subscription: SubscriptionRequest): Subscription = service.create(subscription)

    @GetMapping
    fun getAll(): List<Subscription> = service.findAll()

    @PutMapping("/pause/{id}")
    fun pause(@PathVariable id: Long): ResponseEntity<Subscription> =
            service.changeStatus(id, SubscriptionStatus.PAUSED).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/unpause/{id}")
    fun unpause(@PathVariable id: Long): ResponseEntity<Subscription> =
            service.changeStatus(id, SubscriptionStatus.ACTIVE).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/cancel/{id}")
    fun cancel(@PathVariable id: Long): ResponseEntity<Subscription> =
            service.changeStatus(id, SubscriptionStatus.CANCELED).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

}