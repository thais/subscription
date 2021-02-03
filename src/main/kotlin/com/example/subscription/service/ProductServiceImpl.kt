package com.example.subscription.service

import com.example.subscription.model.Product
import com.example.subscription.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val repository: ProductRepository) : ProductService {
    override fun create(product: Product): Product = repository.save(product)

    override fun findAll(): List<Product> = repository.findAll()


}