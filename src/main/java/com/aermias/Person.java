package com.aermias;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String name;
    private Integer age;
    private Boolean isMale;

    Person() {}

    Person(String name) { this.name = name; }

    Person(String name, Integer age, Boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    String getName() { return name; }
    void setName(String name) { this.name = name; }

    Integer getAge() { return age; }
    void setAge(Integer age) { this.age = age; }

    Boolean getMale() { return isMale; }
    void setMale(Boolean male) { isMale = male; }

    @Override
    public String toString() {
        return "{ name: \"" + name + '\"' + ", age: " + age + ", isMale: " + isMale + " }";
    }
}
