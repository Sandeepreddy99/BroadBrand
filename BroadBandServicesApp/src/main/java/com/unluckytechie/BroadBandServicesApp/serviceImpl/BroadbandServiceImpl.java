package com.unluckytechie.BroadBandServicesApp.serviceImpl;

import com.unluckytechie.BroadBandServicesApp.entity.BroadbandPlan;
import com.unluckytechie.BroadBandServicesApp.exception.PlanNotFound;
import com.unluckytechie.BroadBandServicesApp.repository.BroadbandPlanRepository;
import com.unluckytechie.BroadBandServicesApp.service.BroadbandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadbandServiceImpl implements BroadbandService {
    @Autowired
private BroadbandPlanRepository broadbandPlanRepository;
    @Override
    public BroadbandPlan savePlan(BroadbandPlan broadbandPlan) {
        return broadbandPlanRepository.save(broadbandPlan);
    }

    @Override
    public List<BroadbandPlan> getAllPlans() {
        return broadbandPlanRepository.findAll();
    }

    @Override
    public BroadbandPlan getPlanByID(Long id) {
        return broadbandPlanRepository.findById(id).orElseThrow(()->new PlanNotFound("No plan available for the given Id"));
    }

    @Override
    public BroadbandPlan updatePlan(BroadbandPlan broadbandPlan, Long id) {
        BroadbandPlan existingPlan=broadbandPlanRepository.findById(id).orElseThrow(()->new PlanNotFound("No plan for the given Id"));
        if(broadbandPlan.getName()!=null&& !broadbandPlan.getName().equals("")) {
            existingPlan.setName(broadbandPlan.getName());
        }
        if(broadbandPlan.getSpeedMbps()!=0) {
            existingPlan.setSpeedMbps(broadbandPlan.getSpeedMbps());
        }
        if(broadbandPlan.getPrice()!=0) {
            existingPlan.setPrice(broadbandPlan.getPrice());
        }
        if(broadbandPlan.getPlanType()!=null && !broadbandPlan.getPlanType().isBlank()) {
            existingPlan.setPlanType(broadbandPlan.getPlanType());
        }
        broadbandPlanRepository.save(existingPlan);
        return existingPlan;
    }

    @Override
    public List<BroadbandPlan> getPlansByPlanType(String planType) {
        return broadbandPlanRepository.findByPlanType(planType);
    }

    @Override
    public String deletePlan(Long id) {
        broadbandPlanRepository.deleteById(id);
        return "Plan deleted Successfully";
    }

}
