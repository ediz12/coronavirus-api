package com.edizzy.coronavirusapi.configuration.scraping;

import com.edizzy.coronavirusapi.scraper.parser.CountriesTimeSeriesDataParser;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTotalDataParser;
import com.edizzy.coronavirusapi.scraper.parser.WorldTotalDataParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScrapingParserConfiguration {

    @Bean
    public WorldTotalDataParser worldTotalDataParser() {
        return new WorldTotalDataParser();
    }

    @Bean
    public CountriesTotalDataParser countriesTotalDataParser() {
        return new CountriesTotalDataParser();
    }

    @Bean
    public CountriesTimeSeriesDataParser countriesTimeSeriesDataParser() {
        return new CountriesTimeSeriesDataParser();
    }
}
