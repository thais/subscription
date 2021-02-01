package com.example.subscription

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController (private val repository: ProductRepository){

    @PostMapping
    fun create(@RequestBody product: Product): Product = repository.save(product)

    @GetMapping
    fun getAll(): List<Product> = repository.findAll()

    fun getById(@PathVariable id: Long): ResponseEntity<Product> =
            repository.findById(id).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product) : ResponseEntity<Product> =
            repository.findById(id).map {
                val product = it.copy(
                        name = it.name,
                        price = it.price
                )
                ResponseEntity.ok(repository.save(product))
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
            repository.findById(id).map {
                repository.delete(it)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
}