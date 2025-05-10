package com.hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private int id;
    private String name;
    private int age;
    private String gender;
    private List<String> healthRecords = new ArrayList<>();

    public Patient(int id,String name, int age, String gender) {
    	this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public int getId() {
    	return id;
    }

    public String getName() {
        return name;
    }

    public void addHealthRecord(String record) {
        healthRecords.add(record);
    }
    
    public List<String> getHealthRecords() {
        return healthRecords;
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + "name='" + name + "', age=" + age + ", gender='" + gender + "', records=" + healthRecords + "}";
    }
}