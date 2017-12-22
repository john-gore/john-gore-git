import java.util.HashMap;

public class HashMatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();

        trackList.put("Red Dog", "These Lyrics are all the same!");
        trackList.put("Blue Dog", "These Lyrics are all the same!");
        trackList.put("Yellow", "These Lyrics are all the same!");
        trackList.put("Song10", "These Lyrics are all the same!");
        trackList.put("Song70", "These Lyrics are all the same!");


        String track = trackList.get("Song10");
        System.out.println(track);

        for(String key : trackList.keySet()){
            System.out.println(key + ":" + trackList.get(key));
        }

    }
}
