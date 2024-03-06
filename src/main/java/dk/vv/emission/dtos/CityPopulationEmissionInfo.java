package dk.vv.emission.dtos;

public class CityPopulationEmissionInfo {


    private boolean isC40;

    private float population;

    private float totalEmissions;

    public CityPopulationEmissionInfo(boolean isC40, float population, float totalEmissions) {
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

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public float getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(float totalEmissions) {
        this.totalEmissions = totalEmissions;
    }
}
