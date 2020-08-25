package com.edizzy.coronavirusapi.configuration.scraping;

import com.edizzy.coronavirusapi.scraper.handler.CountriesTimeSeriesDataHandler;
import com.edizzy.coronavirusapi.scraper.handler.CountriesTotalDataHandler;
import com.edizzy.coronavirusapi.scraper.handler.WorldTotalDataHandler;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTimeSeriesDataParser;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTotalDataParser;
import com.edizzy.coronavirusapi.scraper.parser.WorldTotalDataParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ScrapingHandlerConfiguration {

    @Bean
    public WorldTotalDataHandler worldTotalCovidDataHandler(WorldTotalDataParser worldTotalDataParser) {
        return new WorldTotalDataHandler(worldTotalDataParser);
    }

    @Bean
    public CountriesTotalDataHandler countriesTotalCovidDataHandler(CountriesTotalDataParser countriesTotalDataParser) {
        return new CountriesTotalDataHandler(countriesTotalDataParser);
    }

    @Bean
    public CountriesTimeSeriesDataHandler countriesTimeSeriesDataHandler(RestTemplate restTemplate, CountriesTimeSeriesDataParser countriesTimeSeriesDataParser) {
        return new CountriesTimeSeriesDataHandler(restTemplate, countriesTimeSeriesDataParser);
    }
}
