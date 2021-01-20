/*
   Name: Shivam Sahdev
   Student ID: 991411814
   Final-project
   
 */
package content;

    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrderFile {
    public static ArrayList<Order> getList()
   throws IOException{
   
   ArrayList<Order> oList = new ArrayList<>();
   FileReader fr = new FileReader("Order.dat");
   BufferedReader br = new BufferedReader(fr);
   String s1 = br.readLine();
   while(s1!=null){
   StringTokenizer st = new StringTokenizer(s1, ",");
   String OrderID = st.nextToken();
   String customerID = st.nextToken();
   String product = st.nextToken();
   String shippingMethod = st.nextToken();
  
   Order one = new Order(OrderID);
  one.setCustomerId(customerID);
  one.setProducts(product);
  one.setShipping(shippingMethod);
  oList.add(one);
  s1 = br.readLine();
  
   }
   br.close();
   fr.close();
   
   return oList;
   }
   public static void setList(ArrayList <Order> orderlist)
   throws IOException{
   
   FileWriter fw = new FileWriter("Order.dat");
   
   BufferedWriter bw = new BufferedWriter(fw);
   
   String order1 = new String();
   
   for(int sub = 0 ;sub<orderlist.size();sub++){
     Order one = orderlist.get(sub);
     
   order1 = one.getOrderId() + ", "+ one.getCustomerId() + ", " 
           + one.getProducts() + ", " + one.getShipping();
   bw.write(order1);
   bw.newLine();
   }
   bw.close();
   fw.close();
   
   }
    
}

    
    
    

