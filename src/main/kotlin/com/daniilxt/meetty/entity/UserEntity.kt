package com.daniilxt.meetty.entity

import com.daniilxt.meetty.config.AppConstantsConfig
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
    val birthDay: LocalDate,
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "profile_picture")
    var profilePicture: ByteArray?
)

fun UserEntity.toUserDto() = SimpleUserDto(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    avatarLink = AppConstantsConfig.IMAGE_PROFILE_ENDPOINT + this.id,
    sex = sex
)