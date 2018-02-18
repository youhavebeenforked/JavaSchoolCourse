package ru.sberbank.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ComplexEntity {
    private String name;
    private List<SimpleEntity> list = new ArrayList<>();

    public ComplexEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SimpleEntity> getList() {
        return list;
    }

    public void setList(List<SimpleEntity> list) {
        this.list = list;
    }

    public void addEntity(SimpleEntity simpleEntity) {
        list.add(simpleEntity);
        simpleEntity.setParent(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexEntity that = (ComplexEntity) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
