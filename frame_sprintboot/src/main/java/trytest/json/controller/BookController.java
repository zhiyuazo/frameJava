package trytest.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import trytest.json.bean.Book;
import trytest.json.dao.BookDao;

@Controller
public class BookController {
	@Autowired BookDao bookDao;

	@ResponseBody
	@GetMapping("bookjson")
	public List<Book> listBookJson(Model m ,
							  @RequestParam(value="start" ,defaultValue="0")int start, 
							  @RequestParam(value="size" ,defaultValue="5")int size )throws Exception {
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pa = PageRequest.of(start, size, sort);
		Page<Book> page = bookDao.findAll(pa);
		m.addAttribute("page",page);
		return page.getContent();
	}
	
	@ResponseBody
	@GetMapping("bookjson/{id}")
	public Book getBook( @PathVariable("id")int id )throws Exception {
		Book book = bookDao.getOne(id);
		System.out.println("get book..." + book);
		return book; 
	}
	
	@PostMapping("bookjson")
	public void addBook( @RequestBody Book b)throws Exception {
		System.out.println("Sprintboot receive Json: " + b);
		bookDao.save(b);
		System.out.println("Insert into DB OK...");
	}
}
