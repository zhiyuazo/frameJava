package entity;

import org.springframework.stereotype.Component;

@Component("c2")
public class Category2 {
	
	    private int id;
	    private String name = "category 1";
	    
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
}
