package io.mikael.app;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Key implements Serializable {

    @Column(name="id", columnDefinition = "bigint")
    private Long id;

    public Key(final Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(Long id) {
        this.id = id;
    }
}
