import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patron {
	
	List<Patron> patron = new ArrayList<Patron>();
	
	public String firstName, lastName;
	public int patronID;
	public boolean overDue;
	public float fine;
	Tracker tr = new Tracker();
	
	public Patron(String firstName, String lastName, int patronID, boolean overDue, float fine) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronID = patronID;
		this.overDue = overDue;
		this.fine = fine;
	}
	
	public Patron() {
		
	}
	
	//modifies toString to print out object
	public String toString() {
		String patron = "\n" + firstName + " " + lastName + ", " + patronID +", " +overDue + ", " + fine ;
		return patron;
	}
	
	//prints all patrons in patron database
	public void getPatron() {
	for(int i = 0; i < tr.patronFirstName.size(); i ++) {
			patron.add(new Patron(getFirstName(i), getLastName(i), getPatronID(i), getBookOverdue(i), getFine(i)));
		}
		
		printPatrons();
		
	}
	
	//check out process for patrons 
	public void checkOut() {
		getPatron();
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		for(int i = 0; i < patron.size(); i++) {
			System.out.println(patron.get(i).firstName);
			if(patron.get(i).firstName.equals(inputName)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		
	}
	
	//print patrons
	public void printPatrons() {
		for(int i = 0; i < patron.size(); i++) {
			System.out.println(patron.get(i));
		}
	}
	
	public String getFirstName(int i) {
		return tr.patronFirstName.get(i);
	}
	
	public String getLastName(int i) {
		return tr.patronLastName.get(i);
	}
	
	public int getPatronID(int i) {
		return tr.patronID.get(i);
	}
	
	public boolean getBookOverdue(int i) {
		return tr.hasBookOverdue.get(i);
	}
	
	public float getFine(int i) {
		return tr.fine.get(i);
	}
	
}
