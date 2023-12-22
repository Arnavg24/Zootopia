package org.example;

import java.util.HashMap;
import java.util.Map;

public class Discount{
    private Map<String, Double> discounts;

    public void setDiscounts(Map<String, Double> discounts) {
        this.discounts = discounts;
    }

    public Discount() {
        this.discounts = new HashMap<>();
        this.specialDeals= new HashMap<>();

        discounts.put("Minor",10.0);
        discounts.put("Senior Citizen", 20.0);
        discounts.put("None" , 0.0);

        specialDeals.put(2,15.0);
        specialDeals.put(3,30.0);
    }

    public void addDiscount(String name, double percentage) {
        if (percentage <= 0 || percentage > 100) {
            System.out.println("Discount percentage should be between 0 and 100.");
        } else {
            discounts.put(name, percentage);
//            System.out.println("Discount added successfully");
        }
    }

    public void removeDiscount(String name) {
        if (discounts.containsKey(name)) {
            discounts.remove(name);
//            System.out.println("Discount removed successfully");
        } else {
            System.out.println("No such discount exists");
        }
    }


    public Map<String, Double> getDiscounts() {
        return discounts;
    }

    @Override
    public String toString() {
        String result = "View Discounts:\n";
        int count = 1;
        for (Map.Entry<String, Double> entry : discounts.entrySet()) {
            result += count + ". " + entry.getKey() + " (" + entry.getValue() + "% discount)\n";
            count++;
        }
        return result;
    }

    public Map.Entry<String, Double> getDiscountFromName(String discountName) {
        for (Map.Entry<String, Double> entry : discounts.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(discountName)) {
                return entry;
            }
        }
        return null;
    }


    public void viewAvailableDiscounts() {
        System.out.println("Available Discounts:");
        for (String name : discounts.keySet()) {
            System.out.println(name + ": " + discounts.get(name) + "%");
        }
    }

    private Map<Integer, Double> specialDeals;
    public Map<Integer, Double> getSpecialDeals() {
        return specialDeals;
    }

    public void setSpecialDeals(Map<Integer, Double> specialDeals) {
        this.specialDeals = specialDeals;
    }


    public void addSpecialDeal(int numberOfTickets, double percentage) {
        if (percentage <= 0 || percentage > 100) {
            System.out.println("Discount percentage should be between 0 and 100.");
        } else {
            specialDeals.put(numberOfTickets, percentage);
        }
    }

    public void removeSpecialDeal(int numberOfTickets) {
        if (specialDeals.containsKey(numberOfTickets)) {
            specialDeals.remove(numberOfTickets);
        } else {
            System.out.println("No such special deal exists");
        }
    }

    public Map.Entry<Integer, Double> getSpecialDealFromNumberOfTickets(int numberOfTickets) {
        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
            if (entry.getKey() == numberOfTickets) {
                return entry;
            }
        }
        return null;
    }

    public void viewAvailableSpecialDeals() {
        System.out.println("Available Special Deals:");
        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
            System.out.println("Number of Tickets: " + entry.getKey() + " - " + entry.getValue() + "% discount");
        }
    }


}

