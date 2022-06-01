package com.daniilxt.meetty.controller

import com.daniilxt.meetty.service.ImageMediaService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/media")
class MediaController(
    private val imageMediaService: ImageMediaService
) {
    @PostMapping(value = ["/image/profile/change"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadImage(@RequestParam file: MultipartFile): ResponseEntity.BodyBuilder {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        imageMediaService.saveProfileImage(authenticatedUserEmail, file)
        return ResponseEntity.ok()
    }

    @PostMapping(value = ["/image/profile/change/{id}"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun setImageByUserId(@PathVariable("id") id: Long, @RequestParam file: MultipartFile): ResponseEntity.BodyBuilder {
        imageMediaService.saveProfileImageByUserId(id, file)
        return ResponseEntity.ok()
    }

    @GetMapping("/image/profile/my")
    fun getImage(): ResponseEntity<Any> {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        val image = imageMediaService.getUserProfileImage(authenticatedUserEmail)
        return try {
            ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${System.currentTimeMillis()}\"")
                .body(image)
        } catch (_: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/image/profile/{id}")
    fun getImageByUserId(@PathVariable("id") userId: Long): ResponseEntity<Any> {
        val image = imageMediaService.getUserProfileByUserId(userId)
        return try {
            ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${System.currentTimeMillis()}\"")
                .body(image)
        } catch (_: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MediaController::class.java)
    }
}