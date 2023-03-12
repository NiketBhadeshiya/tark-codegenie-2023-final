package trainBooking;

public class Train {

	private String trainNo;
	private String src;
	private String dest;
	private int distance;
	
	public Train(String[] input) {
		this.trainNo = input[0];
		int indexOfSrc = input[1].indexOf('-');
		this.src = input[1].substring(0, indexOfSrc);
		int indexofDest = input[2].indexOf('-');
		this.dest = input[2].substring(0, indexofDest);	
		this.distance = Integer.parseInt(input[2].substring(indexofDest+1));
	}
	
	public String getTrainNo() {
		return this.trainNo;
	}
	
	public String getSrc() {
		return this.src;
	}
	
	public String getDest() {
		return this.dest;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public String toStrin() {
		return this.trainNo + " " + this.src + " " +this.dest + " " + this.distance;
	}
	
}
