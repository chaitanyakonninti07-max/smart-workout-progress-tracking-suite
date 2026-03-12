import java.util.*;

public class WorkoutDSA {

    static Scanner sc = new Scanner(System.in);

    static String username = "";
    static String password = "";

    static Stack<String> workoutStack = new Stack<>();
    static Queue<String> plannedWorkouts = new LinkedList<>();
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SMART WORKOUT PROGRESS TRACKING SUITE =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void register() {

        System.out.println("\n--- Register ---");

        System.out.print("Enter Username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        password = sc.nextLine();

        System.out.println("Registration Successful!");
    }

    static void login() {

        System.out.println("\n--- Login ---");

        System.out.print("Enter Username: ");
        String u = sc.nextLine();

        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!");
            mainMenu();
        } else {
            System.out.println("Invalid Credentials.");
        }
    }

    static void mainMenu() {

        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Record Workout");
            System.out.println("2. View Workout History");
            System.out.println("3. Undo Last Workout (Stack)");
            System.out.println("4. Plan Workout (Queue)");
            System.out.println("5. Start Planned Workout");
            System.out.println("6. Search Workout");
            System.out.println("7. Workout Tips");
            System.out.println("8. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    recordWorkout();
                    break;

                case 2:
                    viewHistory();
                    break;

                case 3:
                    undoWorkout();
                    break;

                case 4:
                    planWorkout();
                    break;

                case 5:
                    startPlannedWorkout();
                    break;

                case 6:
                    searchWorkout();
                    break;

                case 7:
                    workoutTips();
                    break;

                case 8:
                    System.out.println("Logged out.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void recordWorkout() {

        System.out.println("\nSelect Workout");
        System.out.println("1. Pushups");
        System.out.println("2. Squats");
        System.out.println("3. Running");
        System.out.println("4. Plank");
        System.out.println("5. Pull-ups");
        System.out.println("6. Sit-ups");
        System.out.println("7. Lunges");
        System.out.println("8. Burpees");
        System.out.println("9. Jump Rope");
        System.out.println("10. Cycling");
        System.out.println("11. Deadlifts");
        System.out.println("12. Bench Press");
        System.out.println("13. Shoulder Press");
        System.out.println("14. Mountain Climbers");
        System.out.println("15. High Knees");

        int choice = sc.nextInt();
        sc.nextLine();

        String workout = "";

        switch (choice) {

            case 1: workout = "Pushups"; break;
            case 2: workout = "Squats"; break;
            case 3: workout = "Running"; break;
            case 4: workout = "Plank"; break;
            case 5: workout = "Pull-ups"; break;
            case 6: workout = "Sit-ups"; break;
            case 7: workout = "Lunges"; break;
            case 8: workout = "Burpees"; break;
            case 9: workout = "Jump Rope"; break;
            case 10: workout = "Cycling"; break;
            case 11: workout = "Deadlifts"; break;
            case 12: workout = "Bench Press"; break;
            case 13: workout = "Shoulder Press"; break;
            case 14: workout = "Mountain Climbers"; break;
            case 15: workout = "High Knees"; break;

            default:
                System.out.println("Invalid workout.");
                return;
        }

        workoutStack.push(workout);
        history.add(workout);

        System.out.println(workout + " recorded successfully.");
    }

    static void viewHistory() {

        System.out.println("\n--- Workout History ---");

        if (history.isEmpty()) {
            System.out.println("No workouts recorded.");
        } else {

            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }

    static void undoWorkout() {

        if (workoutStack.isEmpty()) {
            System.out.println("No workout to undo.");
        } else {

            String removed = workoutStack.pop();
            history.remove(removed);

            System.out.println("Last workout removed: " + removed);
        }
    }

    static void planWorkout() {

        System.out.print("Enter workout to plan: ");
        String workout = sc.nextLine();

        plannedWorkouts.add(workout);

        System.out.println("Workout added to plan.");
    }

    static void startPlannedWorkout() {

        if (plannedWorkouts.isEmpty()) {
            System.out.println("No planned workouts.");
        } else {

            String workout = plannedWorkouts.poll();

            workoutStack.push(workout);
            history.add(workout);

            System.out.println("Started planned workout: " + workout);
        }
    }

    static void searchWorkout() {

        System.out.print("Enter workout name to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (String w : history) {

            if (w.equalsIgnoreCase(search)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Workout found in history.");
        } else {
            System.out.println("Workout not found.");
        }
    }

    static void workoutTips() {

        System.out.println("\n--- Workout Tips ---");
        System.out.println("1. Warm up before workout.");
        System.out.println("2. Stay hydrated.");
        System.out.println("3. Maintain proper posture.");
        System.out.println("4. Take rest between sets.");
        System.out.println("5. Eat balanced food.");
        System.out.println("6. Sleep at least 7-8 hours.");
        System.out.println("7. Be consistent with training.");
    }
}