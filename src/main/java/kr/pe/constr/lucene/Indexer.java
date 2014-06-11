package kr.pe.constr.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class Indexer {
	private StandardAnalyzer analyzer;
	private Directory index;
	
	// Step 01.
	public Indexer(){
		
		IndexWriter w = null;
		IndexWriterConfig config; 
		
		try {
			
			// The same analyzer should be used for indexing and searching
			analyzer = new StandardAnalyzer(Version.LUCENE_40); 
			// Filters StandardTokenizer with StandardFilter, LowerCaseFilter and StopFilter, using a list of English stop words.

			// 1. create the index
			index = new RAMDirectory();
	
			config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
	
			w = new IndexWriter(index, config); // 인덱스 생성 
		
			addDoc(w, "Lucene in Action", "193398817");
			addDoc(w, "Lucene for Dummies", "55320055Z");
			addDoc(w, "Managing Gigabytes", "55063554A");
			addDoc(w, "The Art of Computer Science", "9900333X");
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {      
				w.close();
			} catch (CorruptIndexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
	
	// 색인에 추가할 데이터 Document단위로 넣어주기 
	private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
		Document doc = new Document();
		System.out.println("title->"+title+"=== isbn->"+isbn);
		doc.add(new TextField("title", title, Field.Store.YES));

		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("isbn", isbn, Field.Store.YES));
		w.addDocument(doc);
	}
	
	// step 02.
	public Query queryExcute(){
		// 2. query
		String querystr = "Lucene";

		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query q = null;
		try {
			q = new QueryParser(Version.LUCENE_40, "title", analyzer).parse(querystr);
			System.out.println("q="+q);
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			e.printStackTrace();
		}
		return q;
	}
	
	// step 03.
	public void search(Query q){
		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = null;
		ScoreDoc[] hits = null; 
		IndexSearcher searcher;
		TopScoreDocCollector collector;
		try {
			reader = DirectoryReader.open(index);  // index reading
			searcher = new IndexSearcher(reader);  // Creates a searcher searching the provided index.
			collector = TopScoreDocCollector.create(hitsPerPage, true); // 어떻게 가져올 것인가? 
			searcher.search(q, collector); // 색인에 대해 search(), Lower-level search API. return void
			hits = collector.topDocs().scoreDocs;  // docId를 꺼내 hits[]에 넣어준다. 
			display(hits, searcher);
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private void display(ScoreDoc[] hits, IndexSearcher searcher){
		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;  // return docId number
			System.out.println("docId="+docId);
			Document d;
			try {
				d = searcher.doc(docId);  // return 실제 문서 document object return
				System.out.println((i + 1) + ". " + d.get("title") + "\t" + d.get("isbn"));
			} catch (CorruptIndexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
