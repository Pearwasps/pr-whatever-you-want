import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

public class Sus extends JFrame {
	public Sus() {
		try {
			JLabel daBaby = new JLabel();
			daBaby.setIcon(new ImageIcon(ImageIO.read(new File("sus.jpg"))));

			this.setLayout(new FlowLayout());
			this.setSize(828, 457);
			this.add(daBaby);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			URL sus = this.getClass().getClassLoader().getResource("sus.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sus);
			Clip airpod_shotty = AudioSystem.getClip();
			airpod_shotty.open(audioIn);
			airpod_shotty.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] random_shit) {
		try (BufferedInputStream amogus = new BufferedInputStream(new URL("https://i.kym-cdn.com/photos/images/original/001/956/032/4e7.jpg").openStream());
		     BufferedInputStream amogus2 = new BufferedInputStream(new URL("https://media.githubusercontent.com/media/wouu/assets/main/sus.wav").openStream());
		     FileOutputStream imposter = new FileOutputStream("sus.jpg");
		     FileOutputStream imposter2 = new FileOutputStream("sus.wav")) {
			byte data[] = new byte[1024];
			int content;
			while ((content = amogus.read(data, 0, 1024)) != -1) {
				imposter.write(data, 0, content);
			}
			while ((content = amogus2.read(data, 0, 1024)) != -1) {
				imposter2.write(data, 0, content);
			}
			
			new Sus();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
