package bean;

public class Category {
	int id ; 
	String name ;
	
	public void setId(int v) {
		this.id  = v;
	}
	public int getId() {
		return this.id ;
	}
	
	public void setName(String v) {
		this.name  = v;
	}
	public String  getName() {
		return this.name ;
	}
	
	public String toString() {
		return "Category[" + id +"," + name + "]";
	}
}
