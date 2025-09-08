
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DailyGoalReminder {

    private static ArrayList<String> goals = new ArrayList<>();
    private static ArrayList<Boolean> status = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("==================================");
        System.out.println(" Welcome to Daily Goal Reminder ");
        System.out.println(" Date & Time: " + dtf.format(now));
        System.out.println("==================================");

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new goal");
            System.out.println("2. View today’s goals");
            System.out.println("3. Mark goal as completed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addGoal(sc);
                    break;
                case 2:
                    showGoals();
                    break;
                case 3:
                    markGoalCompleted(sc);
                    break;
                case 4:
                    System.out.println("Goodbye! Stay motivated!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void addGoal(Scanner sc) {
        System.out.print("Enter your goal: ");
        String goal = sc.nextLine();
        goals.add(goal);
        status.add(false);
        System.out.println("Goal added successfully!");
    }

    private static void showGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals set yet.");
            return;
        }
        System.out.println("\nToday's Goals:");
        for (int i = 0; i < goals.size(); i++) {
            String mark = status.get(i) ? "✓ (Completed)" : "✗ (Pending)";
            System.out.println((i + 1) + ". " + goals.get(i) + " - " + mark);
        }
    }

    private static void markGoalCompleted(Scanner sc) {
        if (goals.isEmpty()) {
            System.out.println("No goals available to mark.");
            return;
        }
        showGoals();
        System.out.print("Enter goal number to mark as completed: ");
        int num = sc.nextInt();
        if (num > 0 && num <= goals.size()) {
            status.set(num - 1, true);
            System.out.println("Goal marked as completed!");
        } else {
            System.out.println("Invalid goal number.");
        }
    }
}
