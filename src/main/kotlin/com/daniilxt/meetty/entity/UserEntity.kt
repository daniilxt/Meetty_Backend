package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.SimpleUserDto
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phone: String = "",
    val sex: String = "",
    val birthDay: LocalDate
)

fun UserEntity.toUserDto() = SimpleUserDto(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    avatarLink = ""
)