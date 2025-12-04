package kr.ac.kumoh.s20220467.assignment_mongodb_backend.controller

import kr.ac.kumoh.s20220467.assignment_mongodb_backend.model.Guitar
import kr.ac.kumoh.s20220467.assignment_mongodb_backend.service.GuitarService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/guitars")
class GuitarController(
    private val service: GuitarService
) {
    @GetMapping
    fun getAllGuitars(): List<Guitar> = service.getAllGuitars()

    @GetMapping("/{id}")
    fun getGuitarById(@PathVariable id: String): Guitar? = service.getGuitarById(id)
}