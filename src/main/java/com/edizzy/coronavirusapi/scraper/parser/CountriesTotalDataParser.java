package com.edizzy.coronavirusapi.scraper.parser;

import com.edizzy.coronavirusapi.model.common.TotalCountryData;
import com.edizzy.coronavirusapi.model.enums.TotalCountriesDataEnum;
import com.edizzy.coronavirusapi.service.utils.ParserUtility;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CountriesTotalDataParser {

    private static final String DATA_TABLE = "table#main_table_countries_today";
    private static final String TABLE_BODY = "tbody";
    private static final String TABLE_ROW = "tr";
    private static final String DATA_CELL = "td";

    public List<TotalCountryData> parse(Document document) {
        final Element dataTable = document.selectFirst(DATA_TABLE);
        final Element dataElement = dataTable.selectFirst(TABLE_BODY);
        final Elements dataRows = dataElement.select(TABLE_ROW);
        return dataRows.stream()
                .map(this::parseOne)
                .collect(Collectors.toList());
    }

    private TotalCountryData parseOne(Element element) {
        final Elements dataCells = element.select(DATA_CELL);
        final TotalCountryData totalCountryData = TotalCountryData.builder()
                .country(dataCells.get(TotalCountriesDataEnum.COUNTRY.getIndex()).text())
                .totalCases(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.TOTAL_CASES.getIndex()).text()))
                .newCases(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.NEW_CASES.getIndex()).text()))
                .totalDead(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.TOTAL_DEAD.getIndex()).text()))
                .newDead(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.NEW_DEAD.getIndex()).text()))
                .recovered(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.TOTAL_RECOVERED.getIndex()).text()))
                .activeCases(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.ACTIVE_CASES.getIndex()).text()))
                .seriousCases(ParserUtility.parseInt(dataCells.get(TotalCountriesDataEnum.SERIOUS_CASES.getIndex()).text()))
                .casesMillionPopulationRatio(ParserUtility.parseDouble(dataCells.get(TotalCountriesDataEnum.CASES_MILLION_POPULATION_RATIO.getIndex()).text()))
                .deathsMillionPopulationRatio(ParserUtility.parseDouble(dataCells.get(TotalCountriesDataEnum.DEATHS_MILLION_POPULATION_RATIO.getIndex()).text()))
                .firstCase(getFirstCase(dataCells.get(TotalCountriesDataEnum.FIRST_CASE.getIndex()).text()))
                .build();
        totalCountryData.setClosedCases(totalCountryData.getTotalCases() - totalCountryData.getActiveCases());
        return totalCountryData;
    }

    private DateTime getFirstCase(String date) {
        final DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM dd");
        return formatter.parseDateTime(date)
                .withYear(2020);
    }
}
