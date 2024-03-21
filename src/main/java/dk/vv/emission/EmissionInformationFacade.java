package dk.vv.emission;
//
//import dk.vv.emission.dtos.*;
//import dk.vv.emission.repositories.CityRepository;
//import dk.vv.emission.repositories.EmissionRepository;
//import dk.vv.emission.repositories.EmissionTargetRepository;
import dk.vv.emission.dtos.*;
import dk.vv.emission.repositories.CityService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
//
//import java.util.ArrayList;
//import java.util.List;

@ApplicationScoped
public class EmissionInformationFacade {
//
//
    @Inject
    CityService cityService;

//    @Inject
//    EmissionRepository emissionRepository;
//
//    @Inject
//    EmissionTargetRepository emissionTargetRepository;

//
    public List<TempEmissionInformation> getTempEmissionInformation(){
        return cityService.getCitiesWithAvgTemp();
    }
//
//
    public List<CountryAvgEmissionInfo> getCountryAvgEmissionInfo(){
        return cityService.getAverageEmissionsByCountry();
    }


    public List<CityTargetInformation> getCitiesWithCO2NeutralTargets(){
        return cityService.getCitiesWithCO2NeutralTargets();
    }

    public List<AvgTargetInformation> getAvgTargetInformation(){
        return cityService.getAverageForCitesAndIsC40();
    }
//
//
    public AvgEmissionPerCitizenInfo getAvgEmissionsPerCitizenInfo(){
        return cityService.getAvgEmissionsPerCitizenInfo();
    }
//
    public List<AvgReductionSectorInfo> getAvgReductionTargetSectorInfo(){
        return cityService.getAverageReductionBySector();
    }

    public List<CountryAvgTargetInfo> getCountryAvgTargetInfos(){
        return cityService.getCountryAvgTargetInfos();
    }

    public List<LandAreaEmissionInfo> getLandAreaEmissionInfo(){
        return cityService.getLandAreaEmissionInfos();
    }

    public List<EmissionStatusInfo> getEmissionStatusInfo() {
        return cityService.getEmissionStatusInfo();
    }
}
