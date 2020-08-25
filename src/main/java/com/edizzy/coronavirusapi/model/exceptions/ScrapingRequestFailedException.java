package com.edizzy.coronavirusapi.model.exceptions;

public class ScrapingRequestFailedException extends RuntimeException {

    public ScrapingRequestFailedException() {
        super();
    }

    public ScrapingRequestFailedException(String message) {
        super(message);
    }

    public ScrapingRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScrapingRequestFailedException(Throwable cause) {
        super(cause);
    }

    protected ScrapingRequestFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
