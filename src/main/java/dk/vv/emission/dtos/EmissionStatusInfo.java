package dk.vv.emission.dtos;

public class EmissionStatusInfo {

    private int year;
    private long count;
    private long increased;
    private long decreased;


    public EmissionStatusInfo(int year, long count, long increased, long decreased) {
        this.year = year;
        this.count = count;
        this.increased = increased;
        this.decreased = decreased;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getIncreased() {
        return increased;
    }

    public void setIncreased(long increased) {
        this.increased = increased;
    }

    public long getDecreased() {
        return decreased;
    }

    public void setDecreased(long decreased) {
        this.decreased = decreased;
    }
}
