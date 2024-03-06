package dk.vv.emission.dtos;

public class CityTargetInformation {
    private float target;

    private String city;

    private int targetYear;




    public CityTargetInformation(float target, String city, int targetYear) {
        this.target = target;
        this.city = city;
        this.targetYear = targetYear;
    }

    public float getTarget() {
        return target;
    }

    public void setTarget(float target) {
        this.target = target;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(int targetYear) {
        this.targetYear = targetYear;
    }
}
