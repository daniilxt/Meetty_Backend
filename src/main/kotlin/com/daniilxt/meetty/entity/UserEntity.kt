package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val sex: String
)

fun UserEntity.toUserDto() = UserDto(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    avatarLink = ""
)