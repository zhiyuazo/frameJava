package trytest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trytest.redis.bean.Bird;
import trytest.redis.service.BirdService;
import trytest.redis.util.Page4Navigator;

@Controller
public class BirdController {
	@Autowired BirdService birdService;

	@RequestMapping("listbird")
	public String listBird(Model m ,
							  @RequestParam(value="start" ,defaultValue="0")int start, 
							  @RequestParam(value="size" ,defaultValue="5")int size )throws Exception {
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pa = PageRequest.of(start, size, sort);
		Page4Navigator<Bird> page = birdService.list(pa);
		System.out.println("page.getNumber: " + page.getNumber());
        System.out.println("page.getNumberOfElements: " + page.getNumberOfElements());
        System.out.println("page.getSize: "+page.getSize());
        System.out.println("page.getTotalElements: " + page.getTotalElements());
        System.out.println("page.getTotalPages" + page.getTotalPages());
		m.addAttribute("page",page);
		return "redis_try/listBird";
	}
	
	@RequestMapping("addbird")
	public String addBird(Bird c )throws Exception {
		birdService.save(c);
		return "redirect:listbird";
	}
	@RequestMapping("delbird")
	public String delBird(Bird c )throws Exception {
		birdService.delete(c);;
		return "redirect:listbird";
	}
	@RequestMapping("updatebird")
	public String updateBird(Bird c )throws Exception {
		birdService.save(c);
		return "redirect:listbird";
	}
	
	@RequestMapping("editbird")
	public String editBird(Model m , int id )throws Exception {
		Bird c = birdService.get(id);
		m.addAttribute("c",c);
		return "redis_try/editBird";
	}
}
