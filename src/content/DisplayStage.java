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

public class DisplayStage extends Stage {
     
     private ArrayList <Order> oList= new ArrayList<>();
   
     public DisplayStage(ArrayList <Order> oList){
   
    this.oList = oList;
    setTitle("Display Stage");
    setScene(addScene()); 
    }
   
    private Scene addScene(){
   
    String orderFile = new String();
   
    for (int i = 0 ; i< oList.size();i++)
{
  Order one =  oList.get(i);
orderFile+="Order ID: "+one.getOrderId() +"\n"
        + "Customer ID: " + one.getCustomerId()+"\n" 
        +"Product: "  + one.getProducts() + "\n"
        +"Shipping: " + one.getShipping() + "\n"
        +"\n";

}
    TextArea txtDisplay = new TextArea(orderFile);
 
    VBox vpane = new VBox(txtDisplay);
    BorderPane pane = new BorderPane();
    pane.setCenter(vpane);
    
     Scene scene = new Scene(pane,500,500);
    return scene;
    
    }
    
}

