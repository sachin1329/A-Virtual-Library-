import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	Book book = new Book();
	private String name, firstName, lastName;
	private int pageNumbers, ISBN;
	
	Patron patron = new Patron();

	public Main() {
		menu();
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void menu() {
		System.out.println("1: Get List of Books.  2: Get List of Patrons. 3: Search. 4: Admin Options. 5:Check Out Book");
		int menu = sc.nextInt();
		if(menu == 1)
			getBooks();
		else if(menu == 2)
			getPatrons();
		else if(menu == 3)
			search();
		else if(menu == 4){
			System.out.println("1: add Book");
			int menuChoice = sc.nextInt();
			if (menuChoice == 1) {
			Scanner scan = new Scanner(System.in);
	
				name = scan.nextLine();
				firstName = scan.nextLine();
				lastName = scan.nextLine();
				pageNumbers = scan.nextInt();
				ISBN = scan.nextInt();
				
				book.addBook(name, firstName, lastName, pageNumbers, ISBN);
			}
		}else if(menu == 5)
			book.checkOutBook();
		else
			System.out.println("That is not a valid list");
	}
	
	public void getBooks() {
		book.getBook();
	}
	
	public void getPatrons() {
		patron.getPatron();
	}
	
	public void search() {
		
	}
	 
}
