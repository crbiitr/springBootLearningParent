package com.learning;


import com.learning.service.SampleRetryClientService;
import com.learning.service.exception.TypeOneException;
import com.learning.service.exception.TypeTwoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RetryApplicationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryApplicationTest.class);
    @Autowired
    private SampleRetryClientService client;
    @Test
    public void contextLoads() {
    }
    @Test
    public void sampleRetryService() {
        try {
            final String message = client.callRetryService();
            LOGGER.info("message = " + message);
        } catch (TypeOneException | TypeTwoException e) {
            e.printStackTrace();
        }
    }
}