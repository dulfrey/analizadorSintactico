
public class Token {
	
	int row;
	int col;
	String type;
	int value;
	
		
	public Token(String type, int row ,int col ) {
		this.row = row; 
		this.col = col; 
		this.type = type;
	}
	
	public Token(String type, int value) { 
		this.value = value; 
		this.type = type;
	}
	public Token(String type) {  
		this.type = type;
	}

	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
}
