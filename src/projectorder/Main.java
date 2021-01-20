/*
   Name: Shivam Sahdev
   Student ID: 991411814
   Final-project
   
 */
package projectorder;


import content.DisplayStage;
import content.Order;
import content.OrderFile;
import content.SearchCustomerStage;
import content.SearchProductStage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

/**
 *
 * @author shivamsahdev
 */
public class Main extends Application {
    private ArrayList <Order> oList = new ArrayList<>();
    
    private Label lblId = new Label ("Order ID: ");
    private TextField txtId = new TextField ();
    
    private Label lblCustomer = new Label ("Customer ID: ");
    private TextField txtCustomer = new TextField ();
    
    private Label lblProducts = new Label ("Products: ");
    private TextField txtProducts = new TextField ();
    
    private Label lblShipping = new Label ("Shipping Method: ");
    private TextField txtShipping= new TextField ();
    
            
    
    private Button btnNxt = new Button("Next");
    private Button btnPre = new Button("Privious");
    
    private Button btnFirst = new Button("Check First");
    private Button btnLast = new Button("Check Last ");
    
    private Button btnAdd = new Button("Add to List");
    private Button btnDelete = new Button("Delete From List");
    private Button btnUpdate = new Button("Update List");
    
    
    private Label lblFindId = new Label("Enter Customer ID:");
    
    
    private TextField txtFindId = new TextField();
    private Button btnFindId = new Button("Search");
    private Label lblFindProduct = new Label("Enter Product:");
    private TextField txtFindProduct = new TextField();
    private Button btnFindProduct = new Button("Search");
    private Button btnDisplay = new Button("Display");
    
    
    
    
    
    
     int sub=0;
    boolean add=false;
     
    public Main()
    {
        try {
            oList=OrderFile.getList();
        } 
        catch (IOException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }
    
    @Override
    
    
    public void start(Stage primaryStage) {
     
       
Scene scene = new Scene(addPane(), 375, 400);
        
        primaryStage.setTitle("Shopping-Final Project");
     primaryStage.setScene(scene);
        primaryStage.show();
           txtId.setText(oList.get(0).getOrderId());
           txtCustomer.setText(oList.get(0).getCustomerId());
           txtProducts.setText(oList.get(0).getProducts());
            txtShipping.setText(oList.get(0).getShipping());
          btnDisplay.setOnAction(e->{
          
       DisplayStage ds = new DisplayStage(oList);
       displayAll();
        ds.show();
        
        
        });   
        btnAdd.setOnAction((e)->{
         txtId.clear();
        txtCustomer.clear();
        txtProducts.clear();
        txtShipping.clear();
       
            add=true;
        });
        
        btnFindId.setOnAction((e)->{
            SearchCustomerStage ds =new SearchCustomerStage(oList,txtFindId.getText());
            ds.show();
            txtFindId.clear();
        });
        
        btnFindProduct.setOnAction((e)->{
            SearchProductStage ds =new SearchProductStage(oList,txtFindProduct.getText());
            ds.show();
            txtFindProduct.clear();
        });
        
        btnDisplay.setOnAction((e)->{
            DisplayStage ds=new DisplayStage(oList);
            ds.show();
        });
       
        btnFirst.setOnAction((e)->{
            txtId.setText(oList.get(0).getOrderId());
            txtCustomer.setText(oList.get(0).getCustomerId());
            txtProducts.setText(oList.get(0).getProducts());
            txtShipping.setText(oList.get(0).getShipping());
            sub=0;
        });
        
        btnLast.setOnAction((e)->{
            int size=oList.size();
            txtId.setText(oList.get(size-1).getOrderId());
            txtCustomer.setText(oList.get(size-1).getCustomerId());
            txtProducts.setText(oList.get(size-1).getProducts());
            txtShipping.setText(oList.get(size-1).getShipping());
            sub=size-1;
        });
        
        btnNxt.setOnAction((e)->{
            int size=oList.size();
            sub++;
            if(sub>=size)
            {
            txtId.setText(oList.get(0).getOrderId());
            txtCustomer.setText(oList.get(0).getCustomerId());
            txtProducts.setText(oList.get(0).getProducts());
            txtShipping.setText(oList.get(0).getShipping());
            sub=0;
            }
            else
            {
            txtId.setText(oList.get(sub).getOrderId());
            txtCustomer.setText(oList.get(sub).getCustomerId());
            txtProducts.setText(oList.get(sub).getProducts());
            txtShipping.setText(oList.get(sub).getShipping());
            }
        });
        
        btnPre.setOnAction((e)->{
             int size=oList.size();
            sub--;
            if(sub<0)
            {
                txtId.setText(oList.get(size-1).getOrderId());
                txtCustomer.setText(oList.get(size-1).getCustomerId());
                txtProducts.setText(oList.get(size-1).getProducts());
                txtShipping.setText(oList.get(size-1).getShipping());
                sub=size-1;
            }
            else
            {
            txtId.setText(oList.get(sub).getOrderId());
            txtCustomer.setText(oList.get(sub).getCustomerId());
            txtProducts.setText(oList.get(sub).getProducts());
            txtShipping.setText(oList.get(sub).getShipping());
            }
        });
        
        btnUpdate.setOnAction((e)->{
            try
            {
                Alert dlgConfirmation=new Alert(Alert.AlertType.CONFIRMATION);
                dlgConfirmation.setHeaderText("Add or Update?");
                Optional<ButtonType> result= dlgConfirmation.showAndWait();
                Alert dlgInfo=new Alert(Alert.AlertType.INFORMATION);
                String message=new String();
                if(result.get()==ButtonType.OK)
                {
                    if(add==false)
                    {
                        Order three= oList.get(sub);
                        if(!txtId.getText().equals(three.getOrderId())
                  &&!txtCustomer.getText().equals(three.getCustomerId()))
                        {
                          Alert dlgError=new Alert(Alert.AlertType.ERROR);
                          dlgError.setContentText("cannot be changed");
                          dlgError.show();
                        }
                            three.setProducts(txtProducts.getText());
                            three.setShipping(txtShipping.getText());
                            message="your Order id successfully updated";
                            txtId.setText(three.getOrderId());
                            txtCustomer.setText(three.getCustomerId());
                            txtProducts.setText(three.getProducts());
                            txtShipping.setText(three.getShipping());
                   }
                    else
                    {
                     String orderID=txtId.getText();
        String customerID=txtCustomer.getText();
        String product=txtProducts.getText();
        String shipping=txtShipping.getText();
        Order one=new Order(orderID);
        one.setCustomerId(customerID);
        one.setProducts(product);
        one.setShipping(shipping);
        oList.add(one);
                    message="Order Added - Succesfull";
                    int size=oList.size();
                    txtId.setText(oList.get(size-1).getOrderId());
                    txtCustomer.setText(oList.get(size-1).getCustomerId());
                    txtProducts.setText(oList.get(size-1).getProducts());
                    txtShipping.setText(oList.get(size-1).getShipping());
                    }
                }
                else
                {
                    message="Adding/Updating Order - Cancelled";
                    txtId.setText(oList.get(sub).getOrderId());
                    txtCustomer.setText(oList.get(sub).getCustomerId());
                    txtProducts.setText(oList.get(sub).getProducts());
                    txtShipping.setText(oList.get(sub).getShipping());
                }
                OrderFile.setList(oList);
                dlgInfo.setContentText(message);
                dlgInfo.show();
            }
            catch(Exception exep)
            {
                System.err.println("Error is: "+exep.getMessage());
            }
        });

        btnDelete.setOnAction((e)->{
            try {
                int size=oList.size();
                Alert dlgConfirmation=new Alert(Alert.AlertType.CONFIRMATION);
                dlgConfirmation.setHeaderText("Want to delete order?");
                Optional<ButtonType> result= dlgConfirmation.showAndWait();
                Alert dlgInfo=new Alert(Alert.AlertType.INFORMATION);
                String message=new String();
                if(result.get()==ButtonType.OK)
                {
                    oList.remove(sub);
                    message="Order successfully deleted";  
                    size=oList.size();
                }
                else
                {
                    message="Deletion Cancelled";
                }
                if(sub>=size)
                {
                    sub=size-1;
                }
                OrderFile.setList(oList);
                dlgInfo.setContentText(message);
                dlgInfo.show();
                txtId.setText(oList.get(sub).getOrderId());
                txtCustomer.setText(oList.get(sub).getCustomerId());
                txtProducts.setText(oList.get(sub).getProducts());
                txtShipping.setText(oList.get(sub).getShipping());
            } catch(IOException ex){
                 System.err.println("Error is: "+ex.getMessage());
            }
        });

        
        
        
      
    }

    
    private GridPane addPane(){
        
        GridPane pane = new GridPane();
        pane.add(lblId, 0,0);
        pane.add(txtId, 1, 0);
        
        pane.add(lblCustomer, 0, 1);
        pane.add(txtCustomer, 1, 1);
        
        pane.add(lblProducts, 0, 2);
        pane.add(txtProducts, 1, 2);
        
        pane.add(lblShipping, 0, 3);
        pane.add(txtShipping, 1, 3);
        
        pane.add(btnNxt, 0, 4);
        pane.add(btnPre, 2, 4);
        
        pane.add(btnFirst, 0, 5);
        pane.add(btnLast, 2, 5);
        
        pane.add(btnUpdate, 0, 6);
        pane.add(btnAdd, 1, 6);
        pane.add(btnDelete, 2, 6);
        
        pane.add(lblFindId, 0, 7);
        pane.add(txtFindId, 1, 7);
        pane.add(btnFindId, 2, 7);
        
        pane.add(lblFindProduct, 0, 8);
        pane.add(txtFindProduct, 1, 8);
        pane.add(btnFindProduct, 2, 8);
        
        pane.add(btnDisplay, 1, 9);
        
        
        
        
        return pane;
    }
    
    
    private String displayAll()
    {
        String data=new String();
        for(Order sub: oList)
        {
            data+=sub.getOrderId()+","+sub.getCustomerId()+","
                    +sub.getProducts()+","+sub.getShipping()+"\n";
        }
        return data;
    }

    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
