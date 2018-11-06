package design.structural.adapter;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;
	public void play(String audioType, String fileName) {
		
		if("mp3".equals(audioType)) {
			System.out.println("play : " + fileName);
		} else if("mp4".equals(audioType) || "vlc".equals(audioType)) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. "+
		            audioType + " format not supported");
		}
	}
}
