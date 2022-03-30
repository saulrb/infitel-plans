package com.infytel.plans.infitelplans.controller;

import com.infytel.plans.infitelplans.dto.PlanDTO;
import com.infytel.plans.infitelplans.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PlanController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping(value = "/plans", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlanDTO> getAllPlans() {
        logger.info("All Plans with no restriction in the API ");
        return planService.getAllPlans();
    }

    @GetMapping(value ="/plans/{planId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlanDTO getPlanById(@PathVariable Integer planId){
        logger.info(" Received planId {}" , planId);
        return planService.getPlanById(planId);
    }

}
