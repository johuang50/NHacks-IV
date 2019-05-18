package popups;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SystemTrayPopup {

	public void displayTray(String firstLine, String secondLine, MessageType x)
			throws AWTException, MalformedURLException {
		// Obtain only one instance of the SystemTray object
		SystemTray tray = SystemTray.getSystemTray();
		// If the icon is a file
//		Image image = Toolkit.getDefaultToolkit().createImage("frogForce.png");
		// Alternative (if the icon is on the classpath):
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("frogForce.png"));

		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		// Let the system resize the image if needed
		trayIcon.setImageAutoSize(true);

		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {


			}
		});
		// Set tooltip text for the tray icon
		trayIcon.setToolTip(firstLine);
		tray.add(trayIcon);

		trayIcon.displayMessage(firstLine, secondLine, x);

	}

}
