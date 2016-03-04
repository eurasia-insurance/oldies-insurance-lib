package kz.theeurasia.policy.calc.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.calc.facade.DriverFacade;
import kz.theeurasia.policy.calc.facade.PolicyFacade;
import kz.theeurasia.policy.calc.facade.VehicleFacade;
import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyRequestData;

@Named("calculator")
@ViewScoped
public class OSGPOVTSView implements Serializable {

    private static final long serialVersionUID = 1L;

    private ResourceBundle glb;

    private ResourceBundle gpovts;

    @Inject
    private PolicyFacade policyFacade;

    @Inject
    private DriverFacade driverFacade;

    @Inject
    private VehicleFacade vehicleFacade;

    private PolicyRequestData policy;

    private boolean requestSent = false;

    @PostConstruct
    public void init() {
	glb = ResourceBundle.getBundle(GlobalMessageBundleCode.BUNDLE_BASE_NAME);
	gpovts = ResourceBundle.getBundle(MessageBundleCode.BUNDLE_BASE_NAME);
	try {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    Application application = facesContext.getApplication();
	    this.policy = policyFacade.initNew();

	    switch (application.getProjectStage()) {
	    case Development:
		// buildTestDataManyDrivers();
		buildTestDataManyVehicles();
		setContactData();
		break;
	    case Production:
	    default:
		driverFacade.add(policy);
		vehicleFacade.add(policy);
	    }
	} catch (ValidationException e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
		    glb.getString(GlobalMessageBundleCode.MESSAGES_SERVER_FATAL_ERROR_CAPTION.getMessageBundleCode()),
		    glb.getString(
			    GlobalMessageBundleCode.MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION.getMessageBundleCode())));
	}
    }

    private void setContactData() {
	policy.getInsurant().getContactData().setEmail("vadim.o.isaev@gmail.com");
	policy.getInsurant().getContactData().setPhone("+7 (701) 937-79-79");
    }

    private void buildTestDataManyVehicles() throws ValidationException {
	InsuredDriverData drv2 = driverFacade.add(policy);
	drv2.setIdNumber("870622300359");
	driverFacade.fetchInfo(policy, drv2);
	drv2.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	drv2.getResidenceData().setCity(KZCityDict.ALM);
	drv2.getDriverLicenseData().setNumber("123");
	drv2.getDriverLicenseData().setDateOfIssue(new Date());
	drv2.setHasAnyPrivilege(false);

	InsuredVehicleData vhc1 = vehicleFacade.add(policy);
	vhc1.getVehicleData().setVinCode("JN1TANS51U0303376");
	vehicleFacade.fetchInfo(policy, vhc1);
	vhc1.getVehicleCertificateData().setRegion(CountryRegionDict.GALM);
	vehicleFacade.evaluateMajorCity(vhc1);
	policyFacade.calculatePremiumCost(policy);

	InsuredVehicleData vhc2 = vehicleFacade.add(policy);
	vhc2.getVehicleData().setVinCode("WDB2030421F503751");
	vehicleFacade.fetchInfo(policy, vhc2);
	vhc2.getVehicleCertificateData().setRegion(CountryRegionDict.GALM);
	vehicleFacade.evaluateMajorCity(vhc2);
	policyFacade.calculatePremiumCost(policy);
    }

    public void buildTestDataManyDrivers() throws ValidationException {
	InsuredDriverData drv1 = driverFacade.add(policy);
	drv1.setIdNumber("570325300699");
	driverFacade.fetchInfo(policy, drv1);
	drv1.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	drv1.getResidenceData().setCity(KZCityDict.ALM);
	drv1.getResidenceData().setAddress("Джамбула, 231");
	drv1.getResidenceData().setResident(true);
	drv1.getOriginData().setCountry(CountryDict.KAZ);
	drv1.getDriverLicenseData().setNumber("123");
	drv1.getDriverLicenseData().setDateOfIssue(new Date());
	drv1.setHasAnyPrivilege(true);
	drv1.setGpwParticipant(true);
	drv1.getGpwParticipantCertificateData().setNumber("123");
	drv1.getGpwParticipantCertificateData().setDateOfIssue(new Date());
	drv1.setHandicaped(true);
	drv1.getHandicapedCertificateData().setNumber("123");
	drv1.getHandicapedCertificateData().setValidFrom(new Date());
	drv1.getHandicapedCertificateData().setValidTill(new Date());
	drv1.setPensioner(true);
	drv1.getPensionerCertificateData().setNumber("123");
	drv1.getPensionerCertificateData().setDateOfIssue(new Date());
	drv1.setPriveleger(true);
	drv1.getPrivilegerCertificateData().setType("123");
	drv1.getPrivilegerCertificateData().setNumber("123");
	drv1.getPrivilegerCertificateData().setDateOfIssue(new Date());

	InsuredDriverData drv2 = driverFacade.add(policy);
	drv2.setIdNumber("870622300359");
	driverFacade.fetchInfo(policy, drv2);
	drv2.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	drv2.getResidenceData().setCity(KZCityDict.ALM);
	// drv2.getResidenceData().setAddress("Джамбула, 231");
	// drv2.getResidenceData().setResident(true);
	// drv2.getOriginData().setCountry(CountryDict.KAZ);
	drv2.getDriverLicenseData().setNumber("123");
	drv2.getDriverLicenseData().setDateOfIssue(new Date());
	drv2.setHasAnyPrivilege(false);

	InsuredDriverData drv3 = driverFacade.add(policy);
	drv3.setIdNumber("800225000319");
	driverFacade.fetchInfo(policy, drv3);
	drv3.setAgeClass(InsuredAgeClassEnum.OVER25);
	drv3.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	drv3.getPersonalData().setName("Вадим");
	drv3.getPersonalData().setSurename("Исаев");
	drv3.getPersonalData().setPatronymic("Олегович");
	Calendar dob = Calendar.getInstance();
	dob.set(1980, Calendar.FEBRUARY, 25);
	drv3.getPersonalData().setDayOfBirth(dob.getTime());
	drv3.getPersonalData().setSex(SexDict.MALE);
	drv3.getIdentityCardData().setType(IdentityCardTypeDict.PASSPORT);
	drv3.getIdentityCardData().setDateOfIssue(new Date());
	drv3.getIdentityCardData().setIssuingAuthority("МВД РФ");
	drv3.getIdentityCardData().setNumber("123123123");
	drv3.getResidenceData().setCity(KZCityDict.ALM);
	drv3.getResidenceData().setAddress("Джамбула, 231");
	drv3.getResidenceData().setResident(true);
	drv3.getOriginData().setCountry(CountryDict.KAZ);
	drv3.getDriverLicenseData().setNumber("123");
	drv3.getDriverLicenseData().setDateOfIssue(new Date());
	drv3.setHasAnyPrivilege(false);

	InsuredDriverData drv4 = driverFacade.add(policy);
	drv4.setIdNumber("860401402685");
	driverFacade.fetchInfo(policy, drv4);
	drv4.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	drv4.getPersonalData().setSex(SexDict.FEMALE);
	drv4.getIdentityCardData().setIssuingAuthority("МВД РК");

	drv4.getResidenceData().setCity(KZCityDict.ALM);
	drv4.getResidenceData().setAddress("Джамбула, 231");
	drv4.getResidenceData().setResident(true);
	drv4.getOriginData().setCountry(CountryDict.KAZ);
	drv4.getDriverLicenseData().setNumber("123");
	drv4.getDriverLicenseData().setDateOfIssue(new Date());
	drv4.setHasAnyPrivilege(false);

	InsuredVehicleData vhc1 = vehicleFacade.add(policy);
	vhc1.getVehicleData().setVinCode("JN1TANS51U0303376");
	vehicleFacade.fetchInfo(policy, vhc1);
	vhc1.getVehicleCertificateData().setRegion(CountryRegionDict.GALM);
	vehicleFacade.evaluateMajorCity(vhc1);
	policyFacade.calculatePremiumCost(policy);
    }

    public void addInsuredDriver() {
	try {
	    driverFacade.add(policy);
	} catch (ValidationException e) {
	    FacesContext.getCurrentInstance().addMessage(null,
		    new FacesMessage(FacesMessage.SEVERITY_WARN,
			    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
			    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void removeInsuredDriver(InsuredDriverData driver) {
	try {
	    driverFacade.remove(policy, driver);
	} catch (ValidationException e) {
	    FacesContext.getCurrentInstance().addMessage(null,
		    new FacesMessage(FacesMessage.SEVERITY_WARN,
			    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
			    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void addInsuredVehicle() {
	try {
	    vehicleFacade.add(policy);
	} catch (ValidationException e) {
	    FacesContext.getCurrentInstance().addMessage(null,
		    new FacesMessage(FacesMessage.SEVERITY_WARN,
			    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
			    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void removeInsuredVehicle(InsuredVehicleData insuredVehicle) {
	try {
	    vehicleFacade.remove(policy, insuredVehicle);
	} catch (ValidationException e) {
	    FacesContext.getCurrentInstance().addMessage(null,
		    new FacesMessage(FacesMessage.SEVERITY_WARN,
			    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
			    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void doCalculatePolicyCost() {
	policyFacade.calculatePremiumCost(policy);
    }

    public void onDriverIdNumberChanged(InsuredDriverData insuredDriver) {
	try {
	    driverFacade.fetchInfo(policy, insuredDriver);
	} catch (ValidationException e) {
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void onPolicyCostCalculationFormChanged() {
	policyFacade.calculatePremiumCost(policy);
    }

    public void onVehicleVinCodeChanged(InsuredVehicleData insuredVehicle) {
	try {
	    vehicleFacade.fetchInfo(policy, insuredVehicle);
	} catch (ValidationException e) {
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void onVehicleRegionChanged(InsuredVehicleData insuredVehicle) {
	vehicleFacade.evaluateMajorCity(insuredVehicle);
	policyFacade.calculatePremiumCost(policy);
    }

    // GENERATED

    public PolicyRequestData getPolicy() {
	return policy;
    }

    public boolean isRequestSent() {
	return requestSent;
    }
}
