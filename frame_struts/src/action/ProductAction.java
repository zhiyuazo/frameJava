package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import bean.Product;

public class ProductAction {
	private Product product;
	private String alias = "nihaoma";
	public void setAlias(String v) {
		alias=v;
	}
	
	public String getAlias() {
		return alias;
	}
	
	
   private List<Product> products;
   
	public List<Product> getProducts() {
		return products;
	}
  
	public void setProducts(List<Product> products) {
		this.products = products;
	} 
    public String add() {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.getSession().setAttribute("name1",product.getName() );
    	Map m = ActionContext.getContext().getSession();
        m.put("name", product.getName());
        System.out.println("product.name:"+product.getName());
        return "show";
    }
    public String show() {
    	 HttpServletRequest request = ServletActionContext.getRequest();
         HttpServletResponse response = ServletActionContext.getResponse();
  
         System.out.println("request:\t" + request);
         System.out.println("response:\t" + response);
    	
        product = new Product();
        product.setName("iphone7");
        return "show";
    }
 
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
    public String list() {
    	  
        products=new ArrayList();
  
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("product1");
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("product2");
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("product3");
  
        products.add(p1);
        products.add(p2);
        products.add(p3);
  
        return "list";
  
    }
    
    
}
