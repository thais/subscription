package com.example.subscription

import com.example.subscription.model.Product
import com.example.subscription.repository.ProductRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var productRepository: ProductRepository

    @Test
    fun `find all products`() {
        productRepository.save(Product(name = "Lambada Dance class", duration = 30, price = 20.00, tax = 2.00))
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("\$").isArray)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].id").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].name").isString)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].price").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].tax").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].duration").isNumber)
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `find by id`() {
        val product = productRepository.save(
                Product(name = "Lambada Dance class", duration = 30, price = 20.00, tax = 2.00)
        )
        mockMvc.perform(MockMvcRequestBuilders.get("/products/${product.id}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("\$").isArray)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].id").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].name").isString)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].price").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].tax").isNumber)
                .andExpect(MockMvcResultMatchers.jsonPath("\$[0].duration").isNumber)
                .andDo(MockMvcResultHandlers.print())
    }


}