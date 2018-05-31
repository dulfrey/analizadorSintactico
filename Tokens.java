import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Tokens {

	public static int n_tokens;
	static ArrayList<String> keyword;
	private static Hashtable<String, String> tokensTable;
	private static Hashtable<String, String> dTokensTable;
	private static Hashtable<String, String> separators;
	private static Hashtable<String, String> operators;
	private String file_name = "tokens.txt";
	private String file_name2 = "doubletokens.txt";
	private String file_name3 = "keyword.txt";
	private String file_name4 = "separators.txt";
	private String file_name5 = "operators.txt";

	public static ArrayList<Token> syntax_pile;
	public static Token[] the_tokens;
	
	public Tokens() {
		 tokensTable = new Hashtable<String, String>();
		 dTokensTable = new Hashtable<String, String>();
		 separators = new Hashtable<String, String>();
		 operators = new Hashtable<String, String>();
		 keyword = new ArrayList<String>();
		 syntax_pile = new ArrayList<Token>();
		 n_tokens=0;
		 load_tokens();
		 load_tokens2();
		 load_tokens3();
		 load_tokens4();
		 load_tokens5();
	}
	
	private void load_tokens(){

		FileReader tokens_file = null;
		BufferedReader tokens = null;
		
		try {
			tokens_file = new FileReader("source/"+file_name);
			tokens = new BufferedReader(tokens_file);
			String linea = new String();
			
			while ((linea = tokens.readLine())!=null) {
				tokensTable.put(linea.split(" ")[0], linea.split(" ")[1]);
			}
		
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			try{                    
	            if( null != tokens_file ){   
	            	tokens_file.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	private void load_tokens2(){

		FileReader tokens_file = null;
		BufferedReader tokens = null;
		
		try {
			tokens_file = new FileReader("source/"+file_name2);
			tokens = new BufferedReader(tokens_file);
			String linea = new String();
			
			while ((linea = tokens.readLine())!=null) {
				dTokensTable.put(linea.split(" ")[0], linea.split(" ")[1]);
			}
		
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			try{                    
	            if( null != tokens_file ){   
	            	tokens_file.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	private void load_tokens3(){

		FileReader tokens_file = null;
		BufferedReader tokens = null;
		
		try {
			tokens_file = new FileReader("source/"+file_name3);
			tokens = new BufferedReader(tokens_file);
			String linea = new String();
			
			while ((linea = tokens.readLine())!=null) {
				keyword.add(linea);
			}
		
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			try{                    
	            if( null != tokens_file ){   
	            	tokens_file.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	private void load_tokens4(){

		FileReader tokens_file = null;
		BufferedReader tokens = null;
		
		try {
			tokens_file = new FileReader("source/"+file_name4);
			tokens = new BufferedReader(tokens_file);
			String linea = new String();
			
			while ((linea = tokens.readLine())!=null) {
				separators.put(linea.split(" ")[0], linea.split(" ")[1]);
			}
		
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			try{                    
	            if( null != tokens_file ){   
	            	tokens_file.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	private void load_tokens5(){

		FileReader tokens_file = null;
		BufferedReader tokens = null;
		
		try {
			tokens_file = new FileReader("source/"+file_name5);
			tokens = new BufferedReader(tokens_file);
			String linea = new String();
			
			while ((linea = tokens.readLine())!=null) {
				operators.put(linea.split(" ")[0], linea.split(" ")[1]);
			}
		
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			try{                    
	            if( null != tokens_file ){   
	            	tokens_file.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	public static String get(String token) {
		return tokensTable.get(token);
	}
	
	public static Boolean has_token(String token) {
		return tokensTable.containsKey(token);
	}
	
	public static Boolean has_dtoken(String token) {
		return dTokensTable.containsKey(token);
	}
	
	public static String getDouble(String token) {
		return dTokensTable.get(token);
	}
	public static void addTerminal(String token) {
		syntax_pile.add(new Token(token));
	}
}
