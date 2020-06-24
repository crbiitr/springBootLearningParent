package com.learning.controller;

import com.learning.RetryApplication;
import com.learning.service.SampleRetryClientService;
import com.learning.service.exception.TypeOneException;
import com.learning.service.exception.TypeTwoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chetan on 24/6/20.
 */
@RestController
public class RetryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryController.class);

    @Autowired
    private SampleRetryClientService client;

    @GetMapping(path = "/test")
    public void testRetry() {
        sampleRetryService();
    }

    public void sampleRetryService() {
        try {
            final String message = client.callRetryService();
            LOGGER.info("message = " + message);
        } catch (TypeOneException | TypeTwoException e) {
            e.printStackTrace();
        }
    }
}
