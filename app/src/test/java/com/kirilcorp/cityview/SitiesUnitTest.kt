package com.kirilcorp.cityview

import org.junit.Test

import org.junit.Assert.*

class SitiesUnitTest {

    private val sities= Sities("Lugar",
        "Es un gran lugar",
        "3.6",
        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4b/e0/6d/a-small-clearing-area.jpg?w=500&h=-1&s=1",
        "19°C",
        "Lunes a Domingo abierto las 24 horas",
        "$10",
        "-21.249353,-159.730520")

    @Test
    fun name_isCorrect() {
        assertEquals("Lugar", sities.name)
    }

    @Test
    fun image_isCorrect() {
        assertEquals("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4b/e0/6d/a-small-clearing-area.jpg?w=500&h=-1&s=1", sities.image)
    }

    @Test
    fun score_isCorrect() {
        assertEquals("3.6", sities.score)
    }

    @Test
    fun schedule_isCorrect() {
        assertEquals("Lunes a Domingo abierto las 24 horas", sities.schedule)
    }

    @Test
    fun ubication_isCorrect() {
        assertEquals("-21.249353,-159.730520", sities.ubication)
    }

    @Test
    fun price_isCorrect() {
        assertEquals("$10", sities.price)
    }

    @Test
    fun description_isCorrect() {
        assertEquals("Es un gran lugar", sities.descriptio)
    }

    @Test
    fun temperature_isCorrect() {
        assertEquals("19°C", sities.temperature)
    }
}
