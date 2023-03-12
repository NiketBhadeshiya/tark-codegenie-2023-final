package trainBooking;

public class Booking {
	String src;
	String dest;
	String date;
	String bookClass;
	int seatsToBook;
	
	Booking(String[] input){
		this.src = input[0];
		this.dest = input[1];
		this.date = input[2];
		this.bookClass = input[3];
		this.seatsToBook = Integer.parseInt(input[4]);
	}
	
	String getSrc() {
		return this.src;
	}
	
	String getDest() {
		return this.dest;
	}
	
	String getDate() {
		return this.date;
	}
	
	String getBookClass() {
		return this.bookClass;
	}
	
	int getseats() {
		return this.seatsToBook;
	}
}
