package trytest.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import trytest.thymeleaf.bean.Car;
import trytest.thymeleaf.service.CarService;

@Controller
public class CarController {
	@Autowired
	CarService carService;
	
	@GetMapping("/car")
	public PageInfo<Car> list(@RequestParam(value="start",defaultValue = "1")int start, 
							   @RequestParam(value="size",defaultValue = "5")int size)throws Exception  {
		System.out.println("--------------enter into car" );
		PageHelper.startPage(start, size, "id desc");
		List<Car> us = carService.list();
		System.out.println("--------------after get cars" + us.size());
		PageInfo<Car> page = new PageInfo<>(us,5);
		return page;
	}
	
	@GetMapping("/car/{id}")
	public Car get(@PathVariable("id") int id) {
		Car u = carService.get(id);
		return u;
	}
	
	@DeleteMapping("/car/{id}")
	public String del(@PathVariable("id") int id) {
		carService.delete(id);
		return "success";
	}

	@PostMapping("/car")
	public String add(@RequestBody Car car) {
		carService.add(car);
		return "success";
	}
	
	@PutMapping("/car/{id}")
	public String update(@RequestBody Car car) {
		carService.update(car);
		return "success";
	}
	
	@RequestMapping(value="/listcar", method=RequestMethod.GET)
    public ModelAndView listUser(){
		System.out.println("****************************run here");
        ModelAndView mv = new ModelAndView("vue_restful/listcar");
        return mv;
    }
     
    @RequestMapping(value="/editcar", method=RequestMethod.GET)
    public ModelAndView editUser(){
        ModelAndView mv = new ModelAndView("vue_restful/editcar");
        return mv;
    }    
}
