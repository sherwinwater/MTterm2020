package midtermreviewcodeforpartc;

import java.util.Scanner;

/**
 * build one method for each rule and make it easily extensible. Method take the rule as variables
 * to make the minimal change once the rule changes(for example, special character from 8 to 10,
 * only change the 8 to 10) 
 * The passwordValidator class works as one independent class for
 * validating password.
 *
 * @author Sherwin
 */
public class PasswordValidator {

    private int specialCharCount = 1;
    private int passwordLength = 8;

    public PasswordValidator() {

    }

    public void setSpcialCharCount(int specialCharCount) {
        this.specialCharCount = specialCharCount;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public boolean validateSpecialChar(String password, int specialCharCount) {
        int count = 0;
        //iterate over each character to see if it is a special character
        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isLetterOrDigit(password.charAt(i)))) {
                //now we know there is at least one special character
                count++;
            }
        }
        if (count >= specialCharCount) {
            return true;
        }
        return false;
    }

    public boolean validatePasswordLength(String password, int passwordLength) {
        if (password.length() > passwordLength) {
            return true;
        }
        return false;
    }

    public String getPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Passwords must have at least 8 characters");
        System.out.println("Passwords must have at least one special character");
        System.out.println("Please enter your desired password:");
        return sc.nextLine();
    }

    public String validateAll() {
        boolean validPassword = false;
        String password = "";
        while (!validPassword) {
            password = getPassword();
            if (validateSpecialChar(password, specialCharCount)
                    && validatePasswordLength(password, passwordLength)) {
                validPassword = true;
            }
        }//loop only ends when password is valid so now we create the User

        return password;
    }

}
