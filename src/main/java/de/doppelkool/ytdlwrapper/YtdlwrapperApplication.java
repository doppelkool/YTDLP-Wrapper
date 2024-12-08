package de.doppelkool.ytdlwrapper;

import de.doppelkool.ytdlwrapper.entity.Download;
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;

@SpringBootApplication
public class YtdlwrapperApplication extends Application {

	public static ArrayList<Download> currentDownloads = new ArrayList<>();
	public static ArrayList<Download> finishedDownloads = new ArrayList<>();

	@Getter
	private static File selectedDownloadDirectory;

	public static void main(String[] args) {
		new Thread(() -> SpringApplication.run(YtdlwrapperApplication.class, args)).start();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		File selectedDirectory;
		do {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Select Download Folder");
			selectedDirectory = directoryChooser.showDialog(primaryStage);
		} while(selectedDirectory == null);

		System.out.println("Selected folder: " + selectedDirectory.getAbsolutePath());
		YtdlwrapperApplication.selectedDownloadDirectory = selectedDirectory;
	}
}
