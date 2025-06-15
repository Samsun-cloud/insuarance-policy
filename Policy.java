/**
 * The Policy class models an insurance policy.
 * It includes policy details and provides methods
 * to calculate BMI and policy price.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * Default constructor.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructs a Policy object with the specified data.
     * @param policyNumber Policy number
     * @param providerName Provider name
     * @param firstName Policyholder first name
     * @param lastName Policyholder last name
     * @param age Policyholder age
     * @param smokingStatus Smoking status
     * @param height Height in inches
     * @param weight Weight in pounds
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /** @return the policy number */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /** @return the provider name */
    public String getProviderName() {
        return providerName;
    }

    /** @return the policyholder's first name */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /** @return the policyholder's last name */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /** @return the policyholder's age */
    public int getPolicyholderAge() {
        return policyholderAge;
    }

    /** @return the smoking status */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /** @return the height in inches */
    public double getHeight() {
        return height;
    }

    /** @return the weight in pounds */
    public double getWeight() {
        return weight;
    }

    /**
     * Calculates and returns the BMI.
     * @return the Body Mass Index
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the price of the policy.
     * @return the price of the policy
     */
    public double calculatePolicyPrice() {
        final double BASE_PRICE = 600.0;
        final double ADDITIONAL_FEE_AGE = 75.0;
        final double ADDITIONAL_FEE_SMOKER = 100.0;
        final double ADDITIONAL_FEE_PER_BMI = 20.0;

        double price = BASE_PRICE;

        if (policyholderAge > 50) {
            price += ADDITIONAL_FEE_AGE;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += ADDITIONAL_FEE_SMOKER;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * ADDITIONAL_FEE_PER_BMI;
        }

        return price;
    }
}
