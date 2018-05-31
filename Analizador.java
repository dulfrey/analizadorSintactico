import java.io.*;
import java.util.*;


//Problema numero linea a=-3

public class Analizador {
	
	public static Result isIdentifier(String word) {
		Boolean a_letter = false;
		
		for(int i = 0; i<word.length();i++) {
			char c = word.charAt(i);
			if((c>='a'&&c<='z') || (c>='0'&&c<='9' || (c>='A'&&c<='Z'))) {
				if((c>='a'&&c<='z')|| (c>='A'&&c<='Z')) {
					a_letter=true;
				}
				continue;
			}
			if(isIdentifier(word.substring(0, i)).getFirst()) {
				return new Result(true,i);
			}else {
				return new Result(false,0);
			}
		}
		if(a_letter) {
			return new Result(true,0);
		}
		return new Result(false,0);
	}

	public static Result isDouble(String word) {
		
		Boolean a_point = false;
		
		for(int i = 0; i<word.length();i++) {
			char c = word.charAt(i);
			
			if(c=='.' || (c>='0'&&c<='9')) {
				if(c=='.'&&!a_point) {
					a_point=true;
				}else if(c=='.'&&a_point) {
					if(i>1) {
						return new Result(true,i);
					}else {
						return new Result(false);
					}
				}
				continue;
			}
			if(a_point&&i>1) {
				return new Result(true,i);
			}
				return new Result(false);  //Original
		}
		if(a_point) {
			if(word.endsWith(".")) {
				return new Result(false);
			}
			return new Result(true);
		}
		return new Result(false);
	}
	
	
	
	public static Result isInt(String word) {
		
		boolean aNumber = false;
		
		for(int i = 0; i<word.length();i++) {
			char c = word.charAt(i);
			
			if(c>='0'&&c<='9') {
				aNumber = true;
				continue;
			}
			
			if(aNumber) {
				return new Result(true,i);
			}
			return new Result(false,0);
		}
		
		return new Result(true,0);
	}
	

	public static void wCase(String word, int r, int p, int c) {
		int row = r;
		int col = c;
		int pos = p;
		String text = word;
		Boolean exit = false;
		Result result;

		if(text.equals("")) {
			exit=true;
		}
		
		
		if(text.startsWith("in")) {
			Output.saveIn(row, col);
			if(!text.equals("in")) {
				Output.error(row, pos+2);
			}
			exit=true;
		}
		
		if(text.equals("e")) {
			Output.save_e(row, col);
			exit=true;
		}
		
		if(!exit) {
			for(String w:Tokens.keyword) {     //Revisa si es una palabra reservada
				if(text.startsWith(w)){
					Output.save(w, row, col);
					if(!text.equals(w)) {
						Output.error(row, pos+w.length());
					}
					exit=true;
					break;
				}
			}
		}
		
		
		result = isIdentifier(text);
		if(result.getFirst()&&!exit) {   //Revisa si es un identificador
			if(result.getSecond()>0) {
				Output.saveId(text.substring(0,result.getSecond()), row, col);
				String temp = text.substring(result.getSecond());
				if(temp.charAt(0)=='.'&&isIdentifier(temp.substring(1)).getFirst()) {
					col++;
					Output.savePoint(row, col);
					wCase(temp.substring(1),row,pos+result.getSecond()+1,col+1);
				}else {
					Output.error(row, pos+result.getSecond());
				}
				
			}else {
				Output.saveId(text, row, col);
			}
			exit = true;
		}
		
		
		result = isDouble(text);
		if(result.getFirst()&&!exit) {   //Revisa si es un decimal
			if(result.getSecond()>0) {
				Output.saveDouble(text.substring(0,result.getSecond()), row, col);
				if(isIdentifier(text.substring(result.getSecond())).getFirst()) {
					wCase(text.substring(result.getSecond()),row,pos+result.getSecond(),col+1);
				}else {
					Output.error(row, pos+result.getSecond());
				}
			}else {
				Output.saveDouble(text, row, col);
			}
			exit = true;
		}
		
		
		result = isInt(text);
		if(result.getFirst()&&!exit) {   //Revisa si es un numero
			if(result.getSecond()>0) {
				Output.saveInt(text.substring(0,result.getSecond() ), row, col);
				wCase(text.substring(result.getSecond()),row,pos+result.getSecond(),col+1);
			}else {
				Output.saveInt(text, row, col);
			}
			exit = true;
		}
		
		/*if(text.charAt(1)=='.'&&!exit) {
			Output.savePoint(row, col);
			exit = true;
		}*/
		
		
		if(!exit) {
			Output.error(row, pos);
		}
		
	}
	
	
	public static void analysis(ArrayList<String> file) {

		for(String line:file) {   //Por cada linea

			int row = file.indexOf(line)+1;
			int column = 1;
			Word word = new Word();
			Boolean svar = false;

			for(int p=0;p<line.length();p++) {  //Revisar uno por uno los caracteres de la linea
				
				String c = line.substring(p, p+1);
				
				if(c.equals(" ")&&!svar) {  //Espacio antes de una palabra
					column++;
					continue;
				}else if(Tokens.has_token(c)||Tokens.has_dtoken(c)||(c.equals(" ")&&svar)) {
					wCase(word.get_word(),word.get_row(),word.get_position(),word.get_column());
					
					if(!word.get_word().equals(""))
						column++;
					
					if(c.equals("#")) {
						Output.saveToken(c, row, column);
						break;
					}
					
					if(Tokens.has_dtoken(c)&&p+2<line.length()) {
						String dt = line.substring(p,p+2);
						if(Tokens.has_token(dt)) {
							Output.saveToken(dt, row, column);
							p++;
							word=new Word();
							svar = false;
							column++;
							continue;
							
						}else if(c.equals("&")||c.equals("|")) {
							Output.error(row, column);
						}
					}
					
					if(!c.equals(" ")){
						if(Tokens.has_token(c)) {
							Output.saveToken(c, row, column);
						}else {
							Output.error(row, p+1);
						}
					}
					
					if(c.equals(".")) {
						Output.savePoint(row, column);
					}
					
					word=new Word();
					svar = false;
					column++;
					continue;
					
				}else if(c.equals("\"")) {
					String text = line.substring(p+1);
					
					if(text.split("\"").length==1&&!(text.split("\"")[0].length()==text.length()-1)){
						Output.error(row, p+text.length()+2);
					}else {
						Output.saveString(text.split("\"")[0], row, column);
					}
					
					p+=text.split("\"")[0].length()+1;
					word=new Word();
					svar = false;
					continue;
				}else if(p+1==line.length()) {
					word.set_pos(row, p+1, column);
					word.sum(c);
					wCase(word.get_word(),word.get_row(),word.get_position(),word.get_column());
				}

				//System.out.println(c);
				word.sum(c);
				word.set_pos(row, p+1, column);
				svar=true;
			}
			if(file.indexOf(line)<file.size()-1) {
				Tokens.addTerminal("NEWLINE");
				Output.sav("NEWLINE");
			}
		}

		Tokens.addTerminal("EOF");
		Output.sav("EOF");
		Tokens.addTerminal("$");

		Tokens.the_tokens = new Token[Tokens.syntax_pile.size()];
		for (int i = 0; i < Tokens.the_tokens.length; i++) {
			Tokens.the_tokens[i]=Tokens.syntax_pile.get(i);
		}

		/*for (int i = 0; i < Tokens.the_tokens.length; i++) {
			System.out.println(Tokens.the_tokens[i].type);
		}*/
		
		new AnalizadorSintactico();
	}

	
	public static void main(String[] args) throws IOException{
		
		new Global();
		new Output();
		new Tokens();
		
		
		//read files
		FileReader file = new FileReader("source/"+Global.in_file);
		BufferedReader code = new BufferedReader(file);
		
		
		String textline = null;
		ArrayList<String> all_file = new ArrayList<String>();
		
		while ((textline = code.readLine())!=null) {
			all_file.add(textline);
		}
		
		try{                    
            if( null != file ){   
            	file.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
		
		analysis(all_file);
		
		Output.close();
		
	}

	
}


