package de.doppelkool.ytdlwrapper;

import de.doppelkool.ytdlwrapper.entity.Download;
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;

@SpringBootApplication
public class YtdlwrapperApplication extends Application {

	public static final String tempPath = System.getProperty("java.io.tmpdir");

	public static ArrayList<Download> currentDownloads = new ArrayList<>();
	public static ArrayList<Download> finishedDownloads = new ArrayList<>();

	public static File getSelectedDownloadDirectory() {
		return selectedDownloadDirectory;
	}

	private static File selectedDownloadDirectory;

	public static void main(String[] args) {
		new Thread(() -> SpringApplication.run(YtdlwrapperApplication.class, args)).start();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		String downloadPath = System.getenv("download-path");
		File selectedDirectory;

		if(downloadPath == null) {
			do {
				DirectoryChooser directoryChooser = new DirectoryChooser();
				directoryChooser.setTitle("Select Download Folder");
				selectedDirectory = directoryChooser.showDialog(primaryStage);
			} while(selectedDirectory == null);
		} else {
			selectedDirectory = new File(downloadPath);
		}

		System.out.println("Selected folder: " + selectedDirectory.getPath());
		YtdlwrapperApplication.selectedDownloadDirectory = selectedDirectory;
	}
}
