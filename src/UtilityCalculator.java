// Bowen Liu
// 08/23/2024
import java.util.*;

// This is a RentCalculator class that calculates the amount of rent or utility owed to the
// landlord for an amount of time. It prints the results to the console for the user.
public class UtilityCalculator {
    private double utilityCost;
    private HashMap<String, Integer> residents;

    public UtilityCalculator(double utilityCost) {
        this.utilityCost = utilityCost;
        this.residents = new HashMap<>();
    }

    public UtilityCalculator() {
        this(0.0);
    }

    public UtilityCalculator(double utilityCost, HashMap<String, Integer> residents) {
        this.utilityCost = utilityCost;
        this.residents = new HashMap<>(residents);
    }

    public double getUtilityCost() {
        return utilityCost;
    }

    public void setUtilityCost(double utilityCost) {
        this.utilityCost = utilityCost;
    }

    public Set<String> getResidents() {
        return residents.keySet();
    }

    public void addResident(String name, int days) {
        residents.put(name, days);
    }

    public void removeResident(String name) {
        residents.remove(name);
    }

    // This method calculates the total rent due for each resident based on the number of days
    // they spent in the house over the utility bill time.
    private Map<String, Double> getPayments() {
        int totalDays = 0;
        for(String name : residents.keySet()) {
            totalDays += residents.get(name);
        }

        Map<String, Double> payments = new TreeMap<>();
        for(String name : residents.keySet()) {
            double cost = (1.0 * residents.get(name) / totalDays) * utilityCost;
            payments.put(name, cost);
        }

        return payments;
    }

    public void printPayments() {
        Map<String, Double> payments = getPayments();
        System.out.println("Total Utility: " + getUtilityCost());
        for(String name : payments.keySet()) {
            System.out.println(name+": " + Math.ceil(payments.get(name) * 100) / 100);
        }
    }
}
