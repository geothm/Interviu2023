package ro.irian.exercise;

public class Main {

    public static void main(String[] args) {
        University university = new University();

        shouldPrint(university);
        //shouldThrowMinYearException(university);
        //shouldThrowMaxEnrollmentException(university);

        System.out.println("Students enrolled in Math class:");
        university.getStudentsInClass("Math")
                        .forEach(student -> System.out.println(student.getName()));

        System.out.println("Students in year 1:");
        university.getStudentsByYear(1)
                        .forEach(student -> System.out.println(student.getName()));

        //TODO
        //System.out.println("All Students alphabetically:");
        //university.getAllStudentsAlphabetically()
        //        .forEach(student -> System.out.println(student.getName()));;
    }

    public static void shouldPrint(University university) {
        university.enrol("001", "George", 1, "Math", "CTI");
        university.enrol("002", "Andrei", 2, "Math", "TI");
    }

    public static void shouldThrowMinYearException(University university) {
        university.enrol("003", "Paul", 3, "Software testing", "TI");
    }

    public static void shouldThrowMaxEnrollmentException(University university) {
        university.enrol("004", "Ioana", 2, "Math", "CTI");
    }
}
