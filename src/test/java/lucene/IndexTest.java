package lucene;

import java.io.File;
import java.util.Date;

import org.apache.lucene.search.Query;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import kr.pe.constr.lucene.Indexer;

public class IndexTest {
	
	@Test
	public void makeFileIndexerTest(){
		System.out.println("Start!!");
		Indexer idx = new Indexer();
		String idxPath ="/Users/AceT/app/springsource/workspace/luceneIndex/index";
	    String targetPath="/Users/AceT/app/springsource/workspace/luceneIndex/data";
		File indexDir = new File(idxPath);         // 여기에 루씬 색인을 만든다. 
		File dataTargetDir = new File(targetPath); // 이 디렉토리에 포함된 텍스트 파일을 색인한다. 즉, 색인대상!
		
		long start = new Date().getTime();
		int numIndexed = idx.index(indexDir, dataTargetDir);
		long end = new Date().getTime();
		
		System.out.println("Indexing "+ numIndexed + "files took "+ (end-start)+ " milliseconds");
		
		
		
	}
	
	@Test
	public void makeIndexerTest2222(){
		Indexer idx = new Indexer("ace-t");
		Query q = idx.queryExcute();
		Assert.assertNotNull(idx);
		Assert.assertNotNull(q);
		System.out.println("query=>"+q.toString());
			
		//idx.search(q);
			
	}

	
}
