package trytest.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import trytest.thymeleaf.bean.Tree;

@Controller
public class HiLeafController {

	@RequestMapping("/hileaf")
	public String hiLeaf(Model m) {
		m.addAttribute("name","thymeleaf");
		return "hileaf";
	}
	
	@RequestMapping("/expressleaf")
	public String ExpressLeaf(Model m) {
		String htmlnote = "<p> style='color:red'>Red Color</p>";
		Tree tree = new Tree(1, "SongBai", 12);
		m.addAttribute("htmlnote",htmlnote);
		m.addAttribute("tree",tree);
		return "express";
	}
	
	@RequestMapping("/includeleaf")
	public String IncludLeaf(Model m) {
		String htmlnote = "<p> style='color:red'>Red Color</p>";
		Tree tree = new Tree(1, "SongBai", 12);
		m.addAttribute("htmlnote",htmlnote);
		m.addAttribute("tree",tree);
		return "include";
	}
	
	@RequestMapping("/conditionleaf")
	public String ConditionLeaf(Model m) {
		String htmlnote = "<p> style='color:red'>Red Color</p>";
		Tree tree = new Tree(1, "SongBai", 12);
		boolean flag= true;
		m.addAttribute("htmlnote",htmlnote);
		m.addAttribute("tree",tree);
		m.addAttribute("flag",flag);
		return "condition";
	}
	
	@RequestMapping("/foreachleaf")
	public String ForeachLeaf(Model m) {
		List<Tree> treels = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			Tree tree = new Tree(i, "tree " + i, new Random().nextInt(10)+ 5);
			treels.add(tree);
		}
		boolean flag= true;
		m.addAttribute("treels",treels);
		return "foreach";
	}
	
	@RequestMapping("/defaultfunleaf")
	//below list the default funcation:
	/*  http://how2j.cn/k/springboot/springboot-tool/1741.html#nowhere
		Execution Info
		Messages
		URIs/URLs
		Conversions
		Dates
		Calendars
		Numbers
		Strings
		Objects
		Booleans
		Arrays
		Lists
		Sets
		Maps
		Aggregates
		IDs
	*/
	public String DefaultFunLeaf(Model m) {
		Date now = new Date();
		m.addAttribute("now",now);
		return "defaultfun";
	}
}
