import java.util.*;

public class RentCalculator {
    private double utilityCost;
    private HashMap<String, Integer> residents;

    public RentCalculator(double utilityCost) {
        this.utilityCost = utilityCost;
        this.residents = new HashMap<>();
    }

    public RentCalculator() {
        this(0.0);
    }

    public RentCalculator(double utilityCost, HashMap<String, Integer> residents) {
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
