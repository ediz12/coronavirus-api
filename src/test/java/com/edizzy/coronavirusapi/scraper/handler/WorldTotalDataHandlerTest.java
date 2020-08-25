package com.edizzy.coronavirusapi.scraper.handler;

import com.edizzy.coronavirusapi.scraper.parser.CountriesTimeSeriesDataParser;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTotalDataParser;
import com.edizzy.coronavirusapi.scraper.parser.WorldTotalDataParser;
import com.edizzy.coronavirusapi.service.utils.CountryUtility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

class WorldTotalDataHandlerTest {

    @Test
    void getTimeseries() {
        RestTemplate build = new RestTemplateBuilder().build();
        CountriesTimeSeriesDataParser countriesTimeSeriesDataParser = new CountriesTimeSeriesDataParser();
        CountriesTimeSeriesDataHandler countriesTimeSeriesDataHandler = new CountriesTimeSeriesDataHandler(build, countriesTimeSeriesDataParser);

        countriesTimeSeriesDataHandler.getData();
    }

    @Test
    void getCountries() {
        final CountriesTotalDataParser countriesTotalDataParser = new CountriesTotalDataParser();
        final CountriesTotalDataHandler countriesTotalDataHandler = new CountriesTotalDataHandler(countriesTotalDataParser);
        countriesTotalDataHandler.getData();;
    }

    @Test
    void getWorld() {
        final WorldTotalDataParser worldTotalDataParser = new WorldTotalDataParser();
        final WorldTotalDataHandler worldTotalDataHandler = new WorldTotalDataHandler(worldTotalDataParser);
        worldTotalDataHandler.getData();
    }
}