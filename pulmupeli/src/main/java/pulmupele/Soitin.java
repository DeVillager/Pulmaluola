
package pulmupele;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Soitin {
    
    public Soitin(String polku) {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try {
            InputStream test = new FileInputStream(polku);
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
        } catch (IOException error) {
            System.out.print("file not found");
        }
        MGP.start(loop);
    }
    
}
