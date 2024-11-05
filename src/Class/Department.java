/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author User
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private String filePath = "department.txt";
    
    
    
    public int rowDept(){
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
    public boolean createDepartment(String deptName){
        boolean already = false;
        for (int i=0;i<rowDept();i++){
            if (deptName.equals(viewDepartment()[i])){
                already=true;
                i=rowDept()+1;
            }
        }
        if (!already){
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write(deptName);
            writer.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }}else{
            return false;
        }
        
    }
    public String[] viewDepartment(){
        String[] deparments=new String[rowDept()];
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine())!= null){
                deparments[i] = line;
                i++;
                
            }
            return deparments;
        } catch (Exception e) {
            return deparments;
        }
  
    }
    
    
    
    
}
