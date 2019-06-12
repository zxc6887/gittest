package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {

    @Autowired
    HelloWorldController helloWorldController;
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    @Test
    public void getHello2() throws Exception{
        helloWorldController.index();
    }

    @Test
    public void jisuan() throws Exception{
        BigDecimal allCouponAmount = new BigDecimal("0");
        allCouponAmount=allCouponAmount.add(new BigDecimal(String.valueOf(5.23)));
        allCouponAmount=allCouponAmount.multiply(new BigDecimal("0.68")).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(allCouponAmount);

        BigDecimal realAmount = new BigDecimal("21.35");
        BigDecimal orderAmount = new BigDecimal("68.50");
        BigDecimal discount = realAmount.divide(orderAmount, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("折扣:"+discount);

    }


}