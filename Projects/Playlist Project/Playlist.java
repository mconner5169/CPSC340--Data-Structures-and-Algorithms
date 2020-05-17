import java.util.*;
import java.io.*;

class Song {
	private String artist;
	private String title;
	public DoubleList<Song> playlist = new DoubleList <Song>();

	public Song() {
		playlist = new DoubleList <Song>();
	}

	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	//Adds a song to the end of the list
	public void add(Song addvalue) {
		playlist.addEnd(addvalue);
	}

	public void removeSong(Song rmvalue) {
		playlist.remove(rmvalue);
	}

	public void play() {
		playlist.printForwards();
	}

	//Need to finish this method
	public void shuffle() {
		playlist.rearrange();
	}

	public int count() {
		int number = playlist.size();
		return number;
	}

	public void reverse() {
		playlist.printBackwards();
	}

	public Song getSong(int index) {
		return playlist.get(index);
	}

	public boolean containsSong(Song valueContained) {
		return playlist.contains(valueContained);
	}

	@Override
		public String toString() {
			String fullSong = "";
			fullSong = (artist + " - " + title);
			return fullSong;
		}
}

public class Playlist {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Song playlist = new Song ();
		String songArtist;
		String songTitle;

		System.out.println("This is the place to make your own playlist!\n" + 	"There are a list of commands that allow you to make and manage your playlist.\n" + "Commands List: add, remove, play, shuffle, count, reverse, save, load, and quit.\n" + "Type a command here: ");

		String command = scan.next();

		while (!command.equals("quit")) {

			if (command.equals("add")) {
				//Throws away artist line
				scan.nextLine();
				System.out.println("Enter artist, then press enter twice: ");
				songArtist = scan.nextLine();
				
				//Throws away title line
				scan.nextLine();
				System.out.println("Enter title: ");
				songTitle = scan.nextLine();

				//Makes a song object and adds it to the playlist
				Song s = new Song (songArtist, songTitle);
				playlist.add(s);

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
			
			if (command.equals("remove")) {
				//Throws away first line
				scan.nextLine();
				System.out.println("Enter artist, then press enter twice: ");
				songArtist = scan.nextLine();

				//Throws title line
				scan.nextLine();
				System.out.println("Enter title: ");
				songTitle = scan.nextLine();

				Song s = new Song(songArtist, songTitle);
				
				//Makes song object and removes it from playlist
			//	for (int i = 0; i <= playlist.count(); i++) {
					if (playlist.containsSong(s)){
						playlist.removeSong(s);
					}
			//	}

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
			//Prints out the playlist
			if (command.equals("play")) {
				playlist.play();

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}

			//Reverses the addresses
			if (command.equals("reverse")) {
				playlist.reverse();

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
		
			//Need to finish this
			if (command.equals("shuffle")) {
				playlist.shuffle();

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}

			if (command.equals("count")) {
				System.out.println(playlist.count());

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
			
			//Saves playlist to file
			if (command.equals("save")) {
				System.out.println("Enter a filename to save your playlist: ");
				String filename = scan.next();
				File fname = new File(filename);

				try {
					PrintWriter file = new PrintWriter (fname);
					
					//saves songs to file
					for(int i = 0; i < playlist.count(); i++) {
						file.println(playlist.getSong(i));
					}
					file.close();
				}
				catch (FileNotFoundException e) {
					System.out.println("Error, file could not be opened.");
				}
				
				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
			
			//Prints everything from file but gives exception
			if (command.equals("load")) {
				System.out.println("Enter a filename to load a playlist: ");
				String filename = scan.next();
				System.out.println();

				//reads the file, if there's one, and prints the results
				try {
					FileInputStream file = new FileInputStream (filename);
					Scanner fscan = new Scanner(file);

					//Prints all the songs in the file
					for (int i = 0; i <= playlist.count(); i++) {
						if (fscan.hasNextLine()) {
							String song = fscan.nextLine();
							System.out.println(song);
						}
						else {
							fscan.close();
							break;
						}
					}
				}
				catch (FileNotFoundException e) {
					System.out.println("Error, file not found.");
				}

				System.out.println();
				System.out.println("Type command here: ");
				command = scan.next();
			}
		}
	}
}
