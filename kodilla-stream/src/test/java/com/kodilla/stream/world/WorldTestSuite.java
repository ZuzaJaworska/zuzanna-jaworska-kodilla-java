package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europe = new Continent("Europa");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");
        Continent antarctica = new Continent("Antarctica");

            //countries - in Europe
        Country poland = new Country("Poland", new BigDecimal("40772360"));
        Country portugal = new Country("Portugal", new BigDecimal("10240087"));
        Country norway = new Country("Norway", new BigDecimal("5486735"));
            //transcontinental countries - in Europe AND Asia
        Country turkey = new Country("Turkey", new BigDecimal("85954584"));
            //countries - in Asia
        Country cambodia = new Country("Cambodia", new BigDecimal("16999346"));
        Country singapore = new Country("Singapore", new BigDecimal("6026446"));
        Country thailand = new Country("Thailand", new BigDecimal("71827662"));
            //transcontinental countries - in Asia AND Africa
        Country egypt = new Country("Egypt", new BigDecimal("113259609"));
            //countries - in Africa
        Country mauritius = new Country("Mauritius", new BigDecimal("1300997"));
        Country ethiopia = new Country("Ethiopia", new BigDecimal("127503241"));

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(antarctica);

        europe.addCountry(poland);
        europe.addCountry(portugal);
        europe.addCountry(norway);
        europe.addCountry(turkey);
        asia.addCountry(turkey);
        asia.addCountry(cambodia);
        asia.addCountry(singapore);
        asia.addCountry(thailand);
        asia.addCountry(egypt);
        africa.addCountry(egypt);
        africa.addCountry(mauritius);
        africa.addCountry(ethiopia);

        //When
        BigDecimal worldsPopulation = world.getPeopleQuantity();

        //Then
            //transcontinental countries' population should be added to world's population just once!
        BigDecimal expectedPopulation = new BigDecimal("479371067");
        assertEquals(expectedPopulation, worldsPopulation);
    }
}
