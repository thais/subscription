package com.example.subscription.service

import com.example.subscription.model.Product
import org.springframework.web.bind.annotation.RequestBody

interface ProductService {
    fun create(@RequestBody product: Product): Product

    fun findAll() : List<Product>
}