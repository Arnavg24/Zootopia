package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Visitor implements Feedback,Cloneable{

    @Override
    public Visitor clone() {
        try {
            return (Visitor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    private static double revenue =0;

    private String name;
    private int age;
    private long phoneNumber;
    private double balance;
    private String email;
    private String password;
    private String type;
    private String message;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVisitorList(List<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    private List<String> feedback;

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRevenue() {
        return revenue;
    }

    public static void setRevenue(double revenue) {
        Visitor.revenue = revenue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Visitor(String name, int age, long phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.type = "0";
        this.message="No feedback given till now";

    }

    public Visitor(){
        this.visitorList = new ArrayList<>();
        this.feedback = new ArrayList<>();
        this.tickets = new HashMap<>();

        this.type="0";
    }


    private List<Visitor> visitorList;

    public void addUser(Visitor user) {
        visitorList.add(user);
    }

    public List<Visitor> getVisitorList() {
        return visitorList;
    }



    public void exploreZoo() {
        System.out.println("1.View Attractions");
        System.out.println("2.View Animals");
        System.out.println("3.Exit ");

    }

    public void printAttractions(Admin admin) {
        List<Attractions> attractions = admin.getAttractions();
//        int count = 1;
        for (Attractions attraction : attractions) {
            if (attraction.isOpenClose()) {
                System.out.println(attraction.getUniqueid() + ". " + attraction.getName() + ": " + attraction.getDescription());
//                count++;
            }
        }
    }


    public void printAnimals(Admin admin) {
        List<Animal> animals = admin.getAnimals(); // Assuming there's a getter method for animals list in the Visitor class
        int count = 1;
        for (Animal animal : animals) {
            System.out.println(count + ". " + animal.getName() + ": " + animal.getType());
            count++;
        }
    }




    public int checkUserByEmail(String email) {
        for (Visitor user : visitorList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return 1;
            }
        }
        return -1;
    }


    public int checkPassword(String email, String password) {
        for (Visitor visitor : visitorList) {
            if (visitor.getEmail().equalsIgnoreCase(email) && visitor.getPassword().equals(password)) {
                return 1;
            }
        }
        return -1;
    }


    public int findVisitorIndexByEmail(String email) {
        for (int i = 0; i < visitorList.size(); i++) {
            if (visitorList.get(i).getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }



    public double getDiscountPercentage(String discountName, Discount discount) {
        Map<String, Double> discounts = discount.getDiscounts();
        String lowerCaseDiscountName = discountName.toLowerCase();
        for (Map.Entry<String, Double> entry : discounts.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(lowerCaseDiscountName)) {
                if (lowerCaseDiscountName.equals("minor") && this.age < 18) {
                    return 10;
                } else if (lowerCaseDiscountName.equals("senior") && this.age > 60) {
                    return 20;
                } else {
                    return entry.getValue();
                }
            }
        }
        return 0;
    }

    public boolean isDiscountCodeValid(String discountName, Discount discount) {
        Map<String, Double> discounts = discount.getDiscounts();
        return discounts.containsKey(discountName.toLowerCase());
    }




    public void buyMembership(Visitor visitor,int choice,double off) {
        double cost=0;
        if(choice==1){
            cost = 20;
        } else if (choice==2) {
            cost = 50;
        }

        cost=((100.0-off) * cost)/100;

        if(cost>visitor.getBalance()){
            System.out.println("Insufficient balance");
            return;
        }
        else{
            double rem = visitor.getBalance() - cost;
            visitor.setBalance(rem);
            revenue+=cost;

            if(choice ==1){
                visitor.setType("basic");
                for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
                    entry.setValue(0);
                }
                System.out.println("Basic membership purchased successfully. Your balance is now " + visitor.getBalance() +" ruppees");
            } else if (choice ==2) {
                visitor.setType("premium");
                for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
                    entry.setValue(1);
                }
                System.out.println("Premium membership purchased successfully. Your balance is now " + visitor.getBalance() +" ruppees");
            }
        }
//        if(visitor.getBalance()<20){
//            System.out.println("Insufficient balance");
//        } else if (visitor.getBalance() > 20 && visitor.getBalance() <50) {
//            if(choice ==1){
//                visitor.setType("basic");
//
//            }
//            else{
//                System.out.println("Insufficient balance");
//            }
//        } else if (visitor.getBalance() >50 ) {
//            if(choice==1){
//                visitor.setType("basic");
//            } else if (choice==2) {
//                visitor.setType("premium");
//            }
//        }
    }

    private Map<Attractions, Integer> tickets;

    public void addTicket(Attractions attraction, int count) {
        if (tickets.containsKey(attraction)) {
            int currentTicksCount = tickets.get(attraction);
            tickets.put(attraction, currentTicksCount + count);
        } else {
            tickets.put(attraction, count);
        }
    }

    public void modifyAttractionNameInTickets(String oldName, String newName) {
        for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(oldName)) {
                int count = entry.getValue();
                tickets.remove(entry.getKey());
                Attractions newAttraction = new Attractions(newName, entry.getKey().getDescription());
                tickets.put(newAttraction, count);
//                System.out.println("Attraction name updated successfully.");
                return;
            }
        }
//        System.out.println("No such attraction found.");
    }

    public void removeAttractionFromTickets(String attractionName) {
        for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(attractionName)) {
                tickets.remove(entry.getKey());
//                System.out.println("Attraction removed successfully.");
                return;
            }
        }
//        System.out.println("No such attraction found.");
    }





    public void updateTickets(Attractions attraction, int newTicketCount) {
        if (tickets.containsKey(attraction)) {
            tickets.put(attraction, newTicketCount);
        }
    }


    public Map<Attractions, Integer> getTickets() {
        return tickets;
    }

//    int count =1;

    public void printOpenAttractions() {
        if (tickets != null && !tickets.isEmpty()) {
            for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
                Attractions attraction = entry.getKey();
//                attraction.setUniqueid(count);
//                count++;
//                System.out.println(attraction.isOpenClose());
                if (attraction != null && attraction.isOpenClose()) {
                    System.out.println(attraction.getUniqueid() + "." + attraction.getName() + " ( " + attraction.getTickPrice() + ")");
                }
            }
        } else {
            System.out.println("No tickets available.");
        }
    }


    public void updateAttractionStatusInTickets(String attractionName, boolean isOpen, double price) {
        for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
            Attractions attraction = entry.getKey();
            attraction.setTickPrice(price);
            if (attraction.getName().equals(attractionName)) {
                attraction.setOpenClose(isOpen);
                return;
            }
        }
    }




    public Attractions getAttractionFromCode(int attractionCode) {
        for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
            Attractions attraction = entry.getKey();
            if (attraction.getUniqueid().equals(attractionCode)) {
                return attraction;
            }
        }
        return null;
    }

    public void makeAllAttractionTicketsOne() {
        for (Map.Entry<Attractions, Integer> entry : tickets.entrySet()) {
            entry.setValue(1);
        }
    }



    public double getSpecialDealPercentage(int numberOfTickets, Discount discount) {
        Map<Integer, Double> specialDeals = discount.getSpecialDeals();

        if (specialDeals.containsKey(numberOfTickets)) {
            return specialDeals.get(numberOfTickets);
        } else {
            int maxKeySmallerThanNumberOfTickets = 0;
            for (int key : specialDeals.keySet()) {
                if (key < numberOfTickets && key > maxKeySmallerThanNumberOfTickets) {
                    maxKeySmallerThanNumberOfTickets = key;
                }
            }
            if (maxKeySmallerThanNumberOfTickets == 0) {
                return 0;
            }
            return specialDeals.getOrDefault(maxKeySmallerThanNumberOfTickets, 0.0);
        }
    }






    public void buyTickets(Visitor visitor,int attractionCode , int numberOFticks,double discountPercentage , double dealPercentage) {
        Attractions attraction = getAttractionFromCode(attractionCode);
        double cost = (attraction.getTickPrice()) * numberOFticks;

        if((discountPercentage+dealPercentage) >=100){
            cost=0;
        }
        else{
            cost = (100-discountPercentage-dealPercentage)*cost/100;
        }

        if(visitor.getBalance() < cost){
            System.out.println("Insufficient balance to buy tickets");
        } else if (visitor.getBalance() > cost) {
            double rem = visitor.getBalance() - cost ;
            visitor.setBalance(rem);
            revenue+=cost;
            int new_numberOfTicks = tickets.get(attraction) +numberOFticks;
            tickets.put(attraction,new_numberOfTicks);
        }


    }




    public int addBasicAndPremiumVisitors() {
        int count =0;
        for (Visitor visitor : visitorList) {
            if (visitor.getType().equalsIgnoreCase("Basic")) {
                count += 1;
            } else if (visitor.getType().equalsIgnoreCase("Premium")) {
                count += 1;
            }
        }
        return count;
    }




    public void leaveFeedback(String message) {
        feedback.add(message);
        this.setMessage(message);
    }

    @Override
    public void printFeedback(Visitor visitor) {
        System.out.println("Feedback:");
        if(feedback.isEmpty()){
            System.out.println("No feedback given till now");
        }else {
            int count = 1;
            for (String message : feedback) {
                System.out.println(count + ". " + message);
                count++;
            }
        }
    }
}
