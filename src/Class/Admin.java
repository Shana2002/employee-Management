package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Admin extends Users{
    
    private String Name;
    private String Email;
    private String userName;
    private String passWord;
    private String destination;
    private String filePath = "userData.txt";
    public String[] headers = {"User Name","Pasword","Name","Designation"};
    
    public Admin() {
        super();
    }
    
    public boolean creteUserAccounts(String user ,String Pa,String name , String des){
        boolean already = false;
        for (int i=0;i<rowCount();i++){
            if (user.equals(super.users()[i][0])){
                already = true;
                i=rowCount()+1;
            }
        }
        if (!already){
        String addUser[] = {user , Pa , name , des};
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) 
        {   
            
            for(int i = 0;i<4;i++){
                writer.write(addUser[i]);
                writer.write(";");
            }
            writer.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }
        }
        else{
            return false;
        }
    }
    public void showUsers(){
        String[][] editUser = new String[rowCount()][4];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int rowReader = 0;
            String[] cells = null;
            while ((line = reader.readLine())!= null){
                cells = line.split(";");
                editUser[rowReader][0]=cells[0];
                editUser[rowReader][1]=cells[1];
                editUser[rowReader][2]=cells[2];
                editUser[rowReader][3]=cells[3];
                rowReader++;
            }
            editUser[0][1]="Password";
        } catch (Exception e) {
        }
      
    for (String[] rowData : editUser) {
        
        for (String cell : rowData) {
            System.out.print(cell + "\t"); // Print each cell (tab-separated)
        }
        System.out.println(); // Move to the next line
    }
    }
    
    public void userEdit(int selectRow,String upUser ,String upPa,String upUt , String upName){
        
 
  
        String[][] editUser = new String[rowCount()][4];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int rowReader = 0;
            String[] cells = null;
            while ((line = reader.readLine())!= null){
                cells = line.split(";");
                editUser[rowReader][0]=cells[0];
                editUser[rowReader][1]=cells[1];
                editUser[rowReader][2]=cells[2];
                editUser[rowReader][3]=cells[3];
                
                rowReader++;
            }
            
        } catch (Exception e) {
        }
        editUser[selectRow][0]=upUser;
        editUser[selectRow][1]=upPa;
        editUser[selectRow][2]=upUt;
        editUser[selectRow][3]=upName;
        
        String filePath1 = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Loop through the 2D array
            for (String[] rows : editUser) {
                // Join each element in the row with a delimiter (comma, tab, etc.)
                String rowsString = String.join(";", rows); // You can use any delimiter you want
                
                // Write the row to the file
                writer.write(rowsString);
                writer.newLine(); // Move to the next line
            }
            
            System.out.println("Array successfully written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public void userDelete(int deleteRowNumber){
        String[][] temporyArray = deleteRow(users(),deleteRowNumber);
        
        String filePath1 = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Loop through the 2D array
            for (String[] rows : temporyArray) {
                // Join each element in the row with a delimiter (comma, tab, etc.)
                String rowsString = String.join(";", rows); // You can use any delimiter you want
                
                // Write the row to the file
                writer.write(rowsString);
                writer.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        
    }

    public static String[][] deleteRow(String[][] array, int rowIndex) {
        if (rowIndex >= 0 && rowIndex < array.length) {
            String[][] newArray = new String[array.length - 1][array[0].length];
            System.arraycopy(array, 0, newArray, 0, rowIndex);
            System.arraycopy(array, rowIndex + 1, newArray, rowIndex, array.length - rowIndex - 1);
            return newArray;
        } else {
            return array;
        }
    }
    
}
