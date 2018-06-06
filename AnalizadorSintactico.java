
/*
 * 	Gramática
 * 
 *  A -> B uno
 *  A -> dos
 *  B -> tres
 *  B -> cuatro A	
 * 
 */

public class AnalizadorSintactico {
	Token currentToken;
	Token[] tokens ;
	int indexToken = 0;
	
	private void cargarTokens() {
		currentToken = Tokens.the_tokens[0];
	}
	
	public AnalizadorSintactico() {
		cargarTokens();

		file();
		comprobarFinFichero();
	}
	
	public void comprobarFinFichero() {
		if ( this.currentToken.getType().equals("$") ) {
			System.out.println("Exito fin de fichero");
		}
		else {
			errorSintaxis(this.currentToken.getType(),"");
		}
	}





private void file() { 
	if ( this.currentToken.getType().equals("NEWLINE")  || this.currentToken.getType().equals("OTHER")  || this.currentToken.getType().equals("LOG")  || this.currentToken.getType().equals("RETORNO")  || this.currentToken.getType().equals("IMPORT")  || this.currentToken.getType().equals("FROM")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  || this.currentToken.getType().equals("IF")  || this.currentToken.getType().equals("FOR")  || this.currentToken.getType().equals("WHILE")  || this.currentToken.getType().equals("FUNCION")  || this.currentToken.getType().equals("EOF")  ) { 
		file_a();
		emparejar("EOF");
	}
	else {
		errorSintaxis(this.currentToken.getType(),"");
	}
}
private void file_a() { 
	if ( this.currentToken.getType().equals("OTHER")  || this.currentToken.getType().equals("LOG")  || this.currentToken.getType().equals("RETORNO")  || this.currentToken.getType().equals("IMPORT")  || this.currentToken.getType().equals("FROM")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  || this.currentToken.getType().equals("IF")  || this.currentToken.getType().equals("FOR")  || this.currentToken.getType().equals("WHILE")  || this.currentToken.getType().equals("FUNCION")  ) { 
		stat();
		file_a();
	}
	else if ( this.currentToken.getType().equals("NEWLINE")  ) { 
		emparejar("NEWLINE");
		file_a();
	}
	else if ( this.currentToken.getType().equals("EOF")  ) { 
		
	}
}
private void stat() { 
	if ( this.currentToken.getType().equals("OTHER")  || this.currentToken.getType().equals("LOG")  || this.currentToken.getType().equals("RETORNO")  || this.currentToken.getType().equals("IMPORT")  || this.currentToken.getType().equals("FROM")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  ) { 
		simple_stat();
	}
	else if ( this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  ) { 
		complex_stat();
	}
}
private void complex_stat() { 
	if ( this.currentToken.getType().equals("IF")  ) { 
		if_stat();
	}
	else if ( this.currentToken.getType().equals("WHILE")  ) { 
		while_stat();
	}
	else if ( this.currentToken.getType().equals("FOR")  ) { 
		for_stat();
	}
	else if ( this.currentToken.getType().equals("FUNCION")  ) { 
		funcion();
	}
}
private void simple_stat() { 
	if ( this.currentToken.getType().equals("LOG")  ) { 
		log();
	}
	else if ( this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  ) { 
		importar();
	}
	else if ( this.currentToken.getType().equals("RETORNO")  ) { 
		retornar();
	}
	else if ( this.currentToken.getType().equals("OTHER")  ) { 
		emparejar("OTHER");
	}
	else if ( this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  ) { 
		atom();
		
	}
}
private void assignment() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		variable();
		emparejar("ASSIGN");
		expr();
	}
}
private void if_stat() { 
	if ( this.currentToken.getType().equals("IF")  ) { 
		emparejar("IF");
		condition_block();
		else_if_r();
		else_r();
	}
}
private void else_if_r() { 
	if ( this.currentToken.getType().equals("ELSE")  ) { 
		emparejar("ELSE");
		emparejar("IF");
		condition_block();
		else_if_r();
	}
	else if ( this.currentToken.getType().equals("ELSE")  
|| this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("CBRACE")  
|| this.currentToken.getType().equals("END")  
|| this.currentToken.getType().equals("EOF")  ) { 
		
	}
}
private void else_r() { 
	if ( this.currentToken.getType().equals("ELSE")  ) { 
		emparejar("ELSE");
		stat_block();
	}
	else if ( this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("CBRACE")  
|| this.currentToken.getType().equals("END")  
|| this.currentToken.getType().equals("EOF")  ) { 
		
	}
}
private void while_stat() { 
	if ( this.currentToken.getType().equals("WHILE")  ) { 
		emparejar("WHILE");
		expr();
		stat_block();
	}
}
private void for_stat() { 
	if ( this.currentToken.getType().equals("FOR")  ) { 
		emparejar("FOR");
		emparejar("ID");
		emparejar("IN");
		expr();
		stat_block();
	}
}
private void log() { 
	if ( this.currentToken.getType().equals("LOG")  ) { 
		emparejar("LOG");
		emparejar("OPAR");
		expr();
		emparejar("CPAR");
	}
}
private void funcion() { 
	if ( this.currentToken.getType().equals("FUNCION")  ) { 
		emparejar("FUNCION");
		emparejar("ID");
		emparejar("OPAR");
		f_para_a();
		emparejar("CPAR");
		f_more();
		emparejar("END");
	}
}
private void f_more() { 
	if ( this.currentToken.getType().equals("NEWLINE")  ) { 
		emparejar("NEWLINE");
		f_more();
	}
	else if ( this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  ) { 
		stat();
		f_more();
	}
	else if ( this.currentToken.getType().equals("END")  ) { 
		
	}
}
private void f_para_a() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		parameter();
		f_para_b();
	}
	else if ( this.currentToken.getType().equals("CPAR")  ) { 
		
	}
}
private void f_para_b() { 
	if ( this.currentToken.getType().equals("COMMA")  ) { 
		emparejar("COMMA");
		parameter();
		f_para_b();
	}
	else if ( this.currentToken.getType().equals("CPAR")  ) { 
		
	}
}
private void importar() { 
	if ( this.currentToken.getType().equals("IMPORT")  ) { 
		emparejar("IMPORT");
		emparejar("ID");
		id_sub();
	}
	else if ( this.currentToken.getType().equals("FROM")  ) { 
		emparejar("FROM");
		emparejar("ID");
		emparejar("IMPORT");
		emparejar("ID");
	}
}
private void id_sub() { 
	if ( this.currentToken.getType().equals("POINT")  ) { 
		emparejar("POINT");
		emparejar("ID");
		id_sub();
	}
	else if ( this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OPAR")  
|| this.currentToken.getType().equals("ASSIGN")  
|| this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("CBRACE")  
|| this.currentToken.getType().equals("END")  
|| this.currentToken.getType().equals("EOF")  
|| this.currentToken.getType().equals("POW")  
|| this.currentToken.getType().equals("MULT")  
|| this.currentToken.getType().equals("DIV")  
|| this.currentToken.getType().equals("MOD")  
|| this.currentToken.getType().equals("PLUS")  
|| this.currentToken.getType().equals("MINUS")  
|| this.currentToken.getType().equals("LTEG")  
|| this.currentToken.getType().equals("GTEG")  
|| this.currentToken.getType().equals("LT")  
|| this.currentToken.getType().equals("GT")  
|| this.currentToken.getType().equals("EQ")  
|| this.currentToken.getType().equals("NEQ")  
|| this.currentToken.getType().equals("AND")  
|| this.currentToken.getType().equals("OR")  
|| this.currentToken.getType().equals("CPAR")  
|| this.currentToken.getType().equals("COMMA")  
|| this.currentToken.getType().equals("CKEY")  ) { 
		
	}
}
private void retornar() { 
	if ( this.currentToken.getType().equals("RETORNO")  ) { 
		emparejar("RETORNO");
		emparejar("OPAR");
		expr();
		emparejar("CPAR");
		emparejar("NEWLINE");
	}
}
private void condition_block() { 
	if ( this.currentToken.getType().equals("OPAR")  || this.currentToken.getType().equals("MINUS")  || this.currentToken.getType().equals("NOT")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  ) { 
		expr();
		c_block_a();
		stat_block();
	}
}
private void c_block_a() { 
	if ( this.currentToken.getType().equals("NEWLINE")  ) { 
		emparejar("NEWLINE");
	}
	else if ( this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  ) { 
		
	}
}
private void stat_block() { 
	if ( this.currentToken.getType().equals("OBRACE")  ) { 
		emparejar("OBRACE");
		s_block_a();
		emparejar("CBRACE");
	}
	else if ( this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  ) { 
		stat();
		emparejar("NEWLINE");
	}
}
private void s_block_a() { 
	if ( this.currentToken.getType().equals("OTHER")  || this.currentToken.getType().equals("LOG")  || this.currentToken.getType().equals("RETORNO")  || this.currentToken.getType().equals("IMPORT")  || this.currentToken.getType().equals("FROM")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  || this.currentToken.getType().equals("IF")  || this.currentToken.getType().equals("FOR")  || this.currentToken.getType().equals("WHILE")  || this.currentToken.getType().equals("FUNCION")  ) { 
		stat();
		s_block_a();
	}
	else if ( this.currentToken.getType().equals("NEWLINE")  ) { 
		emparejar("NEWLINE");
		s_block_a();
	}
	else if ( this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void array() { 
	if ( this.currentToken.getType().equals("OKEY")  ) { 
		emparejar("OKEY");
		array_a();
		emparejar("CKEY");
	}
}
private void array_a() { 
	if ( this.currentToken.getType().equals("OPAR")  || this.currentToken.getType().equals("MINUS")  || this.currentToken.getType().equals("NOT")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  ) { 
		expr();
		array_b();
	}
	else if ( this.currentToken.getType().equals("CKEY")  ) { 
		
	}
}
private void array_b() { 
	if ( this.currentToken.getType().equals("COMMA")  ) { 
		emparejar("COMMA");
		expr();
		array_b();
	}
	else if ( this.currentToken.getType().equals("CPAR")  
|| this.currentToken.getType().equals("CKEY")  ) { 
		
	}
}
private void accessarray() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		variable();
		emparejar("OKEY");
		expr();
		emparejar("CKEY");
	}
}
private void variable() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		emparejar("ID");
		id_sub();
		var_a();
	}
}
private void var_a() { 
	if ( this.currentToken.getType().equals("OPAR")  ) { 
		var_b();
	}
	else if ( this.currentToken.getType().equals("OKEY")  ) { 
		emparejar("OKEY");
		expr();
		emparejar("CKEY");
	}
	else if ( this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("ASSIGN")  
|| this.currentToken.getType().equals("POW")  
|| this.currentToken.getType().equals("MULT")  
|| this.currentToken.getType().equals("DIV")  
|| this.currentToken.getType().equals("MOD")  
|| this.currentToken.getType().equals("PLUS")  
|| this.currentToken.getType().equals("MINUS")  
|| this.currentToken.getType().equals("LTEG")  
|| this.currentToken.getType().equals("GTEG")  
|| this.currentToken.getType().equals("LT")  
|| this.currentToken.getType().equals("GT")  
|| this.currentToken.getType().equals("EQ")  
|| this.currentToken.getType().equals("NEQ")  
|| this.currentToken.getType().equals("AND")  
|| this.currentToken.getType().equals("OR")  
|| this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("CPAR")  
|| this.currentToken.getType().equals("COMMA")  
|| this.currentToken.getType().equals("CKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void var_b() { 
	if ( this.currentToken.getType().equals("OPAR")  ) { 
		emparejar("OPAR");
		var_c();
		emparejar("CPAR");
	}
	else if ( this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("ASSIGN")  
|| this.currentToken.getType().equals("POW")  
|| this.currentToken.getType().equals("MULT")  
|| this.currentToken.getType().equals("DIV")  
|| this.currentToken.getType().equals("MOD")  
|| this.currentToken.getType().equals("PLUS")  
|| this.currentToken.getType().equals("MINUS")  
|| this.currentToken.getType().equals("LTEG")  
|| this.currentToken.getType().equals("GTEG")  
|| this.currentToken.getType().equals("LT")  
|| this.currentToken.getType().equals("GT")  
|| this.currentToken.getType().equals("EQ")  
|| this.currentToken.getType().equals("NEQ")  
|| this.currentToken.getType().equals("AND")  
|| this.currentToken.getType().equals("OR")  
|| this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("CPAR")  
|| this.currentToken.getType().equals("COMMA")  
|| this.currentToken.getType().equals("CKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void var_c() { 
	if ( this.currentToken.getType().equals("OPAR")  || this.currentToken.getType().equals("MINUS")  || this.currentToken.getType().equals("NOT")  || this.currentToken.getType().equals("INT")  || this.currentToken.getType().equals("FLOAT")  || this.currentToken.getType().equals("TRUE")  || this.currentToken.getType().equals("FALSE")  || this.currentToken.getType().equals("STRING")  || this.currentToken.getType().equals("OKEY")  || this.currentToken.getType().equals("OBRACE")  || this.currentToken.getType().equals("ID")  ) { 
		expr();
		array_b();
	}
	else if ( this.currentToken.getType().equals("CPAR")  ) { 
		
	}
}
private void parameter() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		emparejar("ID");
		par_a();
	}
}
private void par_a() { 
	if ( this.currentToken.getType().equals("ASSIGN")  ) { 
		emparejar("ASSIGN");
		expr();
	}
	else if ( this.currentToken.getType().equals("COMMA")  
|| this.currentToken.getType().equals("CPAR")  ) { 
		
	}
}
private void expr() { 
	if ( this.currentToken.getType().equals("MINUS")  || this.currentToken.getType().equals("NOT")  ) { 
		op_u();
		expr();
		expr_a();
	}
	else if ( this.currentToken.getType().equals("OPAR")  ) { 
		emparejar("OPAR");
		expr();
		emparejar("CPAR");
		expr_a();
	}
	else if ( this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("ID")  ) { 
		atom();
		expr_a();
	}
}
private void expr_a() { 
	if ( this.currentToken.getType().equals("POW")  ) { 
		emparejar("POW");
		expr();
	}
	else if ( this.currentToken.getType().equals("MULT")  
|| this.currentToken.getType().equals("DIV")  
|| this.currentToken.getType().equals("MOD")  
|| this.currentToken.getType().equals("PLUS")  
|| this.currentToken.getType().equals("MINUS")  
|| this.currentToken.getType().equals("LTEG")  
|| this.currentToken.getType().equals("GTEG")  
|| this.currentToken.getType().equals("LT")  
|| this.currentToken.getType().equals("GT")  
|| this.currentToken.getType().equals("EQ")  
|| this.currentToken.getType().equals("NEQ")  
|| this.currentToken.getType().equals("AND")  
|| this.currentToken.getType().equals("OR")  
|| this.currentToken.getType().equals("ASSIGN")  ) { 
		op();
		expr();
	}
	else if ( this.currentToken.getType().equals("POW")  
|| this.currentToken.getType().equals("MULT")  
|| this.currentToken.getType().equals("DIV")  
|| this.currentToken.getType().equals("MOD")  
|| this.currentToken.getType().equals("PLUS")  
|| this.currentToken.getType().equals("MINUS")  
|| this.currentToken.getType().equals("LTEG")  
|| this.currentToken.getType().equals("GTEG")  
|| this.currentToken.getType().equals("LT")  
|| this.currentToken.getType().equals("GT")  
|| this.currentToken.getType().equals("EQ")  
|| this.currentToken.getType().equals("NEQ")  
|| this.currentToken.getType().equals("AND")  
|| this.currentToken.getType().equals("OR")  
|| this.currentToken.getType().equals("ASSIGN")  
|| this.currentToken.getType().equals("CPAR")  
|| this.currentToken.getType().equals("COMMA")  
|| this.currentToken.getType().equals("CKEY")  
|| this.currentToken.getType().equals("OBRACE")  
|| this.currentToken.getType().equals("OTHER")  
|| this.currentToken.getType().equals("LOG")  
|| this.currentToken.getType().equals("RETORNO")  
|| this.currentToken.getType().equals("IMPORT")  
|| this.currentToken.getType().equals("FROM")  
|| this.currentToken.getType().equals("INT")  
|| this.currentToken.getType().equals("FLOAT")  
|| this.currentToken.getType().equals("TRUE")  
|| this.currentToken.getType().equals("FALSE")  
|| this.currentToken.getType().equals("STRING")  
|| this.currentToken.getType().equals("OKEY")  
|| this.currentToken.getType().equals("ID")  
|| this.currentToken.getType().equals("IF")  
|| this.currentToken.getType().equals("FOR")  
|| this.currentToken.getType().equals("WHILE")  
|| this.currentToken.getType().equals("FUNCION")  
|| this.currentToken.getType().equals("NEWLINE")  
|| this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void atom() { 
	if ( this.currentToken.getType().equals("INT")  ) { 
		emparejar("INT");
	}
	else if ( this.currentToken.getType().equals("FLOAT")  ) { 
		emparejar("FLOAT");
	}
	else if ( this.currentToken.getType().equals("TRUE")  ) { 
		emparejar("TRUE");
	}
	else if ( this.currentToken.getType().equals("FALSE")  ) { 
		emparejar("FALSE");
	}
	else if ( this.currentToken.getType().equals("STRING")  ) { 
		emparejar("STRING");
	}
	else if ( this.currentToken.getType().equals("OKEY")  ) { 
		array();
	}
	else if ( this.currentToken.getType().equals("OBRACE")  ) { 
		objeto();
	}
	else if ( this.currentToken.getType().equals("ID")  ) { 
		variable();
	}
	else if ( this.currentToken.getType().equals("ID")  ) { 
		accessarray();
	}
	
}
private void objeto() { 
	if ( this.currentToken.getType().equals("OBRACE")  ) { 
		emparejar("OBRACE");
		obj_a();
		emparejar("CBRACE");
	}
}
private void obj_a() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		keyvalue();
		obj_b();
	}
	else if ( this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void obj_b() { 
	if ( this.currentToken.getType().equals("COMMA")  ) { 
		emparejar("COMMA");
		keyvalue();
		obj_b();
	}
	else if ( this.currentToken.getType().equals("CBRACE")  ) { 
		
	}
}
private void keyvalue() { 
	if ( this.currentToken.getType().equals("ID")  ) { 
		emparejar("ID");
		emparejar("POINTS");
		expr();
	}
}
private void op_u() { 
	if ( this.currentToken.getType().equals("MINUS")  ) { 
		emparejar("MINUS");
	}
	else if ( this.currentToken.getType().equals("NOT")  ) { 
		emparejar("NOT");
	}
}
private void op() { 
	if ( this.currentToken.getType().equals("MULT")  ) { 
		emparejar("MULT");
	}
	else if ( this.currentToken.getType().equals("DIV")  ) { 
		emparejar("DIV");
	}
	else if ( this.currentToken.getType().equals("MOD")  ) { 
		emparejar("MOD");
	}
	else if ( this.currentToken.getType().equals("PLUS")  ) { 
		emparejar("PLUS");
	}
	else if ( this.currentToken.getType().equals("MINUS")  ) { 
		emparejar("MINUS");
	}
	else if ( this.currentToken.getType().equals("LTEG")  ) { 
		emparejar("LTEG");
	}
	else if ( this.currentToken.getType().equals("GTEG")  ) { 
		emparejar("GTEG");
	}
	else if ( this.currentToken.getType().equals("LT")  ) { 
		emparejar("LT");
	}
	else if ( this.currentToken.getType().equals("GT")  ) { 
		emparejar("GT");
	}
	else if ( this.currentToken.getType().equals("EQ")  ) { 
		emparejar("EQ");
	}
	else if ( this.currentToken.getType().equals("NEQ")  ) { 
		emparejar("NEQ");
	}
	else if ( this.currentToken.getType().equals("AND")  ) { 
		emparejar("AND");
	}
	else if ( this.currentToken.getType().equals("OR")  ) { 
		emparejar("OR");
	}
	else if ( this.currentToken.getType().equals("ASSIGN")  ) { 
		emparejar("ASSIGN");
	}
}

	
	public final void emparejar(String tokEsperado)
	{
		//Token dado -> token esperado
		System.out.println(currentToken.getType()+" -> "+tokEsperado);
		try {
			if (currentToken.getType().equals(tokEsperado)) {
				currentToken = getNextToken();
			}
			else 
				errorSintaxis(currentToken.getType(),tokEsperado);
		}catch(Exception e) {
			System.out.println("Error de sintasis ");
		}

	}
	
	private void errorSintaxis(String tokDado,String tokEsperado) {
		System.out.println( "Error! Token no esperado: " + tokDado);
		System.out.println( "Se esperaba:" + tokEsperado);
		System.exit(0);
		
	}
	
	private Token getNextToken() {
		if (indexToken == Tokens.the_tokens.length-1) {
			return null;
		}
		indexToken++;
		this.currentToken = Tokens.the_tokens[indexToken];
		return currentToken;
	}

}
