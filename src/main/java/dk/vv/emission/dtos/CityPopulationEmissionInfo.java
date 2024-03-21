package dk.vv.emission.dtos;

public class CityPopulationEmissionInfo {


    private boolean isC40;

    private double population;

    private double totalEmissions;

    public CityPopulationEmissionInfo(boolean isC40, double population, double totalEmissions) {
        this.isC40 = isC40;
        this.population = population;
        this.totalEmissions = totalEmissions;
    }

    public boolean isC40() {
        return isC40;
    }

    public void setC40(boolean c40) {
        isC40 = c40;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(double totalEmissions) {
        this.totalEmissions = totalEmissions;
    }
}
