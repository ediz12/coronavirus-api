package com.edizzy.coronavirusapi.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiLinksEnum {

    WORLDOMETER_MAIN_PAGE("https://www.worldometers.info/coronavirus"),
    JHU_CASES_TIME_SERIES("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv"),
    JHU_DEATHS_TIME_SERIES("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv"),
    JHU_RECOVERED_TIME_SERIES("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv");

    private final String baseUrl;
}
