package com.aermias;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static Boolean isCollection(Object object) {
        return Collection.class.isAssignableFrom(object.getClass());
    }

    public static Boolean isMap(Object object) {
        return Map.class.isAssignableFrom(object.getClass());
    }

    static Object updateObjectFields(Object oldObject, Object newObject) throws Exception {
        Field[] fields = oldObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            Object oldValue = field.get(oldObject);
            Object newValue = field.get(newObject);

            // System.out.printf("old value : %s\nnew value : %s\n\n", oldValue, newValue);;

            if (isCollection(oldValue)) {
                if (((Collection) field.get(oldObject)).isEmpty()) field.set(newObject, oldValue);
            } else if (isMap(oldValue)) {
                if (((Map) field.get(oldObject)).isEmpty()) field.set(newObject, oldValue);
            }

            if (newValue == null) {
                field.set(newObject, oldValue);
            }
        }

        return newObject;
    }

    public static void main(String[] args) throws Exception {
        Person oldPerson = new Person("Mike Jones", 20, true);
        Person newPerson = new Person();

        // newPerson.setName("Sike Jones");
        newPerson.setAge(21);

        newPerson = (Person) updateObjectFields(oldPerson, newPerson);

        System.out.println(newPerson);
    }
}
