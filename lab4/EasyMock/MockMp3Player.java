import java.util.ArrayList;
import static org.easymock.EasyMock.*;

public class MockMp3Player implements Mp3Player{

  private Mp3Player new_mp3;
  private boolean isPlaying;
  private String currentsong;
  private ArrayList playlist;
  private int playlistSize;
  private int songPointer;
  private double position;

  public MockMp3Player() {
  
    new_mp3 = createMock(Mp3Player.class);
    isPlaying = false;
    playlist = new ArrayList();
    currentsong = "hailhydra";
    playlistSize = -1;
    songPointer = 0;
    position = 0.00;    

    currentStateInit();
  }

  public void currentStateInit(){
    expect(new_mp3.isPlaying()).andReturn(isPlaying);
    expect(new_mp3.currentPosition()).andReturn(position);
    expect(new_mp3.currentSong()).andReturn(currentsong);
    replay( new_mp3 );
  }
  
  public void playerListGeneration() {
    
    reset( new_mp3 );
    expect(new_mp3.isPlaying()).andReturn(isPlaying);
    expect(new_mp3.currentPosition()).andReturn(position);
    expect(new_mp3.currentSong()).andReturn(currentsong);
    replay( new_mp3 );

  }
  
  /** 
   * Begin playing the filename at the top of the
   * play list, or do nothing if playlist 
   * is empty. 
   */
  public void play() {
    
    if (playlist.isEmpty()) { isPlaying = false; } 
    else {
        isPlaying = true;
        position = 11; //Random non zero float
    }
    
    playerListGeneration() ;
  }

  /** 
   * Pause playing. Play will resume at this spot. 
   */

  public void pause() {
	isPlaying = false;
        playerListGeneration();
  }

    /** 
   * Stop playing. The current song remains at the
   * top of the playlist, but rewinds to the 
   * beginning of the song.
   */
  public void stop() {
	isPlaying = false;
	position = 0.0;
	playerListGeneration() ;
  }


  /** 
   * Advance to the next song in the playlist 
   * and begin playing it.
   */
  public void next() {
	if(songPointer == playlistSize - 1)
	{
		songPointer = playlistSize - 1;
		currentsong = (String) playlist.get(songPointer);		
	}
	else
	{
		songPointer += 1;
		currentsong = (String) playlist.get(songPointer);
	}

  }

  /**
   * Go back to the previous song in the playlist
   * and begin playing it.
   */
  public void prev() {
	if(songPointer == 0)
	{
		songPointer = 0;
		currentsong = (String) playlist.get(songPointer);		
	}
	else
	{
		songPointer -= 1;
		currentsong = (String) playlist.get(songPointer);
	}
  }

  /**
   * Returns the currently playing file name.
   */
  public String currentSong(){
	return currentsong;
  }


  /**
   * Load filenames into the playlist.
   */
  public void loadSongs(ArrayList names){
	playlist = new ArrayList(names);
	playlistSize = playlist.size();
  }

 /** Returns the number of seconds into 
   * the current song.
   */
  public double currentPosition(){
    return new_mp3.currentPosition();
  }

  /** 
   * Returns true if a song is currently 
   * being played.
   */
  public boolean isPlaying(){
	return isPlaying;
  }
}
