//package gui;
////
////import java.io.FileInputStream;
////import java.io.IOException;
////import java.io.InputStream;
////import sun.audio.AudioData;
////import sun.audio.AudioPlayer;
////import sun.audio.AudioStream;
////import sun.audio.ContinuousAudioDataStream;
////
////public class Soitin {
////    
////    public Soitin(String polku) {
////        AudioPlayer MGP = AudioPlayer.player;
////        AudioStream BGM;
////        AudioData MD;
//////        ContinuousAudioDataStream loop = null;
////        try {
////            InputStream test = new FileInputStream(polku);
////            BGM = new AudioStream(test);
////            AudioPlayer.player.start(BGM);
////        } catch (IOException error) {
////            System.out.print("file not found");
////        }
//////        MGP.start(loop);
////    }
////    
////}
//
//import java.io.File;
//import java.io.IOException;
//import javax.sound.sampled.AudioFormat;
//import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.sound.sampled.DataLine.Info;
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.SourceDataLine;
//import javax.sound.sampled.UnsupportedAudioFileException;
////
//public class Soitin {
//
//    public Soitin(String polku) {
//        try {
//            AudioInputStream audioInputStream
//                    = AudioSystem.getAudioInputStream(
//                            this.getClass().getResource("sky"));
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//        } catch (Exception ex) {
//        }
//    }
//}

//public class AudioFilePlayer {
//
////    public static void main(String[] args) {
//    private final AudioFilePlayer player = new AudioFilePlayer();
//
//    public AudioFilePlayer() {
//        player.play("sky.mp3");
////        player.play("something.ogg");
//    }
//
////    }
//    public void play(String filePath) {
//        final File file = new File(filePath);
//
//        try (final AudioInputStream in = getAudioInputStream(file)) {
//
//            final AudioFormat outFormat = getOutFormat(in.getFormat());
//            final Info info = new Info(SourceDataLine.class, outFormat);
//
//            try (final SourceDataLine line
//                    = (SourceDataLine) AudioSystem.getLine(info)) {
//
//                if (line != null) {
//                    line.open(outFormat);
//                    line.start();
//                    stream(getAudioInputStream(outFormat, in), line);
//                    line.drain();
//                    line.stop();
//                }
//            }
//
//        } catch (LineUnavailableException | IOException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    private AudioFormat getOutFormat(AudioFormat inFormat) {
//        final int ch = inFormat.getChannels();
//        final float rate = inFormat.getSampleRate();
//        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
//    }
//
//    private void stream(AudioInputStream in, SourceDataLine line)
//            throws IOException {
//        final byte[] buffer = new byte[4096];
//        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
//            line.write(buffer, 0, n);
//        }
//    }
//}
