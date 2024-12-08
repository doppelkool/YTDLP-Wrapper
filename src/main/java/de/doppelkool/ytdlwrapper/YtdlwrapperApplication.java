package de.doppelkool.ytdlwrapper;

import de.doppelkool.ytdlwrapper.entity.Download;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class YtdlwrapperApplication {

	public static ArrayList<Download> currentDownloads = new ArrayList<>();
	public static ArrayList<Download> finishedDownloads = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(YtdlwrapperApplication.class, args);
	}

}
