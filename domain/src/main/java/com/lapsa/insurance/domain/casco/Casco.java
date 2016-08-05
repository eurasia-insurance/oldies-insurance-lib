package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;

public class Casco extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1919280207677627360L;
    private static final int PRIME = 131;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // Покрытие только риска ДТП
    private boolean coverRoadAccidents;

    // Покрытие без риска ДТП
    private boolean coverNonRoadAccidents;

    // информация о застрахованном ТС
    private CascoVehicle insuredVehicle;

    // франшиза на частичный ущерб
    private CascoDeductiblePartialDamageRate deductiblePartialDamageRate;

    // франшиза на гибель/угон
    private CascoDeductibleFullDeathRate deductibleFullDeathRate;

    // Спец. СТО для ТС до 3-х лет
    // Спец. СТО для ТС от 3-х до 7 лет
    private boolean specialServiceStationRequired;

    // При убытке (ДТП) до 200 000 тенге - без вызова ГАИ, но с обязательным
    // выездом аварийного комиссара на место события (Алматы, Астана и
    // Караганда)
    private boolean noPoliceRequired;

    // При возникновении ДТП не по вине застрахованного франшиза не применяется
    private boolean noDeductibleAppliedIfNotGuilty;

    // Сбор документов в Дорожной Полиции компанией от имени клиента
    private boolean contactToPoliceRequired;

    // Покрытие расходов на услуги Эвакуатора, до 10 000 тенге.
    private boolean evacuatorRequired;

    // Предоставление во временное пользование ТС, пока ТС клиента находится на
    // СТО (до 10 дней);
    private boolean replacementCarRequired;

    // Действие договора до 1-го страхового случая
    private boolean contractEndsAfterFirstCase;

    // Комплексный договор (т.е. автокаско плюс секции ниже):
    // ДГПО ВТС с лимитом 20 000 000 тенге по случаю и в агрегате сверх лимита
    // по ОГПО ВТС
    private boolean thirdPartyLiabilityCoverage;

    // НС для водителя и пассажиров с лимитом 1 000 000 тенге на 1-го
    // застрахованного по случаю и в агрегате
    private boolean driverAndPassengerCoverage;
    private int driverAndPassengerCount;

    private CalculationData calculation;

    // GENERATED

    public CalculationData getCalculation() {
	return calculation;
    }

    public boolean isCoverRoadAccidents() {
	return coverRoadAccidents;
    }

    public CascoVehicle getInsuredVehicle() {
	return insuredVehicle;
    }

    public void setInsuredVehicle(CascoVehicle insuredVehicle) {
	this.insuredVehicle = insuredVehicle;
    }

    public void setCoverRoadAccidents(boolean coverRoadAccidents) {
	this.coverRoadAccidents = coverRoadAccidents;
    }

    public boolean isCoverNonRoadAccidents() {
	return coverNonRoadAccidents;
    }

    public void setCoverNonRoadAccidents(boolean coverNonRoadAccidents) {
	this.coverNonRoadAccidents = coverNonRoadAccidents;
    }

    public CascoDeductiblePartialDamageRate getDeductiblePartialDamageRate() {
	return deductiblePartialDamageRate;
    }

    public void setDeductiblePartialDamageRate(CascoDeductiblePartialDamageRate deductiblePartialDamageRate) {
	this.deductiblePartialDamageRate = deductiblePartialDamageRate;
    }

    public CascoDeductibleFullDeathRate getDeductibleFullDeathRate() {
	return deductibleFullDeathRate;
    }

    public void setDeductibleFullDeathRate(CascoDeductibleFullDeathRate deductibleFullDeathRate) {
	this.deductibleFullDeathRate = deductibleFullDeathRate;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }

    public boolean isSpecialServiceStationRequired() {
	return specialServiceStationRequired;
    }

    public void setSpecialServiceStationRequired(boolean specialServiceStationRequired) {
	this.specialServiceStationRequired = specialServiceStationRequired;
    }

    public boolean isNoPoliceRequired() {
	return noPoliceRequired;
    }

    public void setNoPoliceRequired(boolean noPoliceRequired) {
	this.noPoliceRequired = noPoliceRequired;
    }

    public boolean isNoDeductibleAppliedIfNotGuilty() {
	return noDeductibleAppliedIfNotGuilty;
    }

    public void setNoDeductibleAppliedIfNotGuilty(boolean noDeductibleAppliedIfNotGuilty) {
	this.noDeductibleAppliedIfNotGuilty = noDeductibleAppliedIfNotGuilty;
    }

    public boolean isContactToPoliceRequired() {
	return contactToPoliceRequired;
    }

    public void setContactToPoliceRequired(boolean contactToPoliceRequired) {
	this.contactToPoliceRequired = contactToPoliceRequired;
    }

    public boolean isEvacuatorRequired() {
	return evacuatorRequired;
    }

    public void setEvacuatorRequired(boolean evacuatorRequired) {
	this.evacuatorRequired = evacuatorRequired;
    }

    public boolean isReplacementCarRequired() {
	return replacementCarRequired;
    }

    public void setReplacementCarRequired(boolean replacementCarRequired) {
	this.replacementCarRequired = replacementCarRequired;
    }

    public boolean isContractEndsAfterFirstCase() {
	return contractEndsAfterFirstCase;
    }

    public void setContractEndsAfterFirstCase(boolean contractEndsAfterFirstCase) {
	this.contractEndsAfterFirstCase = contractEndsAfterFirstCase;
    }

    public boolean isThirdPartyLiabilityCoverage() {
	return thirdPartyLiabilityCoverage;
    }

    public void setThirdPartyLiabilityCoverage(boolean thirdPartyLiabilityCoverage) {
	this.thirdPartyLiabilityCoverage = thirdPartyLiabilityCoverage;
    }

    public boolean isDriverAndPassengerCoverage() {
	return driverAndPassengerCoverage;
    }

    public void setDriverAndPassengerCoverage(boolean driverAndPassengerCoverage) {
	this.driverAndPassengerCoverage = driverAndPassengerCoverage;
    }

    public int getDriverAndPassengerCount() {
	return driverAndPassengerCount;
    }

    public void setDriverAndPassengerCount(int driverAndPassengerCount) {
	this.driverAndPassengerCount = driverAndPassengerCount;
    }
}