package com.daniilxt.meetty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeettyApplication

fun main(args: Array<String>) {
    runApplication<MeettyApplication>(*args)
}
