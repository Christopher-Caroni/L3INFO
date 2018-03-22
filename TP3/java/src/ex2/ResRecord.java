package ex2;

public class ResRecord {
	
	private byte[] data;
	int type;
	
	public ResRecord(byte[] data, int type) {
		this.data = data;
		this.type = type;
	}
	
	
	public byte[] getRData() {
		return this.data;
	}


	public int getType() {
		return type;
	}
	
	
	

}
