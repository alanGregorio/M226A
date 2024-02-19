/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alang
 */

    import javax.sound.sampled.AudioInputStream;
    import javax.sound.sampled.AudioSystem;
    import javax.sound.sampled.Clip;
    import java.io.File;

    public class Sound {
        public static synchronized void play(final String fileName)
        {
            // Note: use .wav files
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
                        clip.open(inputStream);
                        clip.start();
                    } catch (Exception e) {
                        System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
                    }
                }
            }).start();

        }
    }

