package ro.irian.exercise;

import java.time.LocalDate;
import java.util.List;

public class Student {
    private String id;
    private String name;

    private int year;

    private List<String> classes;

    private String specialty;

    private LocalDate enrolledInSoftwareDesignFrom;

    private LocalDate enrolledInComputerEngineeringFrom;

    public Student(String id, String name, int year, List<String> classes, String specialty, LocalDate enrolledInSoftwareDesignFrom, LocalDate enrolledInComputerEngineeringFrom) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.classes = classes;
        this.specialty = specialty;
        this.enrolledInSoftwareDesignFrom = enrolledInSoftwareDesignFrom;
        this.enrolledInComputerEngineeringFrom = enrolledInComputerEngineeringFrom;
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

    public void setEnrolledInSoftwareDesignFrom(LocalDate enrolledInSoftwareDesignFrom) {
        this.enrolledInSoftwareDesignFrom = enrolledInSoftwareDesignFrom;
    }

    public void setEnrolledInComputerEngineeringFrom(LocalDate enrolledInComputerEngineeringFrom) {
        this.enrolledInComputerEngineeringFrom = enrolledInComputerEngineeringFrom;
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

    public LocalDate getEnrolledInSoftwareDesignFrom() {
        return enrolledInSoftwareDesignFrom;
    }

    public LocalDate getEnrolledInComputerEngineeringFrom() {
        return enrolledInComputerEngineeringFrom;
    }
}
