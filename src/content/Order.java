
/*
   Name: Shivam Sahdev
   Student ID: 991411814
   Final-project
   
 */
package content;


public class Order {
 
    private String OrderId;
    private String CustomerId;
    private String Products;
    private String Shipping;

    
    
   public Order(String OrderId ){
       this.OrderId = OrderId;
   }
    
    
    public String getOrderId() {
        return OrderId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getProducts() {
        return Products;
    }

    public void setProducts(String Products) {
        this.Products = Products;
    }

    public String getShipping() {
        return Shipping;
    }

    public void setShipping(String Shipping) {
        this.Shipping = Shipping;
    }
    
    
    
    
    
    
    
    
}
