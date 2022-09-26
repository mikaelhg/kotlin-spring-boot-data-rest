package io.mikael.app.test

import io.mikael.app.Menu
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders

@SpringBootTest(webEnvironment = RANDOM_PORT)
class InsertTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    private val jelly = mapOf(
            "date" to "2017-01-21",
            "title" to "Jellyfish Stew",
            "text" to "Slimy but delicious"
    )

    private val uriList = HttpHeaders().apply {
        add("Content-type", "text/uri-list")
    }

    @Test
    fun `create a menu and connect it to a restaurant`() {
        val loc = restTemplate.postForLocation("/menus", jelly)
        restTemplate.put("$loc/restaurant", HttpEntity("/restaurants/1", uriList))
        val m2 = restTemplate.getForObject("/restaurants/1/menus/2", Menu::class.java)
        Assertions.assertEquals(jelly["date"], m2.date.toString())
    }

}
