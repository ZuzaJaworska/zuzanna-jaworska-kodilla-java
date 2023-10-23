package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> listContinentsInWorld = new ArrayList<>();

    public void addContinent(Continent continent) {
        listContinentsInWorld.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantityInWorld = listContinentsInWorld.stream()
                .flatMap(continent -> continent.getListOfCountriesInContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum.add(country));
        return peopleQuantityInWorld;
    }
}
