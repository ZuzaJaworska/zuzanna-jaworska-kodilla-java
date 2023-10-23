package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String continentName;
    private final List<Country> listCountriesInContinent = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getListOfCountriesInContinent() {
        return new ArrayList<>(listCountriesInContinent);
    }

    public void addCountry(Country country) {
        listCountriesInContinent.add(country);
    }
}
