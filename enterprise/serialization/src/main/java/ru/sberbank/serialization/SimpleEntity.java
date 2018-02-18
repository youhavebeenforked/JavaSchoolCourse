package ru.sberbank.serialization;

import java.time.LocalDateTime;
import java.util.Objects;

public class SimpleEntity {
    private String name;
    private LocalDateTime timeOfBirth;
    private ComplexEntity parent;

    public SimpleEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalDateTime timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public ComplexEntity getParent() {
        return parent;
    }

    public void setParent(ComplexEntity parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEntity entity = (SimpleEntity) o;
        return Objects.equals(name, entity.name) &&
                Objects.equals(timeOfBirth, entity.timeOfBirth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, timeOfBirth);
    }
}
