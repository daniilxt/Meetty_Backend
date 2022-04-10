package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.dto.UserDto
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "message")
class MessageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val date: LocalDate,
    val time: LocalTime,
    val content: String,
    @OneToOne
    @JoinColumn(name = "sender_id")
    val sender: UserEntity,
    @OneToOne
    @JoinColumn(name = "dialog_id")
    val dialog: DialogEntity
)

fun MessageEntity.toMessageDto() = MessageDto(
    id = this.id,
    date = this.date,
    time = this.time,
    content = this.content,
    sender = this.toUserDto()
)

fun MessageEntity.toUserDto() = UserDto(
    id = this.sender.id,
    firstName = this.sender.firstName,
    lastName = this.sender.lastName,
    avatarLink = ""
)
