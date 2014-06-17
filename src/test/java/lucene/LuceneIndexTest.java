package lucene;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import kr.pe.constr.lucene.Indexer;

import org.apache.lucene.search.Query;
import org.junit.Before;
import org.junit.Test;

public class LuceneIndexTest {
	File indexDir=null;
	File dataTargetDir;
	Indexer idx;
	
	@Before
	public void setUp(){
		String idxPath ="/Users/AceT/app/springsource/workspace/luceneIndex/index";
	    String targetPath="/Users/AceT/app/springsource/workspace/luceneIndex/data";
		indexDir = new File(idxPath);         // 여기에 루씬 색인을 만든다. 
		dataTargetDir = new File(targetPath); // 이 디렉토리에 포함된 텍스트 파일을 색인한다. 즉, 색인대상!
		idx = new Indexer();
	}

	//@Test
	public void makeFileIndexerTest(){
		System.out.println("Indexing Start!!--");
		
		
		long start = new Date().getTime();
		int numIndexed = idx.index(indexDir, dataTargetDir);
		long end = new Date().getTime();
		
		System.out.println("Indexing "+ numIndexed + "files took "+ (end-start)+ " milliseconds");
		System.out.println("Indexing Finish!!--");
		
		
	}

    @Test
	public void doSearchTest() {
		System.out.println("======== start search!! ==========");
		String queryStr = "lucene";
		Query q = idx.queryExcute(queryStr);
		idx.search(q, indexDir);
		System.out.println("======== end search!! ==========");
	}
	
}
