package com.rowsun.myapplication.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    int id;
    String name, address;
    String[] interest;
    int[] number;
    String date;


    public Person(JSONObject object) {
        try {
            this.id = object.getInt("id");
            this.name = object.getString("name");
            this.address = object.getString("address");
            JSONArray inArray = object.getJSONArray("interest");
            setInterest(inArray);
            this.date = object.getString("date");
            //this.interest = new String[inArray.length()];


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> fromJson(String s) {
        List<Person> list = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(s);
            for (int i = 0; i < array.length(); i++) {
                Person p = new Person(array.getJSONObject(i));
                list.add(p);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getInterest() {
        return interest;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }

    public void setInterest(JSONArray interest) {
        this.interest = new String[interest.length()];
        for (int i = 0; i < interest.length(); i++) {
            try {
                this.interest[i] = interest.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", interest=" + Arrays.toString(interest) +
                ", number=" + Arrays.toString(number) +
                ", date='" + date + '\'' +
                '}';
    }
}
