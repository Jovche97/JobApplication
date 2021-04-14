import java.util.Collections;
import java.util.Scanner;

public class UI {
    private Scanner reader;
    private InputValidator inputValidator;
    private edditor edit;
    private person p;

    public UI(){
        reader = new Scanner(System.in);
        inputValidator = new InputValidator();
        edit = new edditor("kandidati.txt");
    }

    public void run(){
        printOptions();
        while(processInput());
        edit.loadFileToArray();
        edit.saveArrayToFile();
    }

    public void printOptions(){
        System.out.println("Options:");
        System.out.println("0. Quit");
        System.out.println("1. Add a new candidate");
        System.out.println("2. Print all candidates");
        System.out.println("3. Delete a candidate");
    }

    public boolean processInput() {
        int input = inputValidator.readInt();
        while(input != 0){
            if(input == 1){
                edit.addCandidate();
                edit.saveArrayToFile();
                this.printOptions();
            }
            else if(input == 2){
            	edit.loadFileToArray();
                edit.printAllCandidates();
                this.printOptions();
            }
            else if(input == 3){
                edit.removeCandidate();
                this.printOptions();
            }
            else{

            }
            input = inputValidator.readInt();
        }
        return false;
    }
}