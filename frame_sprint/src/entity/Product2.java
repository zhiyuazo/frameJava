package entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("p2")
public class Product2 {
	int id ; 
	String name = "product 1";
	@Resource(name="c2")
	Category2 category;
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }	
    public Category2 getCategory() {
        return category;
    }
    public void setCategory(Category2 category) {
        this.category = category;
    }
}
