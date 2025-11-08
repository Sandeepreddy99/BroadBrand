package com.unluckytechie.BroadBandServicesApp.service;

import com.unluckytechie.BroadBandServicesApp.entity.BroadbandPlan;

import java.util.List;

public interface BroadbandService {
    public BroadbandPlan savePlan(BroadbandPlan broadbandPlan);
    public List<BroadbandPlan> getAllPlans();

   public BroadbandPlan getPlanByID(Long id);

   public BroadbandPlan updatePlan(BroadbandPlan broadbandPlan, Long id);

   public String deletePlan(Long id);
}
