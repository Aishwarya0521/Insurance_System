package com.hexaware.insurance.dao;

import java.util.List;
import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.exception.PolicyNotFoundException;

public interface IPolicyService {
    boolean createPolicy(Policy policy);
    Policy getPolicy(int policyId) throws PolicyNotFoundException;
    List<Policy> getAllPolicies();
    boolean updatePolicy(Policy policy);
    boolean deletePolicy(int policyId);
}
