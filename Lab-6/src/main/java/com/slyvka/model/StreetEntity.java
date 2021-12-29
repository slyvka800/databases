package com.slyvka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "street", schema = "Slyvka", catalog = "")
public class StreetEntity {
    private String name;

    public StreetEntity() {

    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetEntity that = (StreetEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public StreetEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StreetEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
