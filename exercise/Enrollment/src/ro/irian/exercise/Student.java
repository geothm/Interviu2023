package ro.irian.exercise;

import java.util.List;

public class Student {
    private String id;
    private String name;

    private int year;

    private List<String> classes;

    private String specialty;

    public Student(String id, String name, int year, List<String> classes, String specialty) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.classes = classes;
        this.specialty = specialty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<String> getClasses() {
        return classes;
    }

    public String getSpecialty() {
        return specialty;
    }
}
