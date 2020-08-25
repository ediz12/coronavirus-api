package com.edizzy.coronavirusapi.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TotalCountryData {

    private String country;
    private int totalCases;
    private int newCases;
    private int totalDead;
    private int newDead;
    private int recovered;
    private int activeCases;
    private int seriousCases;
    private int closedCases;
    private double casesMillionPopulationRatio;
    private double deathsMillionPopulationRatio;
    private DateTime firstCase;
}
