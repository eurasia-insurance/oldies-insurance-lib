package com.lapsa.insurance.domain;

import com.lapsa.fin.FinCurrency;

public class CalculationData extends BaseDomain {
    private static final long serialVersionUID = -1769681003179820909L;
    private static final int PRIME = 3;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private double actualPremiumCost;
    private double calculatedPremiumCost;
    private FinCurrency premiumCurrency;

    public double getPremiumCost() {
	if (actualPremiumCost > 0)
	    return actualPremiumCost;
	return calculatedPremiumCost;
    }

    public double getDiscountCost() {
	return calculatedPremiumCost - actualPremiumCost;
    }

    // GENEERATED

    public double getCalculatedPremiumCost() {
	return calculatedPremiumCost;
    }

    public double getActualPremiumCost() {
	return actualPremiumCost;
    }

    public void setActualPremiumCost(double actualPremiumCost) {
	this.actualPremiumCost = actualPremiumCost;
    }

    public void setCalculatedPremiumCost(double calculatedPremiumCost) {
	this.calculatedPremiumCost = calculatedPremiumCost;
    }

    public FinCurrency getPremiumCurrency() {
	return premiumCurrency;
    }

    public void setPremiumCurrency(FinCurrency premiumCurrency) {
	this.premiumCurrency = premiumCurrency;
    }
}
