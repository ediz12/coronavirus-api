package com.edizzy.coronavirusapi.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;

@Getter
@Builder
@AllArgsConstructor
public class TimelineData {

    private DateTime date;
    private Integer value;
}
