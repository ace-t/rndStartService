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
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search/searchResult.json", method = RequestMethod.POST)
	public String search(@RequestParam("searchInput") String searchKeyword, Model model) {
		
		System.out.println("#######searchResult########"+searchKeyword);
		logger.info("Welcome searchResult~!!");
		
		
		//model.addAttribute("serverTime",  );
		model.addAttribute("searchKeyword",searchKeyword);
		
		return "searchResult";
	}
	
	
	
	
}
