
public final class Result {
    private final boolean first;
    private final int second;

    public Result(boolean first, int second) {
        this.first = first;
        this.second = second;
    }
    
    public Result(boolean first) {
        this.first = first;
        this.second = 0;
    }

	public boolean getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}
    
    
}
