package popups;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class TextFileChooser {
	private File file;

	public TextFileChooser(File initalDir) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(initalDir);
		fc.getExtensionFilters().add(new ExtensionFilter("Text Document", "*.txt"));
		file = fc.showOpenDialog(null);
	}
	
	public TextFileChooser(String initalDir) {
		this(new File(initalDir));
	}

	public File getFile() {
		return file;
	}

}
