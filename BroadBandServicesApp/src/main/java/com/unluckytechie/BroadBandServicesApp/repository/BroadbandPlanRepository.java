package com.unluckytechie.BroadBandServicesApp.repository;

import com.unluckytechie.BroadBandServicesApp.entity.BroadbandPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BroadbandPlanRepository extends JpaRepository<BroadbandPlan,Long> {
    List<BroadbandPlan> findByPlanType(String planType);
}
