package dk.vv.emission;

import dk.vv.emission.dtos.*;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EmissionInformationFacadeTest {

    @Inject
    EmissionInformationFacade classUnderTest;


    @Test
    void when_get_tempEmissionInformation_then_size_of_list_should_be_250(){
        // Arrange
        List<TempEmissionInformation> result = new ArrayList<>();

        // Act
        result = classUnderTest.getTempEmissionInformation();

        // Assert
        Assertions.assertEquals(250, result.size());

    }

    @Test
    void when_get_countryAvgEmissionInfo_then_size_of_list_should_be_250(){
        // Arrange
        List<CountryAvgEmissionInfo> result = new ArrayList<>();

        // Act
        result = classUnderTest.getCountryAvgEmissionInfo();

        // Assert
        Assertions.assertEquals(52, result.size());

    }

    @Test
    void when_get_100_city_reduction_target_then_size_of_list_should_be_43(){
        // Arrange
        List<CityTargetInformation> result = new ArrayList<>();

        // Act
        result = classUnderTest.getCitiesWithCO2NeutralTargets();

        // Assert
        Assertions.assertEquals(43, result.size());
    }

    @Test
    void when_getAvgTargetInformation_then_size_should_be_2(){
        // Arrange
        List<AvgTargetInformation> result = new ArrayList<>();

        // Act
        result = classUnderTest.getAvgTargetInformation();

        // Assert
        Assertions.assertEquals(2, result.size());
    }


    @Test
    void when_getAvgReductionTarget_then_size_should_be_8(){
        // Arrange
        List<AvgReductionSectorInfo> result = new ArrayList<>();

        // Act
        result = classUnderTest.getAvgReductionTargetSectorInfo();

        // Assert
        Assertions.assertEquals(8, result.size());
    }

    @Test
    void when_get_CountryAvgReductionInfo_then_size_should_be_48(){

        // Arrange
        List<CountryAvgTargetInfo> result = null;

        // Act
        result = classUnderTest.getCountryAvgTargetInfos();

        // Assert
        Assertions.assertEquals(48,result.size());
    }


    @Test
    void when_get_landAreaEmissionInfo_then_size_should_be_255(){
        // Arrange
        List<LandAreaEmissionInfo> result = null;

        // Act
        result = classUnderTest.getLandAreaEmissionInfo();

        // Assert
        Assertions.assertEquals(255,result.size());
    }


    @Test
    void when_get_emissionStatusInfo_then_increased_should_be_36_when_year_is_2016(){
        // Arrange
        List<EmissionStatusInfo> result = new ArrayList<>();

        // Act
        result = classUnderTest.getEmissionStatusInfo();

        // Assert
        Assertions.assertEquals(36, result.stream().filter(esi -> esi.getYear() == 2016).toList().get(0).getIncreased());
    }


    }

