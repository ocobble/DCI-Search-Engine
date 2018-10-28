import java.util.ArrayList;
/**
 * 
 * @author Olivia
 *
 */
public class Show {

	private String showName = "";
	private String corpName = "";
	private String year = "";
	private ArrayList<String> songs = new ArrayList<String>();
	private double score = 0;
	private int placement = 0;
	
	public Show(String name, String year) {
		showName = name;
		this.year = year;
	}
	
	public void addSong(String song) {
		songs.add(song);
	}
	
	public void setScoreAndPlacement() {
		if (songs.size() == 0) {
			return;
		}
		String scoreInfo = songs.get(this.getNumSongs() - 1);
		int scoreLength = scoreInfo.length();
		String scoreString = "";
		String placementString = "";
		boolean finishedScore = false;
		for (int i = 0; i < scoreLength; ++i) {
			while (scoreInfo.charAt(i) != ' ' && !finishedScore) {
				if (Character.isDigit(scoreInfo.charAt(i)) || scoreInfo.charAt(i) == '.') {
				scoreString += scoreInfo.charAt(i);
				}
				++i;
			}
			finishedScore = true;
			if (Character.isDigit(scoreInfo.charAt(i))) {
				placementString += scoreInfo.charAt(i);
			}
		}
		if (!scoreString.isEmpty()) {
		this.score = Double.valueOf(scoreString);
		}
		if (!placementString.isEmpty()) {
		this.placement = Integer.valueOf(placementString);
		}
		return;
	}
	
	public String getName() {
		return showName;
	}
	
	public String getYear() {
		return year;
	}
	
	public ArrayList<String> getSongs() {
		return songs;
	}
	
	public int getNumSongs() {
		return songs.size();
	}
	
	public double getScore() {
		return score;
	}
	
	public int getPlacement() {
		return placement;
	}
	
	public void setCorpName(String name) {
		corpName = name;
	}
	
	public String getCorpName() {
		return corpName;
	}
	
	public void displayShowSongs() {
		for (int i = 0; i < songs.size(); ++i) {
			System.out.println(songs.get(i));
		}
	}
	
	public void showToString() {
		System.out.println(corpName + " " + year + " " + showName);
		this.displayShowSongs();
		System.out.println();
		return;
		
	}
}
