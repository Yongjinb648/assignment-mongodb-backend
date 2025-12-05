package kr.ac.kumoh.s20220467.assignment_mongodb_backend.service

import kr.ac.kumoh.s20220467.assignment_mongodb_backend.model.Guitar
import kr.ac.kumoh.s20220467.assignment_mongodb_backend.repository.GuitarRepository
import org.springframework.stereotype.Service
import org.springframework.data.domain.Sort

@Service
class GuitarService (
    private val repository: GuitarRepository
) {
    fun getAllGuitars(): List<Guitar> = repository.findAll()
    fun getGuitarById(id: String): Guitar? = repository.findById(id).orElse(null)
    fun getGuitars(keyword: String?, sort: Sort): List<Guitar> =
        if (!keyword.isNullOrBlank()) {
            repository.findByModelContainingIgnoreCase(keyword, sort)
        } else {
            repository.findAll(sort)
        }
}