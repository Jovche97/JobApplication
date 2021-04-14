import java.util.Scanner;

public class InputValidator {
    private Scanner reader;

    public InputValidator(){
        reader = new Scanner(System.in);
    }

    public int readInt(){
        int input = 0;
        boolean gotCorrect = false;
        while(!gotCorrect) {
            try {
                input = Integer.parseInt(reader.nextLine());
                gotCorrect = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
        return input;
    }
}