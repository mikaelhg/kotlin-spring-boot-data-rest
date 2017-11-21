package io.mikael.app.test

import io.mikael.app.Menu
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = DEFINED_PORT, properties = arrayOf("server.port=39797"))
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
    fun insertTest() {
        val newMenuUri = restTemplate.postForLocation("/menus", jelly)

        val httpEntity = HttpEntity("/restaurants/1", uriList)
        restTemplate.exchange("$newMenuUri/restaurant", HttpMethod.PUT, httpEntity, String::class.java)

        val m2 = restTemplate.getForObject("/restaurants/1/menus/2", Menu::class.java)
        Assert.assertEquals(jelly["date"], m2.date.toString())
    }

}