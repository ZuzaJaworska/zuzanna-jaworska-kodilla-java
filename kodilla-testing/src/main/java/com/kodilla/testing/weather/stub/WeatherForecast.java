package com.kodilla.testing.weather.stub;

import java.lang.*;
import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            //first element of the map is an identifier of weather station
            //second element of the map is a temperature in Celsius degrees
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double calculateAverageTemperature() {
        List<Double> listForAverage = new ArrayList<>();

        for (Map.Entry<String, Double> forecastEntry : temperatures.getTemperatures().entrySet()) {
            listForAverage.add(forecastEntry.getValue());
        }

        double sumTemperature = 0;
        for (int n = 0; n < listForAverage.size(); n++) {
            sumTemperature += listForAverage.get(n);
        }

        double averageTemperature;
        averageTemperature = sumTemperature / listForAverage.size();

        return averageTemperature;
    }

    public Double calculateMedianTemperature() {
        List<Double> listForMedian = new ArrayList<>();

        for (Map.Entry<String, Double> forecastEntry : temperatures.getTemperatures().entrySet()) {
            listForMedian.add(forecastEntry.getValue());
        }
        Collections.sort(listForMedian);

        Double medianTemperature;
        if (listForMedian.size() % 2 == 0) {
            medianTemperature = (listForMedian.get(listForMedian.size() / 2)
                    + (listForMedian.get((listForMedian.size() / 2) - 1))) / 2;
        } else {
            medianTemperature = listForMedian.get(listForMedian.size() / 2);
        }

        return medianTemperature;
    }
}