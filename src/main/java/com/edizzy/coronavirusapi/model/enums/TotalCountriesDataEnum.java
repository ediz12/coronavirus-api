package com.edizzy.coronavirusapi.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  TotalCountriesDataEnum {

    COUNTRY(0),
    TOTAL_CASES(1),
    NEW_CASES(2),
    TOTAL_DEAD(3),
    NEW_DEAD(4),
    TOTAL_RECOVERED(5),
    ACTIVE_CASES(6),
    SERIOUS_CASES(7),
    CASES_MILLION_POPULATION_RATIO(8),
    DEATHS_MILLION_POPULATION_RATIO(9),
    FIRST_CASE(10);

    private final int index;
}
