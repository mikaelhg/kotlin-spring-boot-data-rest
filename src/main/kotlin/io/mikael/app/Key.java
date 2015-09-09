package io.mikael.app;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Unfortunately Kotlin Java interop doesn't allow for normal {@code @Id var Long} type
 * fields, so we have to create an embeddable ID, and do it in Java.
 */
@Embeddable
public class Key implements Serializable {

    @Column(name="id", columnDefinition = "bigint")
    private Long id;

    public Key() { }

    public Key(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id != null ? id.toString() : "null";
    }

}
