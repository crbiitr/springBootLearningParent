package com.learning.service;

import com.learning.service.exception.TypeOneException;
import com.learning.service.exception.TypeTwoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chetan on 23/6/20.
 */

@Service
public class SampleRetryClientService {
    @Autowired
    private SampleRetryService sampleRetryService;
    public String callRetryService() throws TypeOneException, TypeTwoException {
        return sampleRetryService.retryWhenException();
    }
}
