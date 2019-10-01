package bean;

import java.util.List;

public class Order {
	private int id;
    private String code;
     
    List<OrderProducts> orderproducts;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<OrderProducts> getOrderProducts() {
        return orderproducts;
    }
    public void setOrderProducts(List<OrderProducts> orderproducts) {
        this.orderproducts = orderproducts;
    }
	
	

}
