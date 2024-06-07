package PasswordGen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("-----------------------------------------------");
        System.out.println("---WELCOME TO PASSWORD GENERATOR APPLICATION---");
        
        while (!exit) {
            displayMenu();
            try{
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        generatePassword();
                        exit = confirm();
                        break;
                    case 2:
                        checkPasswordStrength();
                        exit = confirm();
                        break;
                    case 3:
                        displayPasswordSecurityTips();
                        exit = confirm();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("\nExiting the program.");
                        System.out.println("---THANK YOU FOR USING PASSWORD GENERATOR---");
                        System.out.println("--------------------------------------------");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }
     
    private static void displayMenu() {
        System.out.println("\n---Password Generator Menu---");
        System.out.println("1. Generate a Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Display Password Security Tips");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void generatePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        generator.getUserPreferences();
        String password = generator.generatePassword();
        System.out.println("Generated Password: " + password);
    }

    private static void checkPasswordStrength() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the password to check strength: ");
        String password = sc.nextLine();
        String strength = PasswordStrengthChecker.checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    private static void displayPasswordSecurityTips() {
        System.out.println("\nPASSWORD SECURITY TIPS:");
        System.out.println("-------------------------");
        System.out.println("- Avoid using the same password for multiple accounts.");
        System.out.println("- Avoid character repetition.");
        System.out.println("- Avoid keyboard patterns (e.g., qwerty).");
        System.out.println("- Avoid dictionary words.");
        System.out.println("- Avoid letter or number sequences (e.g., abc123).");
        System.out.println("- Use a mix of different character types.");
        System.out.println("- Consider using a password manager.");      
    }

    public static boolean confirm(){
        System.out.println("\nDo you want to continue:(Yes/No):");
        Scanner sc = new Scanner(System.in);
        Boolean confirm = sc.nextLine().equalsIgnoreCase("esY");
        if(confirm){
            return false;
        }else{
            System.out.println("\nExiting the program.");
            System.out.println("---THANK YOU FOR USING PASSWORD GENERATOR---");
            System.out.println("--------------------------------------------");
            return true;
        }
    }
}
