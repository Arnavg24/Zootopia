package org.example;

import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Discount discount = new Discount();
        Visitor visitor = new Visitor();

        while (true){
            System.out.println("1. Enter as an admin");
            System.out.println("2. Enter as a visitor");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");

            HashMap<String, String> adminCredentials = new HashMap<>();
            adminCredentials.put("admin", "admin123");
            adminCredentials.put("Arnav", "2022100");

            int choice =scanner.nextInt();
            scanner.nextLine();

            if(choice==1){
                System.out.println("Enter admin Username: ");
                String username = scanner.nextLine();

                System.out.println("Enter admin Password: ");
                String password = scanner.nextLine();

                if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
                    System.out.println("Logged in as admin with username " + username);
                    System.out.println();
                    while (true) {
                        System.out.println("1. Manage Attractions");
                        System.out.println("2. Manage Animals");
                        System.out.println("3. Schedule Events");
                        System.out.println("4. Set Discounts");
                        System.out.println("5. Set Special Deal");
                        System.out.println("6. View Visitor Stats");
                        System.out.println("7. View Feedback");
                        System.out.println("8. Exit");
                        System.out.println();

                        int choice2 = scanner.nextInt();
                        scanner.nextLine();

                        if (choice2 == 1) {
                            while (true) {
                                System.out.println("Manage Attractions:");
                                System.out.println("1. Add Attraction");
                                System.out.println("2. View Attractions");
                                System.out.println("3. Modify Attraction");
                                System.out.println("4. Remove Attraction");
                                System.out.println("5. Exit");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine();

                                if (choice3 == 1) {
                                    System.out.println("Enter Attraction Name: ");
                                    String attractionName = scanner.nextLine();
                                    System.out.println("Enter Attraction Description: ");
                                    String attractionDescription = scanner.nextLine();

                                    Attractions attraction = new Attractions(attractionName,attractionDescription);
                                    admin.addAttraction(attractionName, attractionDescription);
//                                    System.out.println(visitor.getType());

                                    if(visitor.getType().equalsIgnoreCase("premium")){
                                        visitor.addTicket(attraction,1);
                                    }else {
                                        visitor.addTicket(attraction, 0);
//                                        System.out.println("executed");
                                    }

                                } else if (choice3 == 2) {
                                    admin.viewAttractions();

                                } else if (choice3 == 3) {
                                    System.out.println("Enter the name of attraction to modify:");
                                    String name = scanner.nextLine();
                                    if (admin.checkAttracions(name) == -1) {
                                        System.out.println("Attraction with given name does not exist");
                                    } else {
                                        System.out.println("Enter the new Attraction Name: ");
                                        String newName = scanner.nextLine();
                                        System.out.println("Enter Attraction Description: ");
                                        String newDescription = scanner.nextLine();

                                        visitor.modifyAttractionNameInTickets(name,newName);

                                        admin.modifyAttractions(name, newName, newDescription);
                                    }
                                } else if (choice3 == 4) {
                                    System.out.println("Enter the name of attraction to delete:");
                                    String name = scanner.nextLine();
                                    admin.removeAttractions(name);
                                    visitor.removeAttractionFromTickets(name);

                                } else if (choice3 == 5) {
                                    break;
                                } else {
                                    System.out.println("Invalid option");
                                }
                            }
                        } else if (choice2 == 2) {
                            while (true){
                                System.out.println("1. Add Animal");
                                System.out.println("2. Update Animal Details");
                                System.out.println("3. Remove Animal");
                                System.out.println("4. Exit");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine();

                                if(choice3==1) {
                                    System.out.println("Enter animal name: ");
                                    String animalName = scanner.nextLine();

                                    System.out.println("Enter animal type: ");
                                    String animalType = scanner.nextLine();

                                    System.out.println("Enter animal sound: ");
                                    String sound = scanner.nextLine();

                                    System.out.println("Enter animal history: ");
                                    String history = scanner.nextLine();

                                    if(admin.isAnimalInList(animalName)){
                                        System.out.println("The animal already exits in the zoo");
                                    }
                                    else {
                                        if (animalType.equalsIgnoreCase("Mammal")) {
                                            Animal animal = new Mammal(animalName,sound,history);
                                            admin.addAnimal(animal);
                                            System.out.println("Animal added to zoo");
                                        } else if (animalType.equalsIgnoreCase("Reptile")) {
                                            Animal animal = new Reptile(animalName,sound,history);
                                            admin.addAnimal(animal);
                                            System.out.println("Animal added to zoo");
                                        } else if (animalType.equalsIgnoreCase("Amphibian")) {
                                            Animal animal = new Amphibian(animalName,sound,history);
                                            admin.addAnimal(animal);
                                            System.out.println("Animal added to zoo");
                                        } else {
                                            System.out.println("No such animal type exists in the zoo");
                                            break;
                                        }
                                    }
                                } else if (choice3==2) {
                                    System.out.println("Name of animal to update details:");
                                    String oldName = scanner.nextLine();

                                    if(admin.isAnimalInList(oldName)){
                                        Animal animal = admin.getAnimalByName(oldName);
                                        System.out.println("Enter new name:");
                                        String newName = scanner.nextLine();
                                        animal.setName(newName);
                                        System.out.println("Animal details updated");
                                    }else{
                                        System.out.println("No such animal exists");
                                    }
                                } else if (choice3==3) {
                                    System.out.println("Name of animal to delete:");
                                    String oldName = scanner.nextLine();
                                    if(admin.isAnimalInList(oldName)){
                                        Animal animal = admin.getAnimalByName(oldName);
                                        admin.removeAnimal(animal);
                                        System.out.println(animal.getName() +" removed fromt the zoo");
                                    }else{
                                        System.out.println("No such animal exists");
                                    }
                                } else if (choice3 ==4){
                                    break;
                                }else {
                                    System.out.println("Invalid option");
                                }
                            }
                        } else if (choice2 == 3) {
                            System.out.println("Name of the attraction to be scheduled");
                            String name = scanner.nextLine();

                            System.out.println("To open an attraction enter true else false");
                            boolean onoff = scanner.nextBoolean();

                            System.out.println("Enter the ticket price");
                            double price = scanner.nextDouble();;
                            scanner.nextLine();

                            admin.scheduleEvents(name,onoff,price);
                            visitor.updateAttractionStatusInTickets(name,onoff,price);

                        } else if (choice2 == 4) {
                            while(true) {
                                System.out.println("1. Add Discount");
                                System.out.println("2. Modify Discount");
                                System.out.println("3. Remove Discount");
                                System.out.println("4. Show available discounts");
                                System.out.println("5. Exit");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine();

                                if(choice3==1){
                                    System.out.println("Add discount category:");
                                    String name = scanner.nextLine();

                                    System.out.println("Percentage discount:");
                                    double percentage = scanner.nextDouble();
                                    scanner.nextLine();

                                    if(discount.getDiscountFromName(name) == null) {
                                        discount.addDiscount(name, percentage);
                                        System.out.println("Discount added successfully");
                                    }
                                    else {
                                        System.out.println("A discount for that name already exists");
                                    }
                                } else if (choice3==2) {
                                    System.out.println("Name of discount to be modified:");
                                    String oldName = scanner.nextLine();

                                    if(discount.getDiscounts().containsKey(oldName)){
                                        System.out.println("Enter new name of the discount");
                                        String newName = scanner.nextLine();

                                        System.out.println("Percentage discount:");
                                        double percentage = scanner.nextDouble();
                                        scanner.nextLine();

                                        discount.removeDiscount(oldName);
                                        discount.addDiscount(newName,percentage);
                                        System.out.println("Updated successfully");
                                    }else{
                                        System.out.println("No such discount exists");
                                    }
                                } else if (choice3==3) {
                                    System.out.println("Name of discount to be deleted:");
                                    String name = scanner.nextLine();
                                    if(discount.getDiscounts().containsKey(name)) {
                                        discount.removeDiscount(name);
                                        System.out.println("Discount removed successfully");
                                    }else {
                                        System.out.println("No such discount exists");
                                    }
                                } else if (choice3==4) {
                                    discount.viewAvailableDiscounts();
                                } else {
                                    break;
                                }
                            }
                        } else if (choice2 == 5) {
                            while (true) {
                                System.out.println("1. Add Special Deal");
                                System.out.println("2. Modify Special Deal");
                                System.out.println("3. Remove Special Deal");
                                System.out.println("4. Show available deals");
                                System.out.println("5. Exit");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine();
                                if(choice3==1) {
                                    System.out.println("Number of tickets on which this deal is applied:");
                                    int numberOfTickets = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Percentage discount:");
                                    double percentage = scanner.nextDouble();
                                    scanner.nextLine();

                                    if (discount.getSpecialDealFromNumberOfTickets(numberOfTickets) == null) {
                                        discount.addSpecialDeal(numberOfTickets, percentage);
                                        System.out.println("Special deal added successfully");
                                    } else {
                                        System.out.println("A special deal for that number of tickets already exists");
                                    }
                                }else if (choice3==2) {
                                    System.out.println("Number of tickets whose deal needs to be modified:");
                                    int oldNoOfTicks = scanner.nextInt();
                                    scanner.nextLine();

                                    if (discount.getSpecialDeals().containsKey(oldNoOfTicks)) {
                                        System.out.println("New deal Percentage :");
                                        double percentage = scanner.nextDouble();
                                        scanner.nextLine();

                                        discount.removeSpecialDeal(oldNoOfTicks);
                                        discount.addSpecialDeal(oldNoOfTicks, percentage);
                                        System.out.println("Updated successfully");
                                    } else {
                                        System.out.println("No such deal exists");
                                    }
                                }else if(choice3==3){
                                    System.out.println("Number of tickets whose deal needs to be deleted:");
                                    int noOfTicks = scanner.nextInt();
                                    scanner.nextLine();
                                    if(discount.getSpecialDeals().containsKey(noOfTicks)) {
                                        discount.removeSpecialDeal(noOfTicks);
                                        System.out.println("Special deal removed successfully");
                                    }else {
                                        System.out.println("No such special deal exists");
                                    }
                                }else if(choice3==4){
                                    discount.viewAvailableSpecialDeals();
                                }
                                else {
                                    break;
                                }
                            }
                        } else if (choice2==6) {
                            System.out.println("Visitor stats:");

                            System.out.println("Total visitors:" + visitor.addBasicAndPremiumVisitors());
                            System.out.println("Total Revenue:" + visitor.getRevenue() +" ruppees");

                            System.out.println("Most popular attraction: " + admin.findMostFamousAttraction());
//                            List<String> mostVisitedAttractions = admin.getMostVisitedAttractionNames();
//                            for (int i = 0; i < mostVisitedAttractions.size(); i++) {
//                                System.out.println((i + 1) + ". " + mostVisitedAttractions.get(i));
//                            }

                            System.out.println();
                            System.out.println("------------");


                        } else if (choice2 ==7){
                            visitor.printFeedback(visitor);
                        } else if (choice2 == 8) {
                            break;
                        } else {
                            System.out.println("Invalid option");
                        }
                    }
                }else{
                    System.out.println("Wrong credentials");
                    System.out.println();
                }
            } else if (choice==2) {
                System.out.println("1. Register");
                System.out.println("2. Login");

                int choice2 = scanner.nextInt();
                scanner.nextLine();

                if(choice2==1){
                    System.out.println("Enter Visitor Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Visitor Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Visitor Phone Number: ");
                    long phone = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Enter Visitor Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter Visitor Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter Visitor Password: ");
                    String password = scanner.nextLine();

                    if(visitor.checkUserByEmail(email)==1){
                        System.out.println("The user is already registered");
                    }
                    else{
//                        Visitor visitor1 = new Visitor(name,age,phone,balance,email,password);
                        Visitor visitor1 = visitor.clone();
                        visitor1.setName(name);
                        visitor1.setAge(age);
                        visitor1.setPhoneNumber(phone);
                        visitor1.setBalance(balance);
                        visitor1.setEmail(email);
                        visitor1.setPassword(password);
                        visitor1.setType("0");
                        visitor1.setMessage("No feedback given till now.");
                        visitor.addUser(visitor1);
                    }
                } else if (choice2==2) {
                    System.out.println("Enter Visitor Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter Visitor Password: ");
                    String password = scanner.nextLine();

                    if (visitor.checkUserByEmail(email)==-1){
                        System.out.println("No such visitor with email "+email+" exists");
                    } else if (visitor.checkPassword(email,password)==-1) {
                        System.out.println("Wrong password please check");
                    } else if (visitor.checkPassword(email,password)==1) {
                        int index = visitor.findVisitorIndexByEmail(email);
                        Visitor visitor1 = visitor.getVisitorList().get(index);

                        System.out.println("Welcome " + visitor1.getName());
                        while (true){
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9. Log Out");

                            int choice3 = scanner.nextInt();
                            scanner.nextLine();

                            if(choice3 ==1){
                                while (true) {
                                    System.out.println("1. View Attractions");
                                    System.out.println("2. View Animals");
                                    System.out.println("3. Exit");

                                    int choice4 = scanner.nextInt();
                                    scanner.nextLine();


                                    if(choice4 ==1){
                                        visitor.printAttractions(admin);
                                        System.out.println();
                                        System.out.println("-------------");
                                    } else if (choice4==2) {
                                        visitor.printAnimals(admin);
                                        System.out.println();
                                        System.out.println("-------------");
                                    } else if (choice4 == 3){
                                        break;
                                    }else{
                                        System.out.println("Invalid option");
                                    }
                                }
                            } else if (choice3==2) {
                                System.out.println("Buy Membership:");
                                System.out.println("1. Basic Membership (₹20)");
                                System.out.println("2. Premium Membership (₹50)");
                                System.out.println();

                                System.out.println("Enter your choice:");
                                int choice4 = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Apply Discount Name:");
                                String discountCode = scanner.nextLine();

                                double offPercentage = visitor.getDiscountPercentage(discountCode,discount);

//                                if(visitor.isDiscountCodeValid(discountCode,discount)){
                                visitor1.buyMembership(visitor1,choice4,offPercentage);
//
//                                }
//                                else{
//                                    System.out.println("No such Discount code exists");
//                                }

                                if(visitor1.getType().equalsIgnoreCase("premium")){
                                    visitor1.makeAllAttractionTicketsOne();
                                }
                            } else if (choice3==3) {
                                System.out.println("Select an Attraction to Buy a Ticket: ");
//                                visitor.printAttractions(admin);
                                visitor1.printOpenAttractions();

                                int attractionCode = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter the number of tickets to buy:");
                                int noOfTicks = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Apply Discount Name:");
                                String discountCode = scanner.nextLine();

                                double discountPercentage = visitor.getDiscountPercentage(discountCode,discount);

//                                System.out.println("The special deal to be applied is for number of ticket:");
//                                int numberOfTicks =scanner.nextInt();
//                                scanner.nextLine();

                                double discountDeals = visitor.getSpecialDealPercentage(noOfTicks,discount);

                                visitor1.buyTickets(visitor1,attractionCode,noOfTicks,discountPercentage,discountDeals);
                                System.out.println("Tickets bought and your remaining balance is " + visitor1.getBalance() +" ruppees");



                            } else if (choice3==4) {
                                String discountsString = discount.toString();
                                System.out.println(discountsString);
                            } else if (choice3==5) {
                                discount.viewAvailableSpecialDeals();
                            } else if (choice3==6) {
                                if(visitor1.getType().equalsIgnoreCase("premium") || visitor1.getType().equalsIgnoreCase("basic")) {
                                    System.out.println("Enter the name of the animal ");
                                    String name = scanner.nextLine();

                                    if (admin.checkAnimals(name) == 1) {
                                        Animal animal1 = admin.getAnimalByName(name);
                                        System.out.println("1.Feed");
                                        System.out.println("2.Read");

                                        int choice4 = scanner.nextInt();
                                        scanner.nextLine();

                                        if (choice4 == 1) {
                                            animal1.makeSound();
                                        } else if (choice4 == 2) {
                                            animal1.getAnimalHistory();
                                        } else {
                                            System.out.println("Invalid choice");
                                        }
                                    } else {
                                        System.out.println("No such animal exists in the zoo");
                                    }
                                }else{
                                    System.out.println("Please buy the membership first");
                                }


                            } else if (choice3==7) {
                                if(visitor1.getType().equalsIgnoreCase("premium") || visitor1.getType().equalsIgnoreCase("basic")) {
                                    System.out.println("Visit Attractions");
//                                System.out.println(visitor1.getType());
//                                System.out.println(visitor1.getTickets());

                                    System.out.println("Select an attraction to visit");
                                    visitor.printOpenAttractions();
                                    int attractionID = scanner.nextInt();
                                    scanner.nextLine();


                                    Attractions attraction1 = visitor1.getAttractionFromCode(attractionID);
                                    if (visitor1.getTickets().get(attraction1) > 0) {
                                        int new_ticks = visitor.getTickets().get(attraction1) - 1;
                                        int prevCount = attraction1.getVisitCount();
                                        attraction1.setVisitCount(prevCount + 1);
                                        visitor.getTickets().put(attraction1, new_ticks);
                                        System.out.println("Thank you for visiting " + attraction1.getName() + " Hope you enjoyed the attraction.");
                                    } else {
                                        System.out.println("Please buy the ticket first");
                                    }
                                }else{
                                    System.out.println("Please buy the membership first");
                                }


                            } else if (choice3==8) {
                                System.out.println("Leave Feedback:\n" +
                                        "Enter your feedback (max 200 characters):\n");

                                String message = scanner.nextLine();
                                visitor1.leaveFeedback(message);

                            }else{
                                break;
                            }
                        }
                    }
                }
            }
            else if (choice==3){
                System.out.println("Exiting");
                break;
            } else{
                System.out.println("Invalid option");
            }
        }
    }
}