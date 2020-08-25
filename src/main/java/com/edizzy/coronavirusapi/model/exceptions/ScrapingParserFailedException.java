package com.edizzy.coronavirusapi.model.exceptions;

public class ScrapingParserFailedException extends RuntimeException {

    public ScrapingParserFailedException() {
        super();
    }

    public ScrapingParserFailedException(String message) {
        super(message);
    }

    public ScrapingParserFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScrapingParserFailedException(Throwable cause) {
        super(cause);
    }

    protected ScrapingParserFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
