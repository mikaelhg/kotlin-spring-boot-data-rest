package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "restaurants")
class Restaurant {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    var name: String? = null

    var location: String? = null

    var lat: Double? = null

    var lng: Double? = null

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null

    override fun toString() = "Restaurant($id, $name, $location, $lat, $lng, ${menus?.map { it.id }})"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Restaurant

        if (id != other.id) return false
        if (name != other.name) return false
        if (location != other.location) return false
        if (lat != other.lat) return false
        if (lng != other.lng) return false
        if (menus != other.menus) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + (lat?.hashCode() ?: 0)
        result = 31 * result + (lng?.hashCode() ?: 0)
        return result
    }

}

@Entity
@Table(name = "menus")
class Menu {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant? = null

    @Column(name = "menu_date", columnDefinition = "DATE")
    var date: LocalDate? = null

    var title: String? = null

    @Column(name = "menu_text")
    var text: String? = null

    override fun toString() = "Menu($id, ${restaurant?.id}, $date, $title, $text)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Menu

        if (id != other.id) return false
        if (date != other.date) return false
        if (title != other.title) return false
        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (restaurant?.id?.hashCode() ?: 0)
        result = 31 * result + (date?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (text?.hashCode() ?: 0)
        return result
    }

}

@RepositoryRestResource
interface RestaurantRepository : JpaRepository<Restaurant, Long>

@RepositoryRestResource
interface MenuRepository : JpaRepository<Menu, Long>
