package kr.ac.kumoh.s20220467.assignment_mongodb_backend.repository

import kr.ac.kumoh.s20220467.assignment_mongodb_backend.model.Guitar
import org.springframework.data.mongodb.repository.MongoRepository

interface GuitarRepository : MongoRepository<Guitar, String>{
    fun findByType(type: String): List<Guitar>
}