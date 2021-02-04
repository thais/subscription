package com.example.subscription.controller

import com.example.subscription.model.Product
import com.example.subscription.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody product: Product): Product = productService.create(product)

    @GetMapping
    fun getAll(): List<Product> = productService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Product> =
            productService.getById(id).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> =
            productService.update(id, product).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        productService.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}