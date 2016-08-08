import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tracker {

	//books
	public List<String> names = new ArrayList<String>();
	public List<String> firstName = new ArrayList<String>();
	public List<String> lastName = new ArrayList<String>();
	public List<Integer> pageNumbers = new ArrayList<Integer>();
	public List<Boolean> checkedOut = new ArrayList<Boolean>();
	public List<Integer> ISBN = new ArrayList<Integer>();
	public List<String> due = new ArrayList<String>();
	
	//people
	public List<String> patronFirstName = new ArrayList<String>();
	public List<String> patronLastName = new ArrayList<String>();
	public List<Integer> patronID = new ArrayList<Integer>();
	public List<Boolean> hasBookOverdue = new ArrayList<Boolean>();
	public List<Float> fine = new ArrayList<Float>();
	
	//other variables
	public String name = "Books.txt";
	public String people = "People.txt";
	private File peopleFile = new File(people);
	public File file = new File(name);
	private Scanner input;
	private Scanner personInput;
	private String comma = ",";
	private String words = "";
	private int counter = 0;
	private String tracker;
	private String list;
	private String personWords = "";
	
	
	public Tracker() {
		try {
			input = new Scanner(file);
			personInput = new Scanner(peopleFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bookReader();
		personReader();
	}
	
	public void bookReader() {
		while (input.hasNextLine()) {
			words += input.nextLine();

		} 
		
		StringTokenizer st = new StringTokenizer(words,comma);
		
		while(st.hasMoreElements()) {
			tracker = (String)st.nextElement();
			
			if(counter > 6) 
				counter = 0;
			
			counter++;
			
			//System.out.println(counter);
			
			switch(counter) {
			//Name of Book
			case 1:
				names.add(tracker);
				break;
				
			//First Name of Author
			case 2:
				firstName.add(tracker);
				break;
				
			//Last Name of Author
			case 3:
				lastName.add(tracker);
				break;
			
			//Amount of Pages
			case 4:
				int intTracker = Integer.parseInt(tracker);
				pageNumbers.add(intTracker);
				break;
		
			//Checked Out?
			case 5:
				boolean boolTracker = Boolean.parseBoolean(tracker);
				checkedOut.add(boolTracker);
				break;
		
			//Tracking Number
			case 6:
				int ISBNTracker = Integer.parseInt(tracker);
				ISBN.add(ISBNTracker);
				break;
		
			//Due date
			case 7:
				due.add(tracker);
				break;
			}
			
		}
			
	}
	
	public void personReader() {
		while (personInput.hasNextLine()) {
			personWords += personInput.nextLine();
		} 
		
		StringTokenizer st = new StringTokenizer(personWords,comma);
		
		counter = 0;

		while(st.hasMoreElements()) {
			tracker = (String)st.nextElement();
			
			if(counter > 4) 
				counter = 0;
			
			counter++;
			
			
			switch(counter) {
			//Name of Book
			case 1:
				patronFirstName.add(tracker);
				break;
				
			//First Name of Author
			case 2:
				patronLastName.add(tracker);
				break;
				
			//Last Name of Author
			case 3:
				int intTracker = Integer.parseInt(tracker);
				patronID.add(intTracker);
				break;
			
			//Amount of checked
			case 4:
				boolean hasBookOverdueTracker = Boolean.parseBoolean(tracker);
				hasBookOverdue.add(hasBookOverdueTracker);
				break;
		
			case 5:
				float fineTracker = Float.parseFloat(tracker);
				fine.add(fineTracker);
			
			}
		}
	}
	
}
