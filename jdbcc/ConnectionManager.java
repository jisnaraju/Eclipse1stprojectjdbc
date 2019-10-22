package jdbcc;
import java.util.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class ConnectionManager {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
	    Connection1 obj=new Connection1();
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     do{
	    	 
	     System.out.println("1.Admin Login");
	     System.out.println("2.Agent Login");
	     System.out.println("3.Exit");
	     int choice=Integer.parseInt(br.readLine());
	     Statement statement=obj.main1().createStatement();
	    // PreparedStatement ps = null;
	     try {
	     switch(choice){
	    	 case 1:
	    	 {   
	    		 System.out.println("Enter your Username");
	    		 String s=br.readLine();
	    		 System.out.println("Enter your password");
	    	     String t=br.readLine();
	    		 ResultSet rs;
	    			 rs=statement.executeQuery("select username,password from admin1");
	    			 if(rs.next())
	    			 {
	    				 if((rs.getString(1).equals(s))&& (rs.getString(2).equals(t)))
	    				 {
	    					 System.out.println("1.Add product");
	    					 System.out.println("2.Display Inventory details ");
	    					 System.out.println("3.Logout");
	    					 int choice1=Integer.parseInt(br.readLine());
	    					 switch(choice1) {
	    					 case 1:
	    					 {
	    						
	    						 System.out.println("Enter the product id");
	    						 int id=Integer.parseInt(br.readLine());
	    						 System.out.println("Enter the product name");
	    						 String name=br.readLine();
	    						 System.out.println("Enter the Minimum sellquantity");
	    						 int q=Integer.parseInt(br.readLine());
	    						 System.out.println("Enter the Price");
	    						 int p=Integer.parseInt(br.readLine());
	    						 System.out.println("Enter the quantityAvailable");
	    						 int q1=Integer.parseInt(br.readLine());
	    						 int cost1=p*q1;
	    						 
	    						 //String sql = "INSERT INTO admin2(Productid,productname,MinSellquan,price,qunt) values(?,?,?,?,?)";
	    						 statement.execute("INSERT INTO admin2(Productid,productname,minsell,price,qunt,cost)values('"+id+"','"+name+"','"+q+"','"+p+"','"+q1+"','"+cost1+"')");
	    						/* ps = (PreparedStatement) obj.main1().prepareStatement(sql);
	    						 ps.setInt(1,id);
	    						 ps.setString(2,name);
	    						 ps.setInt(3,q);
	    						 ps.setInt(4,p);
	    						 ps.setInt(5,q1);
	    						 ps.execute();*/
	    						 break;
	    					 }
	    					 
	    					 case 2:
	    					 {
	    						 
	    					ResultSet rs1=statement.executeQuery("select Productid,productname,minsell,price,qunt,cost from admin2");
	    					
	    					if(rs1.next())
	    					{
	    						do{
	    					{
	    						System.out.println("--------------------------------------------------------------------------------------------------");
	    						System.out.println("Product id"+"\t"+"Product name"+"\t"+"minsell"+"\t"+"Price"+"\t"+"Quantity"+"\t"+"Cost");
	    						
	    						System.out.println(rs1.getInt("Productid")+"\t"+"\t"+"\t"+rs1.getString("productname")+"\t\t\t"+rs1.getInt("minsell")+"\t"+"\t"+rs1.getInt("price")+"\t\t\t"+rs1.getInt("qunt")+"\t\t"+rs1.getInt("cost"));
	    					}
	    						}while(rs1.next());
	    					}
	    						
	    						 
	    					 }
	    					 }
	    				 }
	    			 }
	    					
	    					 
	    					 
	    				break;		 
	    						 
	    						 
	    			 }
	    	 case 2:  //Agent details
	    	 {
	    		
	    		 System.out.println("Enter the Agent Username");
	    		 String s1=br.readLine();
	    		 System.out.println("Enter the Agent password");
	    	     String t1=br.readLine();
	    	     ResultSet rs2;
	    	     rs2=statement.executeQuery("select username1,password from agent1");
    			 if(rs2.next())
    			 {

    				 if((rs2.getString(1).equals(s1))&& (rs2.getString(2).equals(t1)))
    				 { 
    					 System.out.println("1.Buy/Sell");
    					 System.out.println("2.Show History ");
    					 System.out.println("3.Logout");
    					 int choice2=Integer.parseInt(br.readLine());
    					 switch(choice2) {
    					 case 1:
    					 {
    						 Buy b = new Buy();
    						 b.add();
    						 break;
    						 
    					 
    				 }
    					 case 2:
    					 {
    						 ResultSet rs1=statement.executeQuery("select * 	from agentup");
 	    					
 	    					if(rs1.next())
 	    					{
 	    						do{
 	    					{
 	    						System.out.println("--------------------------------------------------------------------------------------------------");
 	    						System.out.println("Product name"+"\t"+"Buy/sell"+"\t"+"Cost"+"\t"+"Quantity"+"\t"+"TotalCost");
 	    						
 	    						System.out.println(rs1.getString("productname")+"\t"+rs1.getString("buy/sell")+"\t\t"+rs1.getInt("cost")+"\t"+rs1.getInt("quantity")+"\t\t"+rs1.getInt("totalcost"));
 	    					}
 	    							}while(rs1.next());
 	    						}
 	    					break;
    					 }
    					 case 3:
    					 {
    						 System.exit(0);
    					 }
    					 }
    				}
    			 }
	    	 }
    					 
	     }
	     } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

	     }
	     }while(true);					 
	}
	     }

	    					 
	    		 
	    		
