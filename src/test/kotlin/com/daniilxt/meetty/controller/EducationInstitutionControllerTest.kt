package com.daniilxt.meetty.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = [
        "spring.datasource.url=jdbc:postgresql://localhost:5432/meetty"
    ]
)
internal class EducationInstitutionControllerTest(@Autowired val client: TestRestTemplate) {
    @Test
    fun `return ok in edu endpoint`() {
        val entity = client.getForEntity<String>("/api/v1/regsteps/edu")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isNotEmpty
    }

    @Test
    fun `return ok in interests endpoint`() {
        val entity = client.getForEntity<String>("/api/v1/regsteps/interests")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isNotEmpty
    }
}