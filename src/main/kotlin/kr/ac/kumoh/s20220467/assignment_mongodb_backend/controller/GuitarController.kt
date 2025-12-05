package kr.ac.kumoh.s20220467.assignment_mongodb_backend.controller

import kr.ac.kumoh.s20220467.assignment_mongodb_backend.model.Guitar
import kr.ac.kumoh.s20220467.assignment_mongodb_backend.service.GuitarService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Sort

@RestController
@RequestMapping("/api/guitars")
@CrossOrigin(origins = ["http://localhost:5173"])
class GuitarController(
    private val service: GuitarService
) {
    @GetMapping
    fun getAllGuitars(
        @RequestParam(required = false, defaultValue = "priceAsc") sort: String,
        @RequestParam(required = false) keyword: String?
    ): List<Guitar> {
        val sortObj = when (sort) {
            "priceDesc" -> Sort.by(Sort.Direction.DESC, "price")
            "priceAsc" -> Sort.by(Sort.Direction.ASC, "price")
            else -> Sort.by(Sort.Direction.ASC, "model")
        }

        return service.getGuitars(keyword, sortObj)
    }

    @GetMapping("/{id}")
    fun getGuitarById(@PathVariable id: String): Guitar? = service.getGuitarById(id)
}