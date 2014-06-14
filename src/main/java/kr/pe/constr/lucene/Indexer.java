package kr.pe.constr.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
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
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockFactory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

public class Indexer {
	private Directory index;

	public Indexer(){}
	
	// Step 01.
	public Indexer(String str){

		IndexWriter w = null;
		IndexWriterConfig config; 

		try {

			// The same analyzer should be used for indexing and searching
			//StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40); 
			Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_40);
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

	public int index(File indexDir, File dataTargetDir) {
		// TODO Auto-generated method stub
		
		LockFactory lf = null;
		//analyzer = new StandardAnalyzer(Version.LUCENE_40); 
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
		config.setOpenMode(OpenMode.CREATE);
		//FSDirectory fsDir;
		int numIdexed =0;
		IndexWriter iw = null; 
		try {
			Directory fsDir = FSDirectory.open(indexDir);
			//FSDirectory fsDir = new SimpleFSDirectory(indexDir,lf);
			iw = new IndexWriter(fsDir, config); // 인덱스 생성 
			
			indexDirectory(iw, dataTargetDir);
			
			numIdexed = iw.numDocs();
			//numIdexed = new IndexWriter(fsDir, config).numDocs();
			System.out.println("Index Doc CNT :"+ numIdexed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println("here");
			e.printStackTrace();
		} finally{
			System.out.println("finish finally 구문-!");
			try {
				iw.commit();
				iw.close();
			} catch (CorruptIndexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return numIdexed;
	}
	
	private void indexDirectory(IndexWriter iw, File dir) {
		// TODO Auto-generated method stub
		File[] files = dir.listFiles();
		
		int fSize = files.length;
		for(int i=0; i < fSize; i++){
			File f = files[i];
			if(f.isDirectory()){
				indexDirectory(iw, dir); // 재귀호
			}else if(f.getName().endsWith(".scd")){
				indexFile(iw, f);
			}
		}
		
	}

	private void indexFile(IndexWriter iw, File f) {
		// TODO Auto-generated method stub
		if(f.isHidden() || !f.exists() || !f.canRead()){
			return;
		}
		//FileReader fr=null;
		try {
			System.out.println("Indexing "+ f.getCanonicalPath());
			
			Document doc = new Document();
			FileInputStream fis = null;
			try {
                fis = new FileInputStream(f);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            }
			
			BufferedReader in = new BufferedReader(new FileReader(f));
			//String target=null;
			//while((target = in.readLine()) != null){
				//System.out.println("target:"+target);
				//doc.add(new TextField("title",target, Field.Store.YES)); 
			//}
			//fr = new FileReader(f);
			//doc.add(new StringField("title","lucene", Field.Store.YES));
			doc.add(new TextField("acet", new BufferedReader(new InputStreamReader(fis, "UTF-8")), Field.Store.NO));
			//doc.add(new TextField("title", new FileReader(f), Field.Store.NO));       
			// use a string field for isbn because we don't want it tokenized
			//doc.add(new TextField("docid", fr , Field.Store.NO));
			iw.addDocument(doc);
			in.close();
			
		} catch (IOException e) {
			System.out.println("빵~~!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//System.out.println("finally here?");
			
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
		String querystr = "up";
		StandardAnalyzer anal = new StandardAnalyzer(Version.LUCENE_40);
		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query q = null;
		try {
			q = new QueryParser(Version.LUCENE_40, "acet", anal).parse(querystr);
			System.out.println("q="+q);
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			e.printStackTrace();
		}
		return q;
	}

	// step 03.
	public void search(Query q, File indexDir){
		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = null;
		ScoreDoc[] hits = null; 
		IndexSearcher searcher;
		TopScoreDocCollector collector;
		try {
			
			//File indexDir = new File(indexConfiguration.getIndexDirectory()).getCanonicalFile();
			//reader = DirectoryReader.open(index);  // index reading
			FSDirectory index = FSDirectory.open(indexDir);
			//reader = DirectoryReader.open(FSDirectory.open(indexDir));
			reader = DirectoryReader.open(index);
			
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
				//System.out.println((i + 1) + ". " + d.get("title") + "\t" + d.get("isbn"));
				System.out.println((i + 1) + ". " + d.get("acet"));
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