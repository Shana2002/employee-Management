
package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Designation {
    private int departmentId;
    private String departmentName;
    private String filePath = "designation.txt";
    
    public int rowDest(){
        //count users data text file rows
        int rows=0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine())!= null){
                rows++;
            }
        } catch (Exception e) {
        }
        
        return rows;
        
    }
    public boolean createDesignation(String destName){
        boolean already = false;
        for (int i=0;i<rowDest();i++){
            if (destName.equals(viewDesignation()[i])){
                already=true;
                i=rowDest()+1;
            }
        }
        if (!already){
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write(destName);
            writer.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }}else{
            return false;
        }
    }
    public String[] viewDesignation(){
        String[] designationsArray=new String[rowDest()];
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine())!= null){
                designationsArray[i] = line;
                i++;
                
            }
            return designationsArray;
        } catch (Exception e) {
            return designationsArray;
        }
    }
    
    
}
