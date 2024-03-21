package dk.vv.emission.rest;

import dk.vv.emission.EmissionInformationFacade;
import dk.vv.emission.dtos.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/emission/")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class EmissionInfoResource {

    @Inject
    EmissionInformationFacade emissionInformationFacade;
//
    @GET
    @Path("/tempEmission")
    public List<TempEmissionInformation> getTemperatureEmissionInfos(){
        return emissionInformationFacade.getTempEmissionInformation();
    }
    @GET
    @Path("/countryAvgTarget")
    public List<CountryAvgTargetInfo> getCountryAvgTarget(){
        return emissionInformationFacade.getCountryAvgTargetInfos();
    }

    @GET
    @Path("/avgTarget")
    public List<AvgTargetInformation> getAvgTargetInformation(){
        return emissionInformationFacade.getAvgTargetInformation();
    }
//
    @GET
    @Path("/reductionSector")
    public List<AvgReductionSectorInfo> getReductionSectorInfo(){
        return emissionInformationFacade.getAvgReductionTargetSectorInfo();
    }
//
    @GET
    @Path("/countryAvgEmission")
    public List<CountryAvgEmissionInfo> getAvgCountryEmissionInformation(){
        return emissionInformationFacade.getCountryAvgEmissionInfo();
    }

    @GET
    @Path("/carbonNetutral")
    public List<CityTargetInformation> getCitiesWithC02NeutralTarget(){
        return emissionInformationFacade.getCitiesWithCO2NeutralTargets();
    }

    @GET
    @Path("/avgCitizen")
    public AvgEmissionPerCitizenInfo getAvgEmissionsPerCitizen(){
        return emissionInformationFacade.getAvgEmissionsPerCitizenInfo();
    }

    @GET
    @Path("/landAreaEmission")
    public List<LandAreaEmissionInfo> getLandAreaEmissionInfo(){
        return emissionInformationFacade.getLandAreaEmissionInfo();
    }

    @GET
    @Path("/status")
    public List<EmissionStatusInfo> getEmissionStatusInfo(){
        return emissionInformationFacade.getEmissionStatusInfo();
    }
}
