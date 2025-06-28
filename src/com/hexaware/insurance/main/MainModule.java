package com.hexaware.insurance.main;

import java.util.Scanner;

import com.hexaware.insurance.dao.InsuranceServiceImpl;
import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.exception.PolicyNotFoundException;
import com.hexaware.insurance.util.DBConnUtil;

public class MainModule {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        InsuranceServiceImpl service = new InsuranceServiceImpl();

        while (true) {
        	System.out.println("\n>>>--- Insurance_System ---<<<");
            System.out.println("\nSelect the option you want to perform from (1-7)");
            System.out.println("1. Create policy");
            System.out.println("2. View policy");
            System.out.println("3. View all policies");
            System.out.println("4. Update policy");
            System.out.println("5. Delete policy");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int ch = s.nextInt();
            s.nextLine();

            switch (ch) {
                case 1:
                    System.out.println("\n-- Create new policy --");
                    System.out.print("Enter policyId: ");
                    int id = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter policy name: ");
                    String name = s.nextLine();
                    System.out.print("Enter policy type: ");
                    String type = s.nextLine();
                    System.out.print("Enter premium: ");
                    String premium = s.nextLine();

                    boolean success = service.createPolicy(new Policy(id, name, type, premium));
                    System.out.println(success ? "Policy successfully created\n" : "Failed to create policy. Try again\n");
                    break;

                case 2:
                    System.out.println("\n-- View policy by ID --");
                    System.out.print("Enter policyId: ");
                    int pid = s.nextInt();
                    try {
                        System.out.println(service.getPolicy(pid));
                    } catch (PolicyNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n-- Viewing all policies --");
                    System.out.println(service.getAllPolicies());
                    break;

                case 4:
                    System.out.println("\n-- Update policy --");
                    System.out.print("Enter policyId: ");
                    int updateId = s.nextInt();
                    s.nextLine();
                    Policy existingPolicy;
                    try {
                        existingPolicy = service.getPolicy(updateId);
                    } catch (PolicyNotFoundException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    boolean keepUpdating = true;
                    while (keepUpdating) {
                        System.out.println("Choose which field to update:");
                        System.out.println("1. Policy Name\n2. Policy Type\n3. Premium\n4. Exit");
                        System.out.print("Enter your choice: ");
                        int choice = s.nextInt();
                        s.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.print("Enter new policy name: ");
                                existingPolicy.setPolicyName(s.nextLine());
                                break;
                            case 2:
                                System.out.print("Enter new policy type: ");
                                existingPolicy.setPolicyType(s.nextLine());
                                break;
                            case 3:
                                System.out.print("Enter new premium: ");
                                existingPolicy.setPremium(s.nextLine());
                                break;
                            case 4:
                                keepUpdating = false;
                                continue;
                            default:
                                System.out.println("Invalid choice");
                                continue;
                        }

                        boolean updated = service.updatePolicy(existingPolicy);
                        System.out.println(updated ? "Policy updated successfully\n" : "Failed to update policy\n");
                    }
                    break;

                case 5:
                    System.out.println("\n-- Delete policy --");
                    System.out.print("Enter policyId: ");
                    int policyId = s.nextInt();
                    boolean deleted = service.deletePolicy(policyId);
                    System.out.println(deleted ? "Policy deleted successfully" : "Deletion failed");
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    DBConnUtil.closeConnection();
                    s.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter 1–7.");
            }
        }
    }
}
