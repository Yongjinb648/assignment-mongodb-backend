package kr.ac.kumoh.s20220467.assignment_mongodb_backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "guitars")
data class Guitar(
    @Id val id: String?= null,
    val model: String,
    val type: String,
    val pickup: String,
    val bridge: String,
    val color: String,
    val price: Int,
)
