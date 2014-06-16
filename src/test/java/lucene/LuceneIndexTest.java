package lucene;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import kr.pe.constr.lucene.Indexer;

import org.apache.lucene.search.Query;
import org.junit.Test;

public class LuceneIndexTest {
	
	Indexer idx = new Indexer();

	@Test
	public void makeFileIndexerTest(){
		System.out.println("Start!!--");
		String idxPath ="/Users/AceT/app/springsource/workspace/luceneIndex/index";
	    String targetPath="/Users/AceT/app/springsource/workspace/luceneIndex/data";
		File indexDir = new File(idxPath);         // 여기에 루씬 색인을 만든다. 
		File dataTargetDir = new File(targetPath); // 이 디렉토리에 포함된 텍스트 파일을 색인한다. 즉, 색인대상!
		
		long start = new Date().getTime();
		int numIndexed = idx.index(indexDir, dataTargetDir);
		long end = new Date().getTime();
		
		System.out.println("Indexing "+ numIndexed + "files took "+ (end-start)+ " milliseconds");
		
		doSearchTest(indexDir);
		
		
	}

    
	public void doSearchTest(File indexDir) {
		System.out.println("======== start search!! ==========");
		Query q = idx.queryExcute();
		idx.search(q, indexDir);
		System.out.println("======== end search!! ==========");
	}
	
	
	//@Test
	public void searchTest(){
		String idxPath ="/Users/AceT/app/springsource/workspace/luceneIndex/index";
		File indexDir = new File(idxPath);         // 만들어진 루씬 색인!!
		doSearchTest(indexDir);
		
		
	}

}
