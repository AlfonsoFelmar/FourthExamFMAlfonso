package fourthexamfmalfonso;

import java.util.Scanner;
import java.util.Set;

public class FourthExamFMAlfonso {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scn = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("Welcome to the Social Network System!");
        System.out.println("Choose an option from the menu:");
        System.out.println("1. Add a New User");
        System.out.println("2. Establish a Friendship");
        System.out.println("3. Display Users and Their Friends");
        System.out.println("4. Get Friend Recommendations");
        System.out.println("5. Exit the Program");
        System.out.println("=========================================");

        while (true) {
            System.out.print("\nEnter your choice (1-5): ");
            int choice = scn.nextInt();
            scn.nextLine(); 

            System.out.println("-----------------------------------------");

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the user you want to add: ");
                    String user = scn.nextLine();
                    graph.addUser(user);
                    System.out.println("User \"" + user + "\" has been successfully added.");
                    break;

                case 2:
                    System.out.print("Enter the name of the first user: ");
                    String user1 = scn.nextLine();
                    System.out.print("Enter the name of the second user: ");
                    String user2 = scn.nextLine();
                    graph.addFriend(user1, user2);
                    System.out.println("A friendship has been established between \"" + user1 + "\" and \"" + user2 + "\".");
                    break;

                case 3:
                    System.out.println("\nList of all users and their friends:");
                    graph.displayFriends();
                    break;

                case 4:
                    System.out.print("Enter the name of the user to view friend recommendations: ");
                    String targetUser = scn.nextLine();
                    Set<String> recommendedFriends = graph.getRecommendedFriends(targetUser);
                    if (recommendedFriends.isEmpty()) {
                        System.out.println("There are no friend recommendations for \"" + targetUser + "\" at the moment.");
                    } else {
                        System.out.println("Friend recommendations for \"" + targetUser + "\": " + recommendedFriends);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Social Network System. Goodbye!");
                    scn.close();
                    System.out.println("=========================================");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
            System.out.println("-----------------------------------------");
        }
    }
    
}
