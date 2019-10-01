package trytest.thymeleaf.service;

import java.util.List;

import trytest.thymeleaf.bean.Car;

public interface CarService {
	public int add(Car car);
    
    public void delete(int id);
         
    public Car get(int id);
       
    public int update(Car car); 
         
    public List<Car> list();
}
