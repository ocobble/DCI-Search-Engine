import java.util.ArrayList;
public class Corp {

	private String name = "";
	private ArrayList<Show> shows = new ArrayList<Show>();
	private ArrayList<Integer> placements = new ArrayList<Integer>();
	
	public Corp(String name) {
		this.name = name;
	}
	
	public void addShow(Show show) {
		shows.add(show);
	}
	
	public void addPlacements() {
		for (Show show: shows) {
			placements.add(show.getPlacement());
		}
	}
	

	public void setScores() {
		for (Show show: shows) {
			show.setScoreAndPlacement();
		}
		return;
	}
	
	public String getName() {
		return name;
	}
	
	public Show getShow(String name) {
		for (int i = 0; i < shows.size(); ++i) {
			if (shows.get(i).getName().equals(name)) {
				return shows.get(i);
			}
		}
		return new Show("", "");
	}
	
	public ArrayList<Show> getShows() {
		return shows;
	}
	
	public void displayShows() {
		for (int i = 0; i < shows.size(); ++i) {
			System.out.print(name + " ");
			shows.get(i).showToString();
		}
	}
	
	public void findSong(String song) {
		ArrayList<Show> showsWithSong = new ArrayList<Show>();
		for (Show show: this.shows) {
			ArrayList<String> songsInShow = show.getSongs();
			for (int i = 0; i < show.getNumSongs(); ++i) {
				if (songsInShow.get(i).toUpperCase().contains(song.toUpperCase())) {
					showsWithSong.add(show);
				}
			}
		}
		for (Show show: showsWithSong) {
		show.showToString();
		}
		return;
	}
	
}
