package com.companyname.springapp.web.controllers;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.business.SpringappBusinessConfig;
import com.companyname.springapp.web.SpringappWebConfig;

import java.util.Map;

@SpringJUnitWebConfig(classes = {SpringappBusinessConfig.class, SpringappWebConfig.class})
public class InventoryControllerTests {
    @Autowired
    private InventoryController controller;

    @Test
    void testHandleRequestView() {
        ModelAndView modelAndView = controller.handleRequest();
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}
