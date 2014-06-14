package kr.pe.constr.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RndMainController {
	
	//private static  final Logger logger = (Logger) LogManager.getLogger(SearchResultController.class.getName());
	private static final Logger logger = LoggerFactory.getLogger(RndMainController.class);
    
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String rndIndex(Model model){
		logger.info("Welcome to index page!");
		return "rndIndex";
	}
	
	
	// Search Result Page
	@RequestMapping(value = "/search/search.json", method = RequestMethod.GET)
	public String searchEngine(@RequestParam("searchKeyword") String searchKeyword, Model model) {
		
		System.out.println("#######searchKeyword########"+searchKeyword);
		logger.info("Welcome searchKeyword~!!");
		
		
		//model.addAttribute("serverTime",  );
		model.addAttribute("searchKeyword",searchKeyword);
		
		return "searchResult";
	}
	
	
	
	
}
