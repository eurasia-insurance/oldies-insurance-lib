package com.lapsa.insurance.domain;

import com.lapsa.insurance.elements.PolicyTermClass;

public class CalculationData extends BaseDomain {
    private static final long serialVersionUID = -1769681003179820909L;

    private PolicyTermClass termClass = PolicyTermClass.YEAR;

    private double premiumCost;

    // GENEERATED

    public PolicyTermClass getTermClass() {
	return termClass;
    }

    public void setTermClass(PolicyTermClass termClass) {
	this.termClass = termClass;
    }

    public double getPremiumCost() {
	return premiumCost;
    }

    public void setPremiumCost(double premiumCost) {
	this.premiumCost = premiumCost;
    }

}
