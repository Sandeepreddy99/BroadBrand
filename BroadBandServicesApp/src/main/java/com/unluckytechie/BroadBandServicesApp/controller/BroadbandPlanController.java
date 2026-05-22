package com.unluckytechie.BroadBandServicesApp.controller;

import com.unluckytechie.BroadBandServicesApp.entity.BroadbandPlan;
import com.unluckytechie.BroadBandServicesApp.service.BroadbandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/broadbandplan")
public class BroadbandPlanController {
    @Autowired
    private BroadbandService broadbandService;
    @PostMapping()
    public ResponseEntity<BroadbandPlan> savePlan(@RequestBody BroadbandPlan broadbandPlan){
        return new ResponseEntity<BroadbandPlan>(broadbandService.savePlan(broadbandPlan),HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<BroadbandPlan>> getAllPlans(){
        return new ResponseEntity<List<BroadbandPlan>>(broadbandService.getAllPlans(),HttpStatus.OK);
    }

    @GetMapping("/type/{planType}")
    public ResponseEntity<List<BroadbandPlan>> getPlansByType(@PathVariable("planType") String planType){
        return new ResponseEntity<List<BroadbandPlan>>(broadbandService.getPlansByPlanType(planType),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BroadbandPlan> getPlanById(@PathVariable("id") Long id){
        return new ResponseEntity<BroadbandPlan>(broadbandService.getPlanByID(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
public ResponseEntity<BroadbandPlan> updatePlan(@PathVariable("id") Long id,@RequestBody BroadbandPlan broadbandPlan){
return new ResponseEntity<BroadbandPlan>(broadbandService.updatePlan(broadbandPlan,id),HttpStatus.OK);
}
@DeleteMapping("{id}")
    public ResponseEntity<String> deletePlan(@PathVariable("id") Long id){
return new ResponseEntity<String >(broadbandService.deletePlan(id),HttpStatus.OK);
}
}
