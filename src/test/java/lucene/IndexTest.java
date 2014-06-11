package lucene;

import org.apache.lucene.search.Query;
import org.junit.Assert;
import org.junit.Test;

import kr.pe.constr.lucene.Indexer;

public class IndexTest {
	
	@Test
	public void makeIndexerTest(){
		Indexer idx = new Indexer();
		Query q = idx.queryExcute();
		Assert.assertNotNull(idx);
		Assert.assertNotNull(q);
		System.out.println("query=>"+q.toString());
		
		idx.search(q);
		
	}
	
}
