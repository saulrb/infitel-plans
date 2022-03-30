package com.infytel.plans.infitelplans.service;

import com.infytel.plans.infitelplans.dto.PlanDTO;
import com.infytel.plans.infitelplans.entity.Plan;
import com.infytel.plans.infitelplans.repository.PlanRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImp implements PlanService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ModelMapper modelMapper;
    private PlanRepository planRepository;

    @Autowired
    public PlanServiceImp(ModelMapper modelMapper, PlanRepository planRepository){
        this.modelMapper = modelMapper;
        this.planRepository = planRepository;
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        List<PlanDTO> planDTOList = new ArrayList<>();
        Iterable<Plan> plans = planRepository.findAll();
        plans.forEach( plan -> {
            planDTOList.add(modelMapper.map(plan,PlanDTO.class));
        });
        return planDTOList;
    }

    @Override
    public PlanDTO getPlanById(Integer planId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isPresent()) {
           return modelMapper.map(planOptional.get(),PlanDTO.class);
        }
        return null;
    }
}
