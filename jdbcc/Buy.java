package jdbcc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Buy {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	public void add() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		
		Connection1 obj=new Connection1();
		Statement statement=obj.main1().createStatement();
		System.out.println("Enter the Product id");
		int id1=Integer.parseInt(br.readLine());
		ResultSet rs3=statement.executeQuery("select Productid, productname, minsell, price, qunt, cost from admin2 where Productid='"+id1+"'");
		//ResultSet rs= smt.executeQuery("select productname,price,minsellqty,quantityavailable from addproduct where productid='"+id+"'") ; 
		if(rs3.next())
	     {   
		     int m1=rs3.getInt("minsell");	  
		     int qu=rs3.getInt("qunt");
		     int ct=rs3.getInt("cost");
			 int pr=rs3.getInt("price");
			 String pn=rs3.getString("productname");
			 System.out.println("Productt Name is :"+pn);
			 System.out.println("Product price is :"+pr);
			 System.out.println("Cost is:"+ct);
		
		 System.out.println("Buy/Sell");
		 String  s3=br.readLine();
		 if(s3.equalsIgnoreCase("buy")) {
		 System.out.println("Enter the Quantity");
		 int qnt=Integer.parseInt(br.readLine());
		if(m1>qnt)
		{
			System.out.println("Need Minsell Quantity");
		}
		else if(qnt>qu)
		{
			System.out.println("Quantity is not available");	
		}
		else 
		{
			int tot=pr*qnt;
			statement.execute("insert into agentup values ('"+pn+"','"+s3+"',"+pr+","+qnt+","+tot+")");
			int newqunt=qu-qnt;
			int cost1=newqunt*pr;
			System.out.println("Newquantity is"+newqunt);
			statement.executeUpdate("update admin2 set qunt="+newqunt+" where Productid='"+id1+"'");
			statement.executeUpdate("update admin2 set cost="+cost1+" where Productid='"+id1+"'");
			
		}
		 }
		 if(s3.equalsIgnoreCase("sell")) {
			 System.out.println("Enter the Quantity");
			 int qnt=Integer.parseInt(br.readLine());
			 int tot=pr*qnt;
				int newqunt=qu+qnt;
				int cost1=newqunt*pr;
				System.out.println("Newquantity is"+newqunt);
				statement.execute("insert into agentup values ('"+pn+"','"+s3+"',"+pr+","+qnt+","+tot+")");
				statement.executeUpdate("update admin2 set qunt="+newqunt+" where Productid='"+id1+"'");
				statement.executeUpdate("update admin2 set cost="+cost1+" where Productid='"+id1+"'");
			}
			 
	     }
	}

		
		 
		 }
	 
		
	


