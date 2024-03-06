package dk.vv.emission;

import dk.vv.emission.dtos.*;
import dk.vv.emission.repositories.CityRepository;
import dk.vv.emission.repositories.EmissionRepository;
import dk.vv.emission.repositories.EmissionTargetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmissionInformationFacade {


    @Inject
    CityRepository cityRepository;

    @Inject
    EmissionRepository emissionRepository;

    @Inject
    EmissionTargetRepository emissionTargetRepository;


    public List<TempEmissionInformation> getTempEmissionInformation(){
        List<CityDTO> cities = cityRepository.getCitiesWithAvgTemp();
        List<EmissionDTO> emissionDTOS = emissionRepository.getEmissionAndCityId();

        List<TempEmissionInformation> result = new ArrayList<>();


        for (CityDTO city : cities) {
            Float totalEmission = null;
            for (EmissionDTO emissionDTO : emissionDTOS) {
                if(emissionDTO.getCityId() == city.getId()){

                    totalEmission = emissionDTO.getTotalEmissions();
                }
            }
            TempEmissionInformation tempEmissionInformation = new TempEmissionInformation(city.getId(), city.getAverageAnnualTemperature(), city.getCityName(), totalEmission);
            result.add(tempEmissionInformation);
        }
        return result;
    }


    public List<CountryAvgEmissionInfo> getCountryAvgEmissionInfo(){
        return cityRepository.getAverageEmissionsByCountry();
    }


    public List<CityTargetInformation> getCitiesWithCO2NeutralTargets(){
        return cityRepository.getCitiesWithCO2NeutralTargets();
    }

    public List<AvgTargetInformation> getAvgTargetInformation(){
        return cityRepository.getAverageForCitesAndIsC40();
    }


    public AvgEmissionPerCitizenInfo getAvgEmissionsPerCitizenInfo(){
        var infos = cityRepository.getCityEmissionsAndPopulation();

        float totalPopC40 = 0;
        float totalPopNonC40 = 0;
        float totalEmissionsC40 = 0;
        float totalEmissionsNonC40= 0;

        for (CityPopulationEmissionInfo info : infos) {
            if(info.isC40()){
                totalEmissionsC40 += info.getTotalEmissions();
                totalPopC40 += info.getPopulation();
            } else {
                totalEmissionsNonC40 += info.getTotalEmissions();
                totalPopNonC40 += info.getPopulation();
            }
        }

        var avgPerCitizenC40 = totalEmissionsC40/totalPopC40;
        var avgPerCitizenNonC40 = totalEmissionsNonC40/totalPopNonC40;

        return new AvgEmissionPerCitizenInfo(avgPerCitizenC40,avgPerCitizenNonC40);
    }

    public List<AvgReductionSectorInfo> getAvgReductionTargetSectorInfo(){
        return emissionTargetRepository.getSectorsWithAvgReductionTarget();
    }

    public List<CountryAvgTargetInfo> getCountryAvgTargetInfos(){
        return cityRepository.getCountryAvgTargetInfos();
    }

    public List<LandAreaEmissionInfo> getLandAreaEmissionInfo(){
        return cityRepository.getLandAreaEmissionInfos();
    }

    public List<EmissionStatusInfo> getEmissionStatusInfo() {
        return emissionRepository.getEmissionStatusInfo();
    }
}
