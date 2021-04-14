import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class I_O {
    private String filePath;
    private File filePointer;
    private Scanner reader;

    public I_O(String filePath){
        this.filePath = filePath;
    }


    public List<person> load(){
        List<person> contents = new ArrayList<person>();try{
            filePointer = new File(filePath);
            reader = new Scanner(filePointer);
        }
        catch(Exception e){
            return null;
        }
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(":");
            contents.add(new person(parts[0], parts[1], Integer.parseInt(parts[2])));
        }
        reader.close();
        return contents;
    }

    public boolean save(List<person> content){
    	
        FileWriter writer;
        try{
            writer = new FileWriter(filePath);
        }
        catch(Exception e){
            return false;
        }
        for(person person : content){
            try{
                writer.write(person.getName() + ":" + person.getLastName() + ":" + person.getAge() +  "\n");
            }
            catch (Exception e){
                return false;
            }
        }
        try{
            writer.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}