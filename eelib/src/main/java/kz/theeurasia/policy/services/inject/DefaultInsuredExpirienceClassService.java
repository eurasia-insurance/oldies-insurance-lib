package kz.theeurasia.policy.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuredExpirienceClass;

import kz.theeurasia.policy.services.InsuredExpirienceClassService;

@Named("insuredExpirienceClassService")
@ApplicationScoped
public class DefaultInsuredExpirienceClassService extends EnumService<InsuredExpirienceClass> implements InsuredExpirienceClassService {

    public List<InsuredExpirienceClass> getAllItems() {
	return CollectionUtils.toList(InsuredExpirienceClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuredExpirienceClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return InsuredExpirienceClass.BUNDLE_VAR;
    }
}