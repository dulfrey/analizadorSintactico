
public class Word {
	private String word = "";
	private int row;
	private int column;
	private int position;
	private Boolean pos = false;
	
	public int get_row() {
		return row;
	}
	
	public int get_column() {
		return column;
	}
	

	public int get_position() {
		return position;
	}
	
	public String get_word() {
		return word;
	}
	
	public void sum(String c) {
		word+=c;
	}
	
	public void set_pos(int row, int position, int column) {
		if(pos==false) {
			this.row = row;
			this.column = column;
			this.position = position;
			pos=true;
		}
	}

}
