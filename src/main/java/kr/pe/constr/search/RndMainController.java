package kr.pe.constr.search;

import java.io.File;
import java.util.List;

import kr.pe.constr.lucene.ISearch;
import kr.pe.constr.lucene.Indexer;
import kr.pe.constr.lucene.Search;
import kr.pe.constr.search.vo.Person;

import org.apache.lucene.search.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Handles requests for the application home page.
 */
@Controller
public class RndMainController {
	
	//private static  final Logger logger = (Logger) LogManager.getLogger(SearchResultController.class.getName());
	private static final Logger logger = LoggerFactory.getLogger(RndMainController.class);
	File indexDir=null;
	File dataTargetDir;
	Indexer idx = null;
	ISearch search =null; 
	Query q = null;
	String idxPath ="/Users/AceT/app/springsource/workspace/luceneIndex/index";
    String targetPath="/Users/AceT/app/springsource/workspace/luceneIndex/data";
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String rndIndex(Model model){
		logger.info("Welcome to index page!");
		return "rndIndex";
	}
	
	
	/**
	 * 
	 * @param searchKeyword
	 * @return
	 */
	// Search Result Page
	@RequestMapping(value = "/search.json", method = RequestMethod.GET)
	public ModelAndView searchEngine(@RequestParam("searchKeyword") String searchKeyword) {
		
		//List<String> searchResultData = new ArrayList<String>();
		String searchResultData=null;
		System.out.println("#######searchKeyword########"+searchKeyword);
		logger.info("Welcome searchKeyword~!!");
		
		System.out.println("======== start search!! ==========");
		
		indexDir = new File(idxPath);         // 여기에 루씬 색인을 만든다. 
		String queryStr = searchKeyword;
		Search search = new Search();
		Query q = search.queryExcute(queryStr);
		searchResultData = search.search(q, indexDir);
		System.out.println("======== end search!! ==========");
		
		List<Person> searchResults = new Gson().fromJson(searchResultData, new TypeToken<List<Person>>() {}.getType());
		
		ModelAndView model = new ModelAndView("searchResult");
		model.addObject("searchResults", searchResults);
		model.addObject("searchKeyword",searchKeyword);
		
		return model;
	}
	
	
	
	
}
