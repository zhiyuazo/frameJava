package entity;

import java.util.Set;

public class Category {
	int id ; 
	String name; 
    Set<Product> products;
    public Set<Product> getProducts() {
        return products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
	public void setId(int v) {
		id =v;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String v) {
		name = v;
	}
	public String getName() {
		return name;
	}
	
}
