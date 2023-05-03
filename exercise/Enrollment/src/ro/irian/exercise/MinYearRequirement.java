package ro.irian.exercise;

public class MinYearRequirement {

    private String uniClass;
    private int year;

    public MinYearRequirement(String uniClass, int year) {
        this.uniClass = uniClass;
        this.year = year;
    }

    public String getUniClass() {
        return uniClass;
    }

    public int getYear() {
        return year;
    }
}
