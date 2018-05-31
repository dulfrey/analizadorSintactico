import java.io.*;

public class Output {
	
	private static PrintWriter file;
	private static PrintWriter t_file;
	
	public Output() throws IOException {
		file = new PrintWriter(new FileWriter("source/out.txt"));
		file.print("");

		t_file = new PrintWriter(new FileWriter("source/out_tokens.txt"));
		t_file.print("");
		
	}
	
	
	public static void close() {
		file.close();
		t_file.close();
	}

	public static void error(int row, int pos) {
		file.println("Error Lexico(Linea: "+row+",Posicion: "+pos+">");
		close();
		System.exit(0);
	}
	
	
	public static void savePoint(int row, int column) {
		file.println("<token_point,"+row+","+column+">");
		t_file.println("POINT");
		Tokens.addTerminal("POINT");
	}

	public static void saveToken(String token, int row, int column) {
		file.println("<"+Tokens.get(token)+","+row+","+column+">");
		t_file.println(Tokens.get(token));
		Tokens.addTerminal(Tokens.get(token));
	}
	
	public static void save(String token, int row, int column) {
		file.println("<"+token+","+row+","+column+">");
		t_file.println(token.toUpperCase());
			Tokens.addTerminal(token.toUpperCase());
		
	}

	public static void saveIn(int row, int column) {
		file.println("<token_in"+","+row+","+column+">");
		t_file.println("IN");
		Tokens.addTerminal("IN");
	}

	public static void saveId(String token, int row, int column) {
		file.println("<id, "+token+","+row+","+column+">");
		t_file.println("ID");
		Tokens.addTerminal("ID");
	}
	
	public static void saveDouble(String token, int row, int column) {
		file.println("<token_double,"+token+","+row+","+column+">");
		t_file.println("FLOAT");
		Tokens.addTerminal("FLOAT");
	}
	
	public static void saveInt(String token, int row, int column) {
		file.println("<token_integer,"+token+","+row+","+column+">");
		t_file.println("INT");
		Tokens.addTerminal("INT");
	}
	
	public static void saveString(String cadena, int row, int column) {
		file.println("<token_string, "+"cadena"+","+row+","+column+">");
		t_file.println("STRING");
		Tokens.addTerminal("STRING");
	}

	public static void save_e(int row, int col) {
		file.println("<token_e"+","+row+","+col+">");
		t_file.println("ENUMBER");
		Tokens.addTerminal("ENUMBER");
	}
}
