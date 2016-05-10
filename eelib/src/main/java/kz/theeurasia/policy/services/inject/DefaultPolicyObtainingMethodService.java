package kz.theeurasia.policy.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.PolicyObtainingMethod;

import kz.theeurasia.policy.services.PolicyObtainingMethodService;

@Named("policyObtainingMethodService")
@ApplicationScoped
public class DefaultPolicyObtainingMethodService extends EnumService<PolicyObtainingMethod>
	implements PolicyObtainingMethodService {

    public List<PolicyObtainingMethod> getAllItems() {
	return CollectionUtils.toList(PolicyObtainingMethod.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PolicyObtainingMethod.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return PolicyObtainingMethod.BUNDLE_VAR;
    }
}