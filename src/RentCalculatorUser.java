import java.util.*;

public class RentCalculatorUser {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Rent Calculator! What is the total utility bill?" );
        double utility = console.nextDouble();
        RentCalculator rent = new RentCalculator(utility);

        System.out.println("What would you like to do?");
        System.out.println("Choices: (add) Resident, (remove) Resident, (print) Payments, " +
                "(list) Residents, (change) utility, (quit)");
        String choice = console.next();
        while(!choice.equals("quit")) {
            if(choice.equals("add")) {
                System.out.println("What is the name of the resident? ");
                String name = console.next();
                System.out.println("How many days did they stay? ");
                int days = console.nextInt();
                rent.addResident(name, days);
                System.out.println("Added " + name + ", " + days + " days.");
            } else if(choice.equals("remove")) {
                System.out.println("Who do you want to remove? ");
                String name = console.next();
                boolean exists = false;
                for(String resident : rent.getResidents()) {
                    if(resident.equals(name)) {
                        exists = true;
                    }
                }
                if(exists) {
                    rent.removeResident(name);
                    System.out.println("Removed " + name);
                } else {
                    System.out.println("Resident does not exist.");
                }
            } else if(choice.equals("print")) {
                System.out.println();
                rent.printPayments();
                System.out.println();
            } else if(choice.equals("list")) {
                System.out.println(rent.getResidents());
            } else if(choice.equals("change")) {
                System.out.println("What would you like the new utility bill to be? ");
                rent.setUtilityCost(console.nextDouble());
                System.out.println("New utility bill is " + rent.getUtilityCost());
            } else {
                System.out.println("Please enter a valid choice!");
            }
            System.out.println("What would you like to do?");
            System.out.println("Choices: (add) Resident, (remove) Resident, (print) Payments, " +
                    "(list) Residents, (change) utility, (quit)");
            choice = console.next();
        }
    }


}
