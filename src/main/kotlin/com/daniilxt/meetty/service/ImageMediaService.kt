package com.daniilxt.meetty.service

import org.springframework.web.multipart.MultipartFile

interface ImageMediaService {
    fun getUserProfileImage(userEmail: String): ByteArray
    fun getUserProfileByUserId(userId: Long): ByteArray
    fun saveProfileImage(userEmail: String, file: MultipartFile)
    fun saveProfileImageByUserId(userId: Long, file: MultipartFile)
}
