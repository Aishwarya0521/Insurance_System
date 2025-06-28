package com.hexaware.insurance.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.exception.PolicyNotFoundException;
import com.hexaware.insurance.util.DBConnUtil;

public class InsuranceServiceImpl implements IPolicyService {

    @Override
    public boolean createPolicy(Policy policy) {
        String sql = "INSERT INTO Policy (policyId, policyName, policyType, premium) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, policy.getPolicyId());
            ps.setString(2, policy.getPolicyName());
            ps.setString(3, policy.getPolicyType());
            ps.setString(4, policy.getPremium());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error inserting policy: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Policy getPolicy(int policyId) throws PolicyNotFoundException {
        String sql = "SELECT * FROM Policy WHERE policyId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, policyId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyName"),
                    rs.getString("policyType"),
                    rs.getString("premium")
                );
            } else {
                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
            }

        } catch (SQLException e) {
            throw new PolicyNotFoundException("Error fetching policy: " + e.getMessage());
        }
    }

    @Override
    public List<Policy> getAllPolicies() {
        List<Policy> list = new ArrayList<>();
        String sql = "SELECT * FROM Policy";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Policy policy = new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyName"),
                    rs.getString("policyType"),
                    rs.getString("premium")
                );
                list.add(policy);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching policies: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String sql = "UPDATE Policy SET policyName = ?, policyType = ?, premium = ? WHERE policyId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, policy.getPolicyName());
            ps.setString(2, policy.getPolicyType());
            ps.setString(3, policy.getPremium());
            ps.setInt(4, policy.getPolicyId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating policy: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        String sql = "DELETE FROM Policy WHERE policyId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, policyId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting policy: " + e.getMessage());
            return false;
        }
    }
}
