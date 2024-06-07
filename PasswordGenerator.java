package PasswordGen;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private boolean useUppercase;
    private boolean useLowercase;
    private boolean useDigits;
    private boolean useSpec_char;
    private int passwordLength;
    private String password = "";

    public void getUserPreferences() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Use uppercase letters? (Yes/No): ");
        useUppercase = sc.nextLine().equalsIgnoreCase("Yes");

        System.out.println("Use lowercase letters? (Yes/No): ");
        useLowercase = sc.nextLine().equalsIgnoreCase("Yes");

        System.out.println("Use numbers? (Yes/No): ");
        useDigits = sc.nextLine().equalsIgnoreCase("Yes");

        System.out.println("Use symbols? (Yes/No): ");
        useSpec_char = sc.nextLine().equalsIgnoreCase("Yes");

        System.out.println("Enter desired length of the password: ");
        passwordLength = sc.nextInt();
        
        buildPassword();
        
    }

    private void buildPassword() {
        if (useUppercase) {
            password += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (useLowercase){
            password += "abcdefghijklmnopqrstuvwxyz";
        } 
        if (useDigits){ 
            password += "0123456789";
        }
        if (useSpec_char){
            password += "!@#$%^&*()_-+=<>?/{}~|";
        }
        if (password.isEmpty()) {
            System.out.println("No character types selected, including all types by default.");
            password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-+=<>?/{}~|";
        }
    }

    public String generatePassword() {
        Random random = new Random();
        StringBuilder passwordobj = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(password.length());
            passwordobj.append(password.charAt(index));
        }

        return passwordobj.toString();
    }
}
