package trytest.thymeleaf.bean;

public class Tree {
	private int id;
    private String name;
    private int heigh;
    
    public Tree(int id, String name, int h) {
        super();
        this.id = id;
        this.name = name;
        this.heigh = h;
    }
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
    public int getHeigh() {
        return heigh;
    }
    public void setHeigh(int h) {
        this.heigh = h;
    }
}
