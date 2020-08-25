package com.edizzy.coronavirusapi.scraper.parser;


import com.edizzy.coronavirusapi.model.common.TotalWorldData;
import com.edizzy.coronavirusapi.model.enums.TotalWorldDataEnum;
import com.edizzy.coronavirusapi.service.utils.ParserUtility;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;


public class WorldTotalDataParser {

    private static final String WORLD_DATA_ELEMENTS = ".maincounter-number";

    public TotalWorldData parse(Document document) {
        final Elements worldDataElements = document.select(WORLD_DATA_ELEMENTS);
        final List<Integer> worldDataNumbers = worldDataElements.stream()
                .map(element -> element.select("span"))
                .map(element -> ParserUtility.parseInt(element.text()))
                .collect(Collectors.toList());

        final Integer total = worldDataNumbers.get(TotalWorldDataEnum.TOTAL.getIndex());
        final Integer dead = worldDataNumbers.get(TotalWorldDataEnum.DEAD.getIndex());
        final Integer recovered = worldDataNumbers.get(TotalWorldDataEnum.RECOVERED.getIndex());

        return TotalWorldData.builder()
                .total(total)
                .dead(dead)
                .recovered(recovered)
                .closed(dead + recovered)
                .active(total - dead - recovered)
                .build();
    }
}
