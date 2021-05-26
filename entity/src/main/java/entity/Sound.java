/**
 * 
 */
package entity;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author media
 *
 */
public class Sound {
public void playSound(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		try {
			File musicPath = new File (filepath);
			if(musicPath.exists()) {
		AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);
		FloatControl gainControl=(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		//clip.stop();
			}
			else {
				System.out.println("Can't find file");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
	}
public void playSound1(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	try {
		File musicPath = new File (filepath);
		if(musicPath.exists()) {
	AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
	Clip clip = AudioSystem.getClip();
	clip.open(audio);
	clip.start();
	//clip.loop(Clip.LOOP_CONTINUOUSLY);
	//clip.stop();
		}
		else {
			System.out.println("Can't find file");
		}
	}
	catch(Exception e)
	{
		System.out.println("Error");
		e.printStackTrace();
	}
}

}

 

