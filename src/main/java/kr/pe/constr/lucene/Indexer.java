package kr.pe.constr.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class Indexer {
	private Directory index;
	private String parsingStr;

	public Indexer(){}
	
	/**
	 * @author AceT
	 * @param indexDir
	 * @param dataTargetDir
	 * @return int
	 */
	public int index(File indexDir, File dataTargetDir) {
		// TODO Auto-generated method stub
		
		//StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
		WhitespaceAnalyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_40);
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
		config.setOpenMode(OpenMode.CREATE);
		
		int numIdexed =0;
		IndexWriter iw = null; 
		try {
			Directory fsDir = FSDirectory.open(indexDir);  // indexDir is File~!
			//FSDirectory fsDir = new SimpleFSDirectory(indexDir,lf);
			iw = new IndexWriter(fsDir, config); // 인덱스 생성(Create Index~!)
			
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
				indexDirectory(iw, dir); // 재귀호출 
			}else if(f.getName().endsWith(".scd")){
				indexFile(iw, f);
			}
		}
		
	}

	private void indexFile(IndexWriter iw, File f) {
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("<title>");
		arr.add("<contents>");
		
		
		BufferedReader in=null;
		// TODO Auto-generated method stub
		if(f.isHidden() || !f.exists() || !f.canRead()){
			return;
		}

		try {
			System.out.println("Indexing "+ f.getCanonicalPath());
			
			Document doc = new Document();
			FileInputStream fis = null;
			try {
                fis = new FileInputStream(f);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            }
			
			in = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String target=null;
			
			int cnt = 0;
			while((target = in.readLine()) != null){
				
				System.out.println(cnt+"target:"+target);
				String fieldStr = arr.get(cnt);
				//int check = target.indexOf(fieldStr);
				System.out.println("#####"+fieldStr);
				if(target.indexOf(fieldStr) >= 0){
					
					//field
					String parsingField = target.substring(0, fieldStr.length());
					
					parsingStr = target.substring(fieldStr.length());
					
					System.out.println(parsingField+"arr.size()"+arr.get(0)+"222"+arr.get(1));
					if(parsingField.equals(arr.get(0))){ // title
						doc.add(new TextField("title", parsingStr ,Field.Store.YES)); 
						cnt = 1;
						
					}else if(parsingField.equals(arr.get(1))){
						System.out.println("no match field!!");
						doc.add(new TextField("contents", parsingStr ,Field.Store.YES)); 
						cnt = 0;
					}
					
					//System.out.println(parsingField+"parsing "+ parsingStr);
				}
				
				//doc.add(new TextField("acet", target ,Field.Store.YES));  // Field.Store.YES 이녀석이 NO면 색인내용이 없다.  
																		 // 뜻 그대로 Store 여부, 단 : 2번째 param에 Reader가 들어오게 되면 Field.Store.YES를 사용할 수가 없어서 검색 결과가 나오지 않는다.
				// doc.add(new StringField("acet", target.toString(),Field.Store.YES));
				// Test : http://stackoverflow.com/questions/18862600/how-to-use-lucene-indexreader-to-read-index-in-version-4-4?newreg=c276e4f6c07a4ff1ac37b4c9e94f4ed1
				//
				
			}

			iw.addDocument(doc);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	// 색인에 추가할 데이터 Document단위로 넣어주기 
	
	/*private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
		Document doc = new Document();
		System.out.println("title->"+title+"=== isbn->"+isbn);
		doc.add(new TextField("title", title, Field.Store.YES));

		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("isbn", isbn, Field.Store.YES));
		w.addDocument(doc);
	}*/

	

}