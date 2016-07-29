package com.lapsa.insurance.services.other;

import java.util.List;

import com.lapsa.insurance.domain.InsuredDriverData;
import com.lapsa.insurance.domain.InsuredVehicleData;

public interface CalculationService {
    double calculatePremiumCost(List<InsuredDriverData> drivers, List<InsuredVehicleData> vehicles);
}
