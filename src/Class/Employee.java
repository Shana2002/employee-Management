package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class Employee {
    private String empId;
    private String empName;
    private String epfNum;
    private String empNIC;
    private String joinDate;
    private String empDept;
    private String empDest;
    private String empSalary;
    private String filePath="employeeData.txt";
    
    
    
    public void setEmpDetails(String id,String name,String epf,String nic,String join , String dept, String dest , String Salary){
        this.empId=id;
        this.empName=name;
        this.epfNum=epf;
        this.empNIC=nic;
        this.joinDate=join;
        this.empDept=dept;
        this.empDest=dest;
        this.empSalary=Salary;
    }
    
    public void createEmployee(){
        String addUser[] = {empId,empName,epfNum,empNIC,joinDate,empDept,empDest,empSalary};
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) 
        {   
            
            for(int i = 0;i<8;i++){
                writer.write(addUser[i]);
                writer.write(";");
            }
            writer.newLine();
        } catch (Exception e) {
        }
    }
    public int rowsEmp(){
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
    public String[][] showEmployee(){
        String[][] data = new String[rowsEmp()][8];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int row = 0;
            String[] cells = null;
            while ((line = reader.readLine())!= null){
                cells = line.split(";");
                data[row][0]=cells[0];
                data[row][1]=cells[1];
                data[row][2]=cells[2];
                data[row][3]=cells[3];
                data[row][4]=cells[4];
                data[row][5]=cells[5];
                data[row][6]=cells[6];
                data[row][7]=cells[7];
                row++;
            }
            
            return data;
        } catch (Exception e) {
        }
        return data;
    }
    public String[][] searchEmp(int searchBy , String searchtxt){
        int count = 0;
        for (String[] row: showEmployee()){
            if (row[searchBy].toLowerCase().contains(searchtxt.toLowerCase())){
                count++;
            }
        }
        String[][] resaultsArray = new String[count][showEmployee()[0].length];
        int resultsCount=0;
        
        for (String[] row : showEmployee()){
            
            if (row[searchBy].toLowerCase().contains(searchtxt.toLowerCase())){
                resaultsArray[resultsCount]=row;
                resultsCount++;
            }   
        }
        if (count>0){
            return resaultsArray;
        }else{
            return null;
        }
            
    }   
        
           
}
