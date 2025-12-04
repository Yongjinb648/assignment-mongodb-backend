package kr.ac.kumoh.s20220467.assignment_mongodb_backend.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoConfig {

    private val uri =
        "mongodb+srv://Sherpa:hp991115@cluster0.ekfdxsb.mongodb.net/guitar_db?retryWrites=true&w=majority&appName=Cluster0"

    @Bean
    fun mongoClient(): MongoClient =
        MongoClients.create(uri)

    @Bean
    fun mongoTemplate(mongoClient: MongoClient): MongoTemplate =
        MongoTemplate(mongoClient, "guitar_db")
}
