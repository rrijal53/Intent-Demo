package com.rowsun.myapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmMyTable extends RealmObject {
    @PrimaryKey
    String id;

    String name;
    String add;


    public String getId() {
        return id;
    }

    public RealmMyTable() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
