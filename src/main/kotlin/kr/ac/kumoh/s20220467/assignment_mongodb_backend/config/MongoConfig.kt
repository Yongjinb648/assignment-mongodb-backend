package kr.ac.kumoh.s20220467.assignment_mongodb_backend.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.beans.factory.annotation.Value

@Configuration
class MongoConfig(

    @Value("\${spring.data.mongodb.uri}")
    private val uri: String
) {

    @Bean
    fun mongoClient(): MongoClient =
        MongoClients.create(uri)

    @Bean
    fun mongoTemplate(mongoClient: MongoClient): MongoTemplate =
        MongoTemplate(mongoClient, "guitar_db")
}
