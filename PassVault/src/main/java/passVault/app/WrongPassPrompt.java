package passVault.app;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WrongPassPrompt {
    private String[] WrongPassPrompt1 = {"Login unsuccessful. Please check your password and try again.",
            "Incorrect password. Please try again.",
            "Incorrect password. Please try again."};
    private String[] WrongPassPrompt2 = {"Try again, but with feeling this time.",
            "Password denied. Are you even trying?",
            "Denied! Do you also forget faces this fast?",
            "Wrong. Did you try saying 'Please' yet?",
            "Error 404: Password not found.",
            "Nice try. Next guess?",
            "Incorrect. Did you forget something?",
            "Password rejected. This is not a drill!",
            "Whoops! That's not it. Go again?",
            "Strike one! Try again.",
            "Keep guessing!",
            "Not even close. You can do better!",
            "Oops! That's the password for something else.",
            "Yikes! Another typo?",
            "Try again, or I call the guessing police!",
            "Missed it by that much!",
            "Access denied. Did you eat a clown for breakfast?",
            "Nope. Want a hint?",
            "That password was so last season.",
            "No dice. Roll again?",
            "Wrong! Are your fingers dancing on the keyboard?",
            "Not that one. Your other favorite password?",
            "Are you really in charge of your memory?",
            "Wrong again, did you try putting it in rice?",
            "Password not recognized. Try again or try telepathy!",
            "Nuh uh", "You really want to get in don't you?",
            "Most people would have gotten it after 3 tries...",
            "Try again, with the power of friendship.",
            "WRONG!",
            "We can see why you need this app...",
            "Maybe the correct password is in your pocket",
            "Ok now the machine is judging you."};



    private String password = "123456";
    private int attemptCount = 0;


    public void checkPassword() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter password: ");
            String input = scanner.nextLine();
            attemptCount++;
            if (input.equals(password)) {
                System.out.println("Access granted.");
                break;
            } else {
                displayWrongPasswordMessage();
            }
        }
        scanner.close();
    }

    private void displayWrongPasswordMessage() {
        Random random = new Random();
        if (attemptCount <= 3) {
            int index = random.nextInt(WrongPassPrompt1.length);
            System.out.println(WrongPassPrompt1[index]);
        } else {
            int index = random.nextInt(WrongPassPrompt2.length);
            System.out.println(WrongPassPrompt2[index]);
        }
    }

    public static void main(String[] args) {
        WrongPassPrompt wrongPassPrompt = new WrongPassPrompt();
        wrongPassPrompt.checkPassword();
    }
}

