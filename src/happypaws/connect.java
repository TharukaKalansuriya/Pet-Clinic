/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package happypaws;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author tharu
 */
public class connect {
    Connection conn;
 
    public void dbsconnection(){
        try{
     //create connection object

        //load the driver class
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //get connection to the data base
        conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HappyPaws;username=tharuka;password=1234");
    
        }
        catch(ClassNotFoundException|SQLException e){
            System.out.println("Connection Failed!!!");
        }
    }
    
    //ANIMAL DATA FORM
    
     //companion Animal
    public void insertData(int Animalid,int Age,float Weight,String Sex,String Breed,String Species, String Name){
   
      try{
      Statement stmt=conn.createStatement();
      
      String query1="INSERT INTO CompAnimal Values ("+Animalid+","+Age+","+Weight+",'"+Sex+"','"+Breed+"','"+Species+"','"+Name+"')";
       stmt.execute(query1);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
          System.err.println("SQLException "+e.getLocalizedMessage());
         System.out.println("Input failed!!");
     }
  }
    
    
      
public void deleteData(int Animalid){
   
      try{
      Statement stmt=conn.createStatement();
      
      String query1="DELETE  From CompAnimal WHERE Animalid="+Animalid;
       stmt.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void searchData(int Animalid){
        try{
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CompAnimal WHERE Animalid="+Animalid;
            ResultSet rs=stmt.executeQuery(query);
           
            
            if (rs.next()){
                System.out.println("Id  found!!");
                JOptionPane.showMessageDialog(null,"ID FOUND!!");
                    
                    do {
                        String message = "Animal ID=" + rs.getInt("Animalid") + "\n"
                        + "Name=" + rs.getString("Name") + "\n "
                        + "Breed=" + rs.getString("Breed") + "\n"
                        + "WEIGHT=" + rs.getInt("Weight");



                        System.out.println("Animal ID :"+rs.getInt("Animalid"));
                        System.out.println("NAME      :"+rs.getString("Name"));
                        System.out.println("AGE       :"+rs.getString("Age"));
                        System.out.println("Sex       :"+rs.getString("Sex"));
                        System.out.println("Breed     :"+rs.getString("Breed"));
                         JOptionPane.showMessageDialog(null, message);

                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                  JOptionPane.showMessageDialog(null, "ID not found!!");

                    }
            
        }
    
                catch(SQLException e){
                        System.out.println("serch failed!!");
                        JOptionPane.showMessageDialog(null, "Search failed!!");
                        }
 }
 
    
    //livestock animal
   public void livestockData(int AnimalId,int Age,float Weight,String Sex,String Tags,String Species){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query2="INSERT INTO LivestockAnimal Values ("+AnimalId+",'"+Tags+"',"+Weight+",'"+Species+"','"+Sex+"',"+Age+")";
       liveist.execute(query2);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Livestock Animal Input failed!!");
     }
  }
    
    
      
public void livestockdeleteData(int Animalid){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query1="DELETE  From LivestockAnimal WHERE Animalid="+Animalid;
       liveist.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void livestocksearchData(int Animalid){
        try{
            Statement live = conn.createStatement();
            String query="SELECT * FROM LivestockAnimal WHERE Animalid="+Animalid;
            ResultSet rs=live.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Animal ID :"+rs.getInt("Animalid"));
                        System.out.println("AGE       :"+rs.getString("Age"));
                        System.out.println("Sex       :"+rs.getString("Sex"));
                        System.out.println("Tags      :"+rs.getString("Tags"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                   System.err.println("SQLException "+e.getLocalizedMessage());
                        System.out.println("serch failed!!");
                        }
 }
 

 
 
  //APPOINMENT FORM
 public void appoinmentinsertData(int Appoinmentid,int Ownerid,String date,String SurgeryName,String Time){
   
      try{
      Statement stmt=conn.createStatement();
      
      String query="INSERT INTO Appoinment1 Values ("+Appoinmentid+","+Ownerid+",'"+date+"','"+SurgeryName+"','"+Time+"')";
       stmt.execute(query);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Appoinment Table Input failed!!");
     }
  }
    
    
      
public void appoinmentdeleteData(int Appoinmentid){
   
      try{
      Statement stmt=conn.createStatement();
      
      String query1="DELETE  From Appoinment1 WHERE Appoinmentid="+Appoinmentid;
       stmt.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void appoinmentsearchData(int Appoinmentid){
        try{
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Appoinment1 WHERE Appoinmentid="+Appoinmentid;
            ResultSet rs=stmt.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Appoinment ID:"+rs.getInt("Appoinmentid"));
                        System.out.println("DATE         :"+rs.getString("Date"));
                        System.out.println("Surgery Name :"+rs.getString("SurgeryName"));
                        System.out.println("Time         :"+rs.getString("Time"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                        System.out.println("serch failed!!");
                        }
 }
 
 //owner data form
 
 public void owData(int OwnerId,int Animalid,String ContactNumber,String Address,String Name){
   
      try{
      Statement owist=conn.createStatement();
      
      String query1="INSERT INTO Owner Values ("+OwnerId+",'"+Name+"','"+ContactNumber+"','"+Address+"',"+Animalid+")";
       owist.execute(query1);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Input failed!!");
     }
  }
    
    
      
public void owdeleteData(int Ownerid){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query1="DELETE  From Owner WHERE Ownerid="+Ownerid;
       liveist.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void owsearchData(int Ownerid){
        try{
            Statement live = conn.createStatement();
            String query="SELECT * FROM Owner WHERE Ownerid="+Ownerid;
            ResultSet rs=live.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Owner ID :"+rs.getInt("Ownerid"));
                        System.out.println("Cont No       :"+rs.getString("ContactNumber"));
                        System.out.println("Name       :"+rs.getString("Name"));
                        System.out.println("Address      :"+rs.getString("Address"));
                        System.out.println("Animal Id      :"+rs.getString("Animalid"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                   System.err.println("SQLException "+e.getLocalizedMessage());
                        System.out.println("serch failed!!");
                        }
 }
//medical data form
 
 public void medData(int Recordid,int Animalid,int treatmentid,String Date,String Symptoms,String Diagnosis){
   
      try{
      Statement owist=conn.createStatement();
      
      String query1="INSERT INTO MedicalRecord Values ("+Recordid+","+Animalid+",'"+Symptoms+"','"+Diagnosis+"',"+treatmentid+",'"+Date+"')";
       owist.execute(query1);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Input failed!!");
     }
  }
    
    
      
public void meddeleteData(int RecordID){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query1="DELETE  From MedicalRecord WHERE Recordid="+RecordID;
       liveist.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void medsearchData(int RecordID){
        try{
            Statement live = conn.createStatement();
            String query="SELECT * FROM MedicalRecord WHERE Recordid="+RecordID;
            ResultSet rs=live.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Record ID     :"+rs.getInt("RecordID"));
                        System.out.println("Animalid      :"+rs.getString("Animalid"));
                        System.out.println("Date          :"+rs.getString("Date"));
                        System.out.println("Symptoms      :"+rs.getString("Symptoms"));
                        System.out.println("Diagnosis     :"+rs.getString("Diagnosis"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                   System.err.println("SQLException "+e.getLocalizedMessage());
                        System.out.println("serch failed!!");
                        }
 }
//staff data form
 
 public void staffData(int Staffid,String Position,String Qualification,String Name,String Address,
         String JoinningDate,String DOB,String ContactNo){
   
      try{
      Statement owist=conn.createStatement();
      
      String query1="INSERT INTO Staff1 Values ("+Staffid+",'"+Position+"','"+Qualification+"','"+Name+"','"+Address+"',"
              + "'"+JoinningDate+"','"+DOB+"','"+ContactNo+"')";
       owist.execute(query1);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Input failed!!");
     }
  }
    
    
      
public void staffdeleteData(int Staffid){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query1="DELETE  From Staff1 WHERE Staffid="+Staffid;
       liveist.execute(query1);

      System.out.println("Delete successful");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void staffsearchData(int Staffid){
        try{
            Statement live = conn.createStatement();
            String query="SELECT * FROM Staff1 WHERE Staffid="+Staffid;
            ResultSet rs=live.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Staff ID     :"+rs.getInt("Staffid"));
                        System.out.println("Position     :"+rs.getString("Position"));
                        System.out.println("Qualification:"+rs.getString("Qualification"));
                        System.out.println("Name         :"+rs.getString("Name"));
                        System.out.println("Address      :"+rs.getString("Address"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                   System.err.println("SQLException "+e.getLocalizedMessage());
                        System.out.println("serch failed!!");
                        }
 }
 //Treatment data form
 
 public void treatData(int treatmentID,int StaffID,String Name,String Medications,String Remarks){
   
      try{
      Statement owist=conn.createStatement();
      
      String query1="INSERT INTO Treatment Values ("+treatmentID+","+StaffID+",'"+Name+"','"+Medications+"','"+Remarks+"')";
       owist.execute(query1);

      System.out.println("Input successful!!");}
  
     catch(SQLException e){
         System.err.println("SQLException:"+e.getMessage());
         System.out.println("Input failed!!");
     }
  }
    
    
      
public void treatdeleteData(int treatmentid){
   
      try{
      Statement liveist=conn.createStatement();
      
      String query1="DELETE  From Treatment WHERE treatmentid="+treatmentid;
       liveist.execute(query1);

      System.out.println("Delete successful!!");}
  
     catch(SQLException e){
         System.out.println("Delete failed!!");
     }
}
 public void treatsearchData(int treatmentid){
        try{
            Statement live = conn.createStatement();
            String query="SELECT * FROM Treatment WHERE treatmentid="+treatmentid;
            ResultSet rs=live.executeQuery(query);
            if (rs.next()){
                System.out.println("Id  found!!");
                    do {
                        System.out.println("Treatment ID  :"+rs.getInt("treatmentid"));
                        System.out.println("Staff ID      :"+rs.getString("StaffID"));
                        System.out.println("Name          :"+rs.getString("Name"));
                        System.out.println("Medications   :"+rs.getString("Medications"));
                    }while(rs.next());
                 
                  }  
            else{
                System.out.println("Id Not Found!!");
                    }
            
        }
    
                catch(SQLException e){
                   System.err.println("SQLException "+e.getLocalizedMessage());
                        System.out.println("serch failed!!");
                        }
 }

    

    
    
    
    }
 
 














