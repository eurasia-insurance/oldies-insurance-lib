package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.InsuranceRequestType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class InsuranceRequestTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceRequestType> {

    @Override
    protected InsuranceRequestType[] getAllEnumValues() {
	return InsuranceRequestType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return InsuranceRequestType.BUNDLE_BASENAME;
    }
}