import java.io.*;
import java.util.*;

public class Policydemo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("PolicyInformation.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+");

                if (data.length == 8) {
                    int policyNumber = Integer.parseInt(data[0]);
                    String providerName = data[1];
                    String firstName = data[2];
                    String lastName = data[3];
                    int age = Integer.parseInt(data[4]);
                    String smokingStatus = data[5];
                    double height = Double.parseDouble(data[6]);
                    double weight = Double.parseDouble(data[7]);

                    Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                    policies.add(policy);

                    // Count smokers and non-smokers
                    if (smokingStatus.equalsIgnoreCase("smoker")) {
                        smokerCount++;
                    } else {
                        nonSmokerCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Display Policy Details
        for (Policy p : policies) {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder: " + p.getPolicyholderFirstName() + " " + p.getPolicyholderLastName());
            System.out.println("Age: " + p.getPolicyholderAge());
            System.out.println("Smoking Status: " + p.getSmokingStatus());
            System.out.println("Height: " + p.getHeight() + " inches");
            System.out.println("Weight: " + p.getWeight() + " pounds");
            System.out.println("BMI: " + p.calculateBMI());
            System.out.println("Policy Price: $" + p.calculatePolicyPrice());
            System.out.println("-------------------------------------");
        }

        System.out.println("Total Smokers: " + smokerCount);
        System.out.println("Total Non-Smokers: " + nonSmokerCount);
    }
}
