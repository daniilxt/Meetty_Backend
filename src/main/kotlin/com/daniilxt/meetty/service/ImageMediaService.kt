package com.daniilxt.meetty.service

import org.springframework.web.multipart.MultipartFile

interface ImageMediaService {
    fun getUserProfileImage(userEmail: String): ByteArray
    fun saveProfileImage(userEmail: String, file: MultipartFile)
}