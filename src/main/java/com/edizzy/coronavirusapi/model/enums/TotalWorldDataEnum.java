package com.edizzy.coronavirusapi.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TotalWorldDataEnum {

    TOTAL(0),
    DEAD(1),
    RECOVERED(2);

    private final int index;
}
