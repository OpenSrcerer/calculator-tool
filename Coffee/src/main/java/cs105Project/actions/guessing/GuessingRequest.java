package cs105Project.actions.guessing;

import cs105Project.actions.Request;
import java.util.Random;

public class GuessingRequest implements Request {
    @Override
    public void run() {
        int randomValue = new Random().nextInt(66);
        // get some shit user input
        int userInput = 0;

        while (true) {
            if (userInput == randomValue) {
                System.out.println("Yes");
            } else if (userInput > randomValue) {
                System.out.println("Lower");
            } else {
                System.out.println("Higher");
            }
        }
    }
}
