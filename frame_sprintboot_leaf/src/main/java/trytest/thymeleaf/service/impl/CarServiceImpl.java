package trytest.thymeleaf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trytest.thymeleaf.bean.Car;
import trytest.thymeleaf.mapper.CarMapper;
import trytest.thymeleaf.service.CarService;

@Service
public class CarServiceImpl implements CarService{
     
    @Autowired CarMapper carMapper;
 
    @Override
    public int add(Car car) {
        return carMapper.add(car);
    }
 
    @Override
    public void delete(int id) {
        carMapper.delete(id);
    }
 
    @Override
    public Car get(int id) {
        return carMapper.get(id);
    }
 
    @Override
    public int update(Car car) {
        return carMapper.update(car);
    }
 
    @Override
    public List<Car> list() {
        return carMapper.list();
    }
 
}