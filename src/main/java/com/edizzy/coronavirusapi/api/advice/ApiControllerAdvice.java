package com.edizzy.coronavirusapi.api.advice;

import com.edizzy.coronavirusapi.api.CoronavirusApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = {
        CoronavirusApi.class
})
public class ApiControllerAdvice {

}
