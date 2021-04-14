import java.util.*;

public class edditor {
    private I_O i_o;
    private List<person> fileArray;
    private Scanner reader;
    private InputValidator inputValidator;


	public edditor(String filePath){
        i_o = new I_O(filePath);
        fileArray = new ArrayList<person>();
        reader = new Scanner(System.in);
        inputValidator = new InputValidator();
    }

    public void loadFileToArray(){
        fileArray = i_o.load();
        Collections.sort(fileArray);
    }

    public void saveArrayToFile(){
        i_o.save(fileArray);
        Collections.sort(fileArray);
    }
    
    public void addCandidate(){
        System.out.println("Enter candidate's Name:");
        String name = reader.nextLine();
        System.out.println("Enter candidate's last name:");
        String lname = reader.nextLine();
        System.out.println("Enter candidate's age:");
        int age = reader.nextInt();
        if(this.CandidateAlreadyExists(name, lname, age)!=true) {
        	System.out.println("Candidate exists");
        }
        else {
        	fileArray.add(new person(name, lname, age));
        	System.out.println("Candidate added successfully");
        }
    }

    public void removeCandidate(){
        System.out.println("Enter name, last name and age of person you want to remove: ");
        String name = reader.nextLine();
        String lname = reader.nextLine();
        int age = inputValidator.readInt();
        for(person person : fileArray){
            if(person.getAge() == age && person.getName() == name && person.getLastName() == lname){
                fileArray.remove(person);
                System.out.println("Candidate: "+ person.getName() +  " " + person.getLastName() + ": Deleted successfully");
                return;
            }
        }
        System.out.println("Could not find person: " + name + " " + lname + " " + age);
    }

    public void printAllCandidates(){
        for(person person : fileArray){
            System.out.println(person);
        }
    }

    public boolean CandidateAlreadyExists(String name, String lname ,int age){
        for(person person: fileArray){
            if(person.getAge() == age && person.getName() == name && person.getLastName() == lname){
                return true;
            }
        }
        return false;
    }

    public int readAge(){
    	int age = reader.nextInt();
        while( age < 0){
            if(age < 0){
                System.out.println("The age cannot be negative. Please enter a positive ID: ");
            }
            age = inputValidator.readInt();
        }
        return age;
    }
}