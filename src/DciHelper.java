import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class DciHelper {
	final static int FIND_SONG = 1;
	final static int PRINT_RESULTS = 2;
	final static int QUIT = 3;
	private String[] corps = {"Blue Coats", "Blue Devils", "bk", "Blue Stars", 
			"Boston Crusaders", "Cascades", "Cavs", "Colts", "Crossmen", 
			"Crown", "Genesis", "Jersey Surf", "Madison Scouts", 
			"Mandarins", "Oregon Crusaders 2", "Pacific Crest", 
			"Phantom", "Pioneer lol", "SCV", "Spirit", "The Academy", "The Cadets", "The Troopers"};
	private ArrayList<Corp> corpList;
	
	public DciHelper() {
		try {
		loadCorpData(corps);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			corpList = null;
		}
	}
	
	public void loadCorpData(String[] corpNames) throws FileNotFoundException{
		// Takes the file names and turns them into corp objects
		Scanner file;
		String showName = "";
		String corpName = "";
		String year = "";
		String song = "";
		Show show;
		this.corpList = new ArrayList<Corp>();
		for (String corp: corpNames) {
		 
			file = new Scanner(new File (corp));
			corpName = file.nextLine();
			Corp a = new Corp(corpName);
			while (file.hasNext()) { // loops whole document
				String tester = "";
				showName = "";
			year = file.next();
			tester = file.next();
			while (!tester.equals("*")) { // Gets show title
				showName += tester + " ";
				tester = file.next();
			} // End show title
			show = new Show(showName, year);
			show.setCorpName(a.getName());
			a.addShow(show);
			tester = file.next();
			while (!tester.equals("+")) { // "+" signifies end of line
				song = "";
				while (!tester.equals("/")) { // Gets show names within "/"
					song += tester + " ";
					tester = file.next();
				} //end song name
				a.getShow(showName).addSong(song);
				tester = file.next();
			} // End line
			} //End whole document
			
			this.corpList.add(a);			
		file.close();
		} //End for loop of corps
		setAllScores(); // Assigns scores, which are found in the final "Song"
		
	}
	
	public void setAllScores() {
		for (Corp corp: corpList) {
			corp.setScores();
			corp.addPlacements();
		}
		return;
	}
	
	public void getResults(String year) {
		ArrayList<Show> showsInYear = new ArrayList<Show>();
		int place = 1;
		for (Corp corp: corpList) {
			for (Show show: corp.getShows()) {
				if (show.getYear().equals(year))
					showsInYear.add(show);
			}
		}
		for (place = 1; place < 31; ++place) {
			for (Show show: showsInYear) {
				if (show.getPlacement() == place) {
					System.out.println(place + ". " + show.getCorpName() + ": " + show.getName());
					
				}
			}
		}
	}
	
	public static int menu(Scanner scnr) {
		int choice = 0;
		System.out.println("What do you want to do? Enter the corresponding number.");
		System.out.println("1. Find a show with a certain song.");
		System.out.println("2. Get results from a specific year.");
		System.out.println("3. Quit.");
		
		choice = scnr.nextInt();
		scnr.nextLine();
		if (choice > 0 && choice <= QUIT) {
			return choice;
		}
		
		else {
			System.out.println("Enter a valid number.");
			menu(scnr);
		}
		return 4;
	}
	
	public void songFinder(String songName) {
		// Prints shows with the song
		for (Corp corp: corpList) {
			corp.findSong(songName);
		}
		return;
	}
}
