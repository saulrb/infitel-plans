package com.infytel.plans.infitelplans.service;

import com.infytel.plans.infitelplans.dto.PlanDTO;

import java.util.List;

public interface PlanService {
    List<PlanDTO> getAllPlans();
    PlanDTO getPlanById(Integer planId);
}
