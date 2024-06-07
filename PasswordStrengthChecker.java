package PasswordGen;
public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int rating = 0;

        if (password.length() >= 8) rating++;
        if (password.length() >= 16) rating++;
        if (password.matches(".[A-Z].")) rating++;
        if (password.matches(".[a-z].")) rating++;
        if (password.matches(".\\d.")) rating++;
        if (password.matches(".[!@#$%^&()_\\-+=<>?/{}~|].*")) rating++;

        switch (rating) {
            case 0:
            case 1:
            case 2:
                return "Weak password";
            case 3:
            case 4:
                return "Medium password";
            case 5:
                return "Better password";
            case 6:
                return "Strong password";
            default:
                return "Password strength is Unknown";
        }
    }
}
