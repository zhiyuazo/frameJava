package trytest.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trytest.restful.bean.Student;
import trytest.restful.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired StudentDao studentDao;

	@GetMapping("student")
	public String listStudent(Model m ,
							  @RequestParam(value="start" ,defaultValue="0")int start, 
							  @RequestParam(value="size" ,defaultValue="5")int size )throws Exception {
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pa = PageRequest.of(start, size, sort);
		Page<Student> page = studentDao.findAll(pa);
		System.out.println("page.getNumber: " + page.getNumber());
        System.out.println("page.getNumberOfElements: " + page.getNumberOfElements());
        System.out.println("page.getSize: "+page.getSize());
        System.out.println("page.getTotalElements: " + page.getTotalElements());
        System.out.println("page.getTotalPages" + page.getTotalPages());
		m.addAttribute("page",page);
		return "restful/listStudent";
	}
	
	@PostMapping("student")
	public String addUser(Student s )throws Exception {
		studentDao.save(s);
		return "redirect:/student";
	}
	@DeleteMapping("student/{id}")
	public String delStudent(Student s )throws Exception {
		studentDao.delete(s);;
		return "redirect:/student";
	}
	@PutMapping("student/{id}")
	public String updateStudent(Student s )throws Exception {
		studentDao.save(s);
		return "redirect:/student";
	}
	
	@GetMapping("student/{id}")
	public String editCategory(Model m , @PathVariable("id")int id )throws Exception {
		Student s = studentDao.getOne(id);
		m.addAttribute("s",s);
		return "restful/editStudent";
	}
}
