package trainBooking;
import java.util.*;

public class TestMain {
	static ArrayList<Train> train = new ArrayList<>();
	static ArrayList<String> coach = new ArrayList<>();
//	static ArrayList<String> bookedSeats = new ArrayList<>();
	static String bookedSeats = "";
	static ArrayList<String> booked = new ArrayList<>();
	static Map<String, String> map = new HashMap<>();
//	static String[][] coach = new String
//	static 
	
	public static void setClass() {
//		ListIterator<String> c = coach.listIterator();
//		while(c.hasNext()) {
//			String[] newc = c.next().split(" ");
////			String[] coachDetails = coach.
//			
//			
//		}
//		
		map.put("SL", "S");
		map.put("3A", "B");
		map.put("2A", "A");
		map.put("1A", "H");
	}
	
	public static Train findTrain(String src, String dest) {
		Boolean found  = false;
		Train t = train.get(0);
		ListIterator<Train> i = train.listIterator();
		while(i.hasNext()) {
			t = i.next();
			if(t.getSrc().equals(src) && t.getDest().equals(dest)) {
				found = true;
				return t;
			}
		}
		if(found == false) {
			System.out.println("No Trains Available");
//			return false;
		}
		return t;
	}
	
	public static String findCoach(String trainNo, String bookClass) {
//		String[] coach;
		Boolean found = false;
		String relativeCoach = coach.get(0);
		ListIterator<String> c = coach.listIterator();
		while(c.hasNext()) {
			String newcoach = c.next();
			if(newcoach.contains(trainNo) && newcoach.contains(map.get(bookClass))) {
				found = true;
				relativeCoach = newcoach;
			}
		}
		if(found == true) {
			return relativeCoach;			
		}
		return "No Seats Available";
	}
	
	public static String checkAvailabeSeats(Booking b, String relatedCoach, int neededSeats, int distance) {
		String str = "No Seats Available";
		int countSeat = 0;
		int cost = 0;
		long pnr = 1000000001;
		Iterator<String> i = booked.listIterator();
		while(i.hasNext()) {
			String[] s = i.next().split(" ");
			pnr = Long.parseLong(s[0]);
		}
		String bookClass = b.bookClass;
		
		String bookclass = map.get(bookClass);
//		System.out.println(bookclass);
		
		int index = relatedCoach.indexOf(bookclass);
		int lastindex = relatedCoach.lastIndexOf(bookclass);
//		String coachSplit = relatedCoach.split(" ");
//		int capacity = Integer.parseInt(relatedCoach.substring(index+3 , index+5));
//		System.out.println(capacity);
		
//		ListIterator<String> bIterator = bookedSeats.listIterator();
//		String localBooked = b.getDate().concat(" ");
//		
//		while(bIterator.hasNext()) {
//			
//			String seat = bIterator.next();
//			
//			if(seat.contains(b.getDate())) {
//				localBooked = b.getDate().concat(" ");
//				
//				for(int i = 0; i < capacity; i++) {
//					String s = bookclass;
//					s = s.concat("-" + (i+1));
//					if(!bIterator.equals(s)) {
////						return bookClass + "-" + i;
//						countSeat++;
//						localBooked = localBooked.concat(s + " ");
//					}
//					
////					System.out.println(localBooked);
//					if(countSeat == neededSeats) {
//						System.out.println(localBooked);
//						break;
//					}
//				}
//				if(countSeat != neededSeats) {
//					return str;
//				}else {
//					switch(bookClass) {
//					
//					case "SL":
//						cost = distance * 1 * neededSeats;
//						break;
//					case "3A":
//						cost = distance * 2 * neededSeats;
//						break;
//					case "2A":
//						cost = distance * 3 * neededSeats;
//						break;
//					case "1A":
//						cost = distance * 4 * neededSeats;
//						break;
//					}
//					
//					ListIterator<String> i = booked.listIterator();
//					while(i.hasNext()) {
//						pnr = pnr + 1;
////						pnr++;
//						String book = i.next();
//						if(book.contains(pnr+"")) {
//							pnr = pnr + 1;
//						}
//					}
//					String output = pnr + " " + cost;
//					booked.add(output);
//					return output;
//					
//				}
//				
//			}
//			
//		}
		
		int capacity = Integer.parseInt(relatedCoach.substring(index + 3 , index + 5));
		int capacity2 = Integer.parseInt(relatedCoach.substring(lastindex + 3 , lastindex + 5));
		
		capacity = capacity + capacity2;
//		System.out.println(capacity);
		
//		System.out.println(capacity);
		
		String localBooked = b.getDate().concat(" "+b.getSrc()+" "+b.getDest());
		for(int j = 0; j < capacity; j++) {
			String s = bookclass;
			s = s.concat("-" + (j+1));
			if(!bookedSeats.contains(s) || !bookedSeats.contains(b.getDate() +" "+b.getSrc()+" "+b.getDest())) {
//				return bookClass + "-" + i;
				countSeat++;
				localBooked = localBooked.concat(s + " ");
			}
			
//			System.out.println(localBooked);
			if(countSeat == neededSeats) {
				bookedSeats = bookedSeats.concat(localBooked);
//				System.out.println(bookedSeats);
				break;
			}
		}
//		System.out.println(countSeat + " " + neededSeats);
		if(countSeat < neededSeats) {
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
			
			ListIterator<String> bookedIterator = booked.listIterator();
			while(bookedIterator.hasNext()) {
//				pnr = pnr + 1;
//				pnr++;
				String book = bookedIterator.next();
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
		setClass();
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
//			System.out.println(b.getseats());
			
			ListIterator<Train> i = train.listIterator();
			Train t;
			Boolean found = false;
			while(i.hasNext()) {
				t = i.next();
				if(t.getSrc().equals(b.getSrc()) && t.getDest().equals(b.getDest())) {
					found = true;
				}
			}
			if(found == true) {
				t = findTrain(b.getSrc(), b.getDest());
				
				String relatedCoach = findCoach(t.getTrainNo(), b.getBookClass());
				if(!relatedCoach.equals("No Seats Available")) {
					
					String bookClass = b.getBookClass();
					
					String costPerSeats = checkAvailabeSeats(b, relatedCoach, b.getseats(), t.getDistance());
					System.out.println(costPerSeats);
					
					
				} else {
					System.out.println(relatedCoach);
				}
				
				
			} else {
				System.out.println("No Train Available");
			}
			
		}
		
//		Display();
		
		
		in.close();
	}

}
