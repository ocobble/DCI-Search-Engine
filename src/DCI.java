import java.util.Scanner;

public class DCI {
	final static int FIND_SONG = 1;
	final static int PRINT_RESULTS = 2;
	final static int QUIT = 3;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int answer;
		answer = DciHelper.menu(keyboard);
		DciHelper myHelper = new DciHelper();
		
		while (answer != QUIT) {
		
			if (answer == FIND_SONG) {
				System.out.println("What song do you want to find?");
				String songToFind = keyboard.nextLine();
				myHelper.songFinder(songToFind);
			}
			else if (answer == PRINT_RESULTS) {
				System.out.println("Enter a year to get results from.");
				String year = keyboard.nextLine();
				myHelper.getResults(year);
				
			}
			System.out.println();
			answer = DciHelper.menu(keyboard);
		}
			
		System.out.println("Bye Felicia.");
		keyboard.close();
	}
	
	
	
	
	
	
	
	
	
	
	
}
