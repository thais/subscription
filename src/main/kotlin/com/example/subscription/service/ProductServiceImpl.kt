package com.example.subscription.service

import com.example.subscription.model.Product
import com.example.subscription.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(private val repository: ProductRepository) : ProductService {
    override fun create(product: Product): Product = repository.save(product)

    override fun findAll(): List<Product> = repository.findAll()

    override fun getById(id: Long): Optional<Product> = repository.findById(id)
    override fun update(id: Long, product: Product): Optional<Product> {
        val optional = getById(id)
        if (optional.isEmpty) Optional.empty<Product>()

        return optional.map {
            val product = it.copy(
                    name = product.name,
                    duration = product.duration,
                    price = product.price,
                    tax = product.tax
            )
            repository.save(product)
        }
    }

    override fun delete(id: Long) =
            repository.findById(id).map {
                repository.delete(it)
            }.orElseThrow { throw RuntimeException("Id not found $id") }


}