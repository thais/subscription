package com.example.subscription.service

import com.example.subscription.model.Product
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface ProductService {
    fun create(@RequestBody product: Product): Product

    fun findAll() : List<Product>

    fun getById(id: Long): Optional<Product>

    fun update(id: Long, product: Product) : Optional<Product>

    fun delete(id: Long)
}