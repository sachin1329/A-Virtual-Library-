import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Book {
	
	public static List<Book> books = new ArrayList<Book>();
	
	public String name, firstName, lastName, due;
	public int pageNumbers, ISBN;
	public boolean checkedOut;
	public FileWriter fileWriter;
	Tracker tr = new Tracker();
	Patron patron = new Patron();
	
	public Book(String name, String firstName, String lastName, int pageNumbers,  boolean checkedOut, int ISBN, String due) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pageNumbers = pageNumbers;
		this.checkedOut = checkedOut;
		this.ISBN = ISBN;
		this.due = due;
	}
	
	public Book() {
		
	}
	
	public void checkOutBook() {
		getBook();
		Scanner sc = new Scanner(System.in);
		System.out.print("checkOut: ");
		String checkOut = sc.nextLine();
		System.out.println("patron: ");
		patron.checkOut();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).toString().toLowerCase().contains(checkOut.toLowerCase())) {
				books.get(i).setCheckedOut(true);
				books.get(i).setDue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())).plusWeeks(2).toString());
				System.out.println(books.get(i).name + " is checked out");
			}
			
		}
		update();
	}
	//overrides the toString function so it can print the Book object
	@Override
	public String toString() {
		String returnBook = "\n" + name + ", " + firstName + " " + lastName 
				+ ", " + pageNumbers + ", " + checkedOut + ", " + ISBN + ", " + due;
	    return returnBook;
	    
	  }
	
	public void update() {
		PrintWriter writer;
		try {
			writer = new PrintWriter(tr.file);
			writer.print("");
			writer.close();
			
			try {
				fileWriter = new FileWriter(tr.name, true);
				for(int i = 0; i < books.size(); i++) {
					fileWriter.append(getName(i) + "," + getFirstName(i) + "," + getLastName(i) + "," + getPageNumbers(i) + "," + books.get(i).checkedOut + "," + getISBN(i) + "," + getDueDate(books.get(i).checkedOut) + ",\n");
				}
				fileWriter.close();
					System.out.println(books.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//adds book to array list and text file
	public void addBook(String name, String firstName, String lastName, int pageNumbers, int ISBN) {
		for(int i = 0; i < tr.names.size(); i++) {
			//System.out.println(names.get(i));
				
				books.add(new Book(getName(i), getFirstName(i), getLastName(i), getPageNumbers(i), getCheckedOut(i), getISBN(i), getDue(i)));
		}
		try{
			fileWriter = new FileWriter(tr.name, true);
			fileWriter.append("\n" + name + "," + firstName + "," + lastName + "," + pageNumbers + "," + false + "," + ISBN + "," + "N/A,");
			fileWriter.close();
			books.add(new Book(name, firstName, lastName, pageNumbers, false, ISBN, "N/A"));
			printBooks();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//returns the books from the array list
	public void getBook() {
		
		for(int i = 0; i < tr.names.size(); i++) {
		//System.out.println(names.get(i));
			
			books.add(new Book(getName(i), getFirstName(i), getLastName(i), getPageNumbers(i), getCheckedOut(i), getISBN(i), getDue(i)));
		}
		printBooks();
	}

	//prints all the books
	public void printBooks() {
		for(int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());	
		}
	}
	
	
	
	
	public String getName(int i) {
		return tr.names.get(i);
	}
	
	public String getFirstName(int i){
		return tr.firstName.get(i);
	}
	
	public String getLastName(int i) {
		return tr.lastName.get(i);
	}
	
	public int getPageNumbers(int i) {
		return tr.pageNumbers.get(i);
	}
	
	public boolean getCheckedOut(int i) {
		return tr.checkedOut.get(i);
	}
	
	public int getISBN(int i) {
		return tr.ISBN.get(i);
	}
	
	public String getDue(int i) {
		return tr.due.get(i);
	}
	
	public String getDueDate(boolean shouldHaveADate) {
		if(shouldHaveADate){
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			return LocalDate.parse(timeStamp).plusWeeks(2).toString();
		}else {
			return "N/A";
		}
			
	}

	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
		
	}
	
	
	
	public void binarySearch() {
		
	}
	
	
}
