package ro.irian.exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private List<MinYearRequirement> minYearRequirements;
    private List<MaxEnrolledRequirement> maxEnrolledRequirements;

    public University() {
        students = new ArrayList<>();
        Student george = new Student("001", "George", 1, new ArrayList<>(), "CTI", null, null);
        Student andrei = new Student("002", "Andrei", 2, new ArrayList<>(), "TI", null, null);

        students.add(george);
        students.add(andrei);

        minYearRequirements = new ArrayList<>();
        minYearRequirements.add(new MinYearRequirement("Math", 1));
        minYearRequirements.add(new MinYearRequirement("Physics", 1));
        minYearRequirements.add(new MinYearRequirement("Data structures", 2));
        minYearRequirements.add(new MinYearRequirement("Algorithms", 2));
        minYearRequirements.add(new MinYearRequirement("Database engineering", 2));
        minYearRequirements.add(new MinYearRequirement("Mechanical engineering", 3));
        minYearRequirements.add(new MinYearRequirement("Security", 3));
        minYearRequirements.add(new MinYearRequirement("Project management", 4));
        minYearRequirements.add(new MinYearRequirement("Software testing", 4));

        maxEnrolledRequirements = new ArrayList<>();
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Math", 2));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Physics", 20));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Data structures", 50));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Algorithms", 50));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Database engineering", 35));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Mechanical engineering", 20));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Security", 50));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Project management", 40));
        maxEnrolledRequirements.add(new MaxEnrolledRequirement("Software testing", 35));
    }

    public Student enrol(String id, String name, int year, String uniClass, String studentSpecialty) {
        for (MaxEnrolledRequirement maxEnrolledRequirement : maxEnrolledRequirements) {
            if (maxEnrolledRequirement.getUniClass().equals(uniClass)) {
                int totalEnrolled = 0;
                for (Student student : students) {
                    if (student.getClasses() != null) {
                        for (String studentUniClass : student.getClasses()) {
                            if (studentUniClass.equals(uniClass)) {
                                totalEnrolled++;
                            }
                        }
                    }
                }
                if (totalEnrolled == maxEnrolledRequirement.getMaxEnrolledNo()) {
                    throw new RuntimeException("Max enrollment number reached for this class.");
                }
            }
        }

        boolean ok = false;
        for (Student student:students) {
            if (student.getId().equals(id)) {
                ok = true;
                for (MinYearRequirement minYearRequirement : minYearRequirements) {
                    if (minYearRequirement.getUniClass().equals(uniClass)) {
                        if (minYearRequirement.getYear() > student.getYear()) {
                            throw new RuntimeException("Minimum year requirement is not met.");
                        }
                    }
                }
                if (student.getClasses() != null) {
                    if (uniClass.equals("Software Design")) {
                        if (student.getSpecialty().equals("CTI")) {
                            student.getClasses().add(uniClass);
                        }
                    }
                    else {
                        if (uniClass.equals("Computer Science")) {
                            if (student.getSpecialty().equals("TI")) {
                                student.getClasses().add(uniClass);
                            }
                        }
                        else {
                            student.getClasses().add(uniClass);
                        }
                    }
                }
                else {
                    student.setClasses(new ArrayList<>());
                    if (uniClass.equals("SOFTWARE_DESIGN")) {
                        if (student.getSpecialty().equals("CTI")) {
                            student.getClasses().add(uniClass);
                            student.setEnrolledInSoftwareDesignFrom(LocalDate.now());
                        }
                    }
                    else {
                        if (uniClass.equals("COMPUTER_SCIENCE")) {
                            if (student.getSpecialty().equals("TI")) {
                                student.getClasses().add(uniClass);
                                student.setEnrolledInComputerEngineeringFrom(LocalDate.now());
                            }
                        }
                        else {
                            student.getClasses().add(uniClass);
                        }
                    }
                }
                return student;
            }
        }
        if (!ok) {
            List<String> classes = new ArrayList<>();
            LocalDate enrolledInSoftwareDesignFrom = null;
            LocalDate enrolledInComputerEngineeringFrom = null;

            for (MinYearRequirement minYearRequirement:minYearRequirements) {
                if (minYearRequirement.getUniClass().equals(uniClass)) {
                    if (minYearRequirement.getYear() > year) {
                        throw new RuntimeException("Minimum year requirement is not met.");
                    }
                }
            }

            if (uniClass.equals("SOFTWARE_DESIGN")) {
                if (studentSpecialty.equals("CTI")) {
                    classes.add(uniClass);
                    enrolledInSoftwareDesignFrom = LocalDate.now();
                }
            }
            else {
                if (uniClass.equals("COMPUTER_SCIENCE")) {
                    if (studentSpecialty.equals("TI")) {
                        classes.add(uniClass);
                        enrolledInComputerEngineeringFrom = LocalDate.now();
                    }
                }
                else {
                    classes.add(uniClass);
                }
            }
            Student newStudent = new Student(id, name, year, classes, studentSpecialty, enrolledInSoftwareDesignFrom, enrolledInComputerEngineeringFrom);;
            students.add(newStudent);
            return new Student(id, name, year, classes, studentSpecialty, enrolledInSoftwareDesignFrom, enrolledInComputerEngineeringFrom);
        }
        return null;
    }

    public List<Student> getStudentsInClass(String uniClass){
        List<Student> result = new ArrayList<>();
        for (Student student:students) {
            if (student.getClasses() != null) {
                for (String studentUniClass : student.getClasses()) {
                    if (studentUniClass.equals(uniClass)) {
                        result.add(student);
                    }
                }
            }
        }

        return result;
    }

    public List<Student> getStudentsByYear(int year){
        List<Student> result = new ArrayList<>();
        for (Student student:students) {
            if (student.getYear() == year) {
                result.add(student);
            }
        }

        return result;
    }
}
