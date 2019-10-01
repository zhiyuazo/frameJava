package entity;

import java.util.Set;

public class Product {
	
	int id;
	String name; 
	float price;
	Category category ; 
    Set<User> users;
    int version;
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
	
	public void setCategory(Category v) {
		category= v;
	}
	public Category getCategory() {
		return category;
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
	
	public void setPrice(float v) {
		price  =v ;
	}
	
	public float getPrice() {
		return price ;
	}
	
	
	
	
}
