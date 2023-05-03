package ro.irian.exercise;

public class MaxEnrolledRequirement {

    private String uniClass;
    private int maxEnrolledNo;

    public MaxEnrolledRequirement(String uniClass, int maxEnrolledNo) {
        this.uniClass = uniClass;
        this.maxEnrolledNo = maxEnrolledNo;
    }

    public String getUniClass() {
        return uniClass;
    }

    public int getMaxEnrolledNo() {
        return maxEnrolledNo;
    }
}
