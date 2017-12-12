package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lapsa.fin.FinCurrency;

import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.HashCodePrime;

@Embeddable
@HashCodePrime(3)
public class CalculationData extends Domain {

    private static final long serialVersionUID = 1L;

    @Basic
    @Column(name = "CALCULATED_PERMIUM_COST")
    private double calculatedPremiumCost;

    @Basic
    @Column(name = "ACTUAL_PERMIUM_COST")
    private double actualPremiumCost;

    @Basic
    @Column(name = "DISCOUNT_AMOUNT")
    private double discountAmount;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "PREMIUM_CURRENCY")
    private FinCurrency premiumCurrency;

    public double getPremiumCost() {
	if (actualPremiumCost > 0)
	    return actualPremiumCost;
	if (discountAmount > calculatedPremiumCost)
	    return 0;
	return calculatedPremiumCost - discountAmount;
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(CALCULATION_DATA.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	sj.add(MyOptionals.of(this) //
		.filter(x -> MyNumbers.nonZero(getPremiumCost()))
		.filter(x -> MyObjects.nonNull(x.premiumCurrency))
		.map(x -> x.premiumCurrency.formatAmount(getPremiumCost())) //
		.orElseGet(() -> "<" + CALCULATION_DATA_UNDEFINED.localized(variant, locale) + ">"));

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENEERATED

    public double getCalculatedPremiumCost() {
	return calculatedPremiumCost;
    }

    public void setCalculatedPremiumCost(double calculatedPremiumCost) {
	this.calculatedPremiumCost = calculatedPremiumCost;
    }

    public double getActualPremiumCost() {
	return actualPremiumCost;
    }

    public void setActualPremiumCost(double actualPremiumCost) {
	this.actualPremiumCost = actualPremiumCost;
    }

    public double getDiscountAmount() {
	return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
	this.discountAmount = discountAmount;
    }

    public FinCurrency getPremiumCurrency() {
	return premiumCurrency;
    }

    public void setPremiumCurrency(FinCurrency premiumCurrency) {
	this.premiumCurrency = premiumCurrency;
    }
}
