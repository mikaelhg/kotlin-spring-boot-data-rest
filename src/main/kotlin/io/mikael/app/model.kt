package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.*

@Entity @Table(name = "restaurants")
data class Restaurant(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    var location: String? = null,

    var lat: Double? = null,

    var lng: Double? = null,

    // use MutableList instead of List to work around Kotlin bug KT-9890
    @OneToMany(mappedBy = "restaurant")
    var menus: MutableList<Menu>? = null
)

@Entity @Table(name = "menus")
data class Menu(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant? = null,

    @Column(columnDefinition = "DATE")
    @Convert(converter = LocalDateConverter::class)
    var date: LocalDate? = null,

    var title: String? = null,

    var text: String? = null
)

@RepositoryRestResource(path = "restaurants")
public interface RestaurantRepository : JpaRepository<Restaurant, Long>

@RepositoryRestResource(path = "menus")
public interface MenuRepository : JpaRepository<Menu, Long>

