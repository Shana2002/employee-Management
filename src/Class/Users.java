
package Class;

import java.io.BufferedReader;
import java.io.FileReader;

public class Users {
    private String userName;
    private String password;
    private String userType = "Admin";
    private String filePath="userData.txt";
    
    // Constructor
    public Users(){}
    public Users(String un , String pw){
        setUserName(un);
        setPassword(pw);
    }
    
    //Setters
    public void setUserName(String un){
        userName = un;
    }
    
    public void setPassword(String pw){
        password = pw;
    }
    //Getters
    public String getUserType(){
        return userType;
    }
    public int rowCount(){
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
    public String[][] users(){
        //text file data add to 2d array
        
        String[][] data = new String[rowCount()][4];
        try (BufferedReader reader = new BufferedReader(new FileReader("userData.txt"))){
            String line;
            int row = 0;
            String[] cells = null;
            while ((line = reader.readLine())!= null){
                cells = line.split(";");
                data[row][0]=cells[0];
                data[row][1]=cells[1];
                data[row][2]=cells[2];
                data[row][3]=cells[3];
                row++;
            }
            
            return data;
        } catch (Exception e) {
        }
        return data;
    }
    // Validate User Name and Password
    public boolean verifyLogin(){
        int rowNumber ;
        int i = 0;
        boolean verify = false;
        
        //loop array and veryfy user name and password
        while(i<rowCount()){
            
            if(users()[i][0].equals(userName)&& users()[i][1].equals(password)){
                verify = true;
                //assign user type
                userType = users()[i][3];
                i=rowCount()+1;
            }
            i++;
        }
        if (verify){
            return true;
        }else{
            return false;
        }
        
    }
    
}
