import java.util.ArrayList;
import java.util.Scanner;

class Complaint {
    int id;
    String name, category, description, status;

    Complaint(int id, String name, String category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.status = "Pending";
    }

    void display() {
        System.out.println("\nComplaint ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}

public class ComplaintSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Complaint> list = new ArrayList<Complaint>();

        int id = 1;
        int choice;

        do {
            System.out.println("\n--- Complaint Registration and Tracking System ---");
            System.out.println("1. Register Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Track Complaint");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter complaint description: ");
                    String description = sc.nextLine();

                    Complaint c = new Complaint(id, name, category, description);
                    list.add(c);

                    System.out.println("Complaint registered successfully!");
                    System.out.println("Your Complaint ID is: " + id);

                    id++;
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No complaints found.");
                    } else {
                        for (Complaint complaint : list) {
                            complaint.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Complaint ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Complaint complaint : list) {
                        if (complaint.id == searchId) {
                            complaint.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Complaint not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Complaint ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Complaint complaint : list) {
                        if (complaint.id == updateId) {
                            System.out.print("Enter new status: ");
                            complaint.status = sc.nextLine();

                            System.out.println("Complaint status updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Complaint not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}