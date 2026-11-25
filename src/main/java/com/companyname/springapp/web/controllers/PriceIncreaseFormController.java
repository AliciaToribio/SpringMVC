package com.companyname.springapp.web.controllers;

import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.companyname.springapp.business.services.PriceIncrease;
import com.companyname.springapp.business.services.ProductManager;

@Controller
public class PriceIncreaseFormController {
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @GetMapping("/priceincrease.htm")
    public String showForm(Model model) {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        model.addAttribute("priceIncrease", priceIncrease);
        return "priceincrease";
    }

    @PostMapping("/priceincrease.htm")
    public String onSubmit(@Valid @ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "priceincrease";
        }

        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");
        productManager.increasePrice(increase);
        return "redirect:/hello.htm";
    }
}
