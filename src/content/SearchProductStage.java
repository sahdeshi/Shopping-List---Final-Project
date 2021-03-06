/*
   Name: Shivam Sahdev
   Student ID: 991411814
   Final-project
   
 */
package content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author shivamsahdev
 */
public class SearchProductStage  extends Stage {
    
     private ArrayList <Order> oList= new ArrayList<>();
    private String product=new String();
     public SearchProductStage(ArrayList <Order> oList,String product){
    this.product=product;
    this.oList = oList;
    setTitle("Search Search product");
    setScene(addScene()); 
    }
   
    private Scene addScene(){
   
    String orderFile = new String();
   
   
    for (int i = 0 ;i< oList.size();i++)
{
  Order two =  oList.get(i);
  if(product.equalsIgnoreCase(two.getProducts()))
  {
orderFile+="Order ID: "+two.getOrderId() +"\n"
        + "Customer ID: " + two.getCustomerId()+"\n" 
        +"Product: "  + two.getProducts() + "\n"
        +"Shipping: " + two.getShipping() + "\n"
        +"\n";
  }
}
    TextArea txtDisplay = new TextArea(orderFile);
   
    VBox vpane = new VBox(txtDisplay);
    BorderPane pane = new BorderPane();
    pane.setCenter(vpane);
    
     Scene scene = new Scene(pane,700,700);
    return scene;
    
}
    
}

