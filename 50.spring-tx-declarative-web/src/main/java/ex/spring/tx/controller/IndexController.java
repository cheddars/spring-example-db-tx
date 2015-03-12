package ex.spring.tx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ex.spring.tx.model.Article;
import ex.spring.tx.service.ArticleService;

@Controller
public class IndexController {
	@Autowired private ArticleService articleService;
	
	@RequestMapping("/index.html")
	public String index(Model model){
		List<Article> list = articleService.list();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@RequestMapping("/write.html")
	public String write(@RequestParam String title, @RequestParam String content, Model model){
//		System.out.println("params : " + param);
//		String title = (String) param.get("title");
//		String content = (String) param.get("content");
		articleService.write(new Article(1, title, content, 1));
		return index(model);
	}
}
