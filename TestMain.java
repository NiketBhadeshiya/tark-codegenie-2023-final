package trainBooking;
import java.util.*;

public class TestMain {
	static ArrayList<Train> train = new ArrayList<>();
	static ArrayList<String> coach = new ArrayList<>();
	static String bookedSeats = "";
	static ArrayList<String> booked = new ArrayList<>();
//	static String[][] coach = new String
//	static 
	
	public static void Display() {
		ListIterator<Train> i = train.listIterator();
		while(i.hasNext()) {
			System.out.println(i.toString());
		}
		ListIterator<String> c = coach.listIterator();
		while(c.hasNext()) {
			System.out.println(c.next());
		}
	}
	
	public static Train findTrain(String src, String dest) {
		Train t = train.get(0);
		ListIterator<Train> i = train.listIterator();
		while(i.hasNext()) {
			t = i.next();
			if(t.getSrc().equals(src) && t.getDest().equals(dest)) {
				return t;
			}
		}
		return t;
	}
	
	public static String findCoach(String trainNo) {
//		String[] coach;
		String relativeCoach = coach.get(0);
		ListIterator<String> c = coach.listIterator();
		while(c.hasNext()) {
			String newcoach = c.next();
			if(newcoach.contains(trainNo)) {
				return newcoach;
			}
		}
		return relativeCoach;
	}
	
	public static String checkAvailabeSeats(String bookClass, String relatedCoach, int neededSeats, int distance) {
		String str = "Seat not available";
		int countSeat = 0;
		int cost = 0;
		long pnr = 100000001;
		
		int index = relatedCoach.indexOf(bookClass.substring(0,1));
		int capacity = Integer.parseInt(relatedCoach.substring(index+3 , index+5));
		for(int i = 0; i < capacity; i++) {
			String s = "";
			s = s.concat(bookClass  + "-" + (i+1));
			String localBooked = "";
			if(!bookedSeats.contains(s)) {
//				return bookClass + "-" + i;
				countSeat++;
				localBooked = localBooked.concat(s);
//				localBooked = ;
			}
			System.out.println(localBooked);
			if(countSeat == neededSeats) {
				bookedSeats = bookedSeats.concat(localBooked);
				System.out.println(bookedSeats);
				break;
			}
		}
		if(countSeat != neededSeats) {
			return str;
		}else {
			switch(bookClass) {
			
			case "SL":
				cost = distance * 1 * neededSeats;
				break;
			case "3A":
				cost = distance * 2 * neededSeats;
				break;
			case "2A":
				cost = distance * 3 * neededSeats;
				break;
			case "1A":
				cost = distance * 4 * neededSeats;
				break;
			}
			
			ListIterator<String> i = booked.listIterator();
			while(i.hasNext()) {
				pnr = pnr + 1;
//				pnr++;
				String book = i.next();
				if(book.contains(pnr+"")) {
					pnr = pnr + 1;
				}
			}
			String output = pnr + " " + cost;
			booked.add(output);
			return output;
			
		}
//		return str;
//		if(bookedSeats.contains(bookClass))
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		while(n-->0) {
			String route = in.nextLine();
			String[] input1 = route.split(" ");
			Train t = new Train(input1);
			train.add(t);
			String coachDetails = in.nextLine();
			coach.add(coachDetails);
//			String[] input2 = coachDetails.split(" ");
//			Coach[] coach = new Coach[input2.length - 1];
//			for(int i = 0; i < input2.length; i++) {
////				coach[i] = new Coach(input2[i+1]);
//				coach.add(input2[i]);
//			}
		}
		
		Boolean run = true;
		
		while(run) {
			String booking = in.nextLine();
			String[] bookingRequest = booking.split(" ");
			
			Booking b = new Booking(bookingRequest);
			System.out.println(b.getseats());
			
			Train t = findTrain(b.getSrc(), b.getDest());
			String relatedCoach = findCoach(t.getTrainNo());
			
			String bookClass = b.getBookClass();
			
			String costPerSeats = checkAvailabeSeats(bookClass, relatedCoach, b.getseats(), t.getDistance());
			System.out.println(costPerSeats);
		}
		
//		Display();
		
		
		in.close();
	}

}
