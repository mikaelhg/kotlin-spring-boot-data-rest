package io.mikael.app

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "restaurants")
class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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