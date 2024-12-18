package de.doppelkool.ytdlwrapper.entity;

import de.doppelkool.ytdlwrapper.YtdlwrapperApplication;
import lombok.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Class Description
 *
 * @author doppelkool | github.com/doppelkool
 */
@Getter
@Setter
public class Download {
	public String url;
	public String videoTitle;
	public String log;
	public Timer timer;

	public Download() {}

	public Download(String url, String videoTitle, String log) {
		this.url = url;
		this.videoTitle = videoTitle;
		this.log = log;

		startTimer();
		startDownload();
		saveDownload();
	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(
			new TimerTask() {
				int seconds = 0;

				@Override
				public void run() {
					seconds++;
				}
			}, 0, 1000);
	}

	private void startDownload() {
		List<String> arguments = determineArguments();

		StringBuilder sb = new StringBuilder();
		ProcessBuilder processBuilder = new ProcessBuilder(arguments);
		processBuilder.redirectErrorStream(true);

		try {
			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			sb.append("Log for downloading: ")
				.append(this.url)
				.append("\n")
				.append(" with the following arguments:\n");

			while ((line = reader.readLine()) != null) {
				sb.append(line)
					.append("\n");
			}

			int exitCode = process.waitFor();
			sb.append("Process exited with code: ")
			  .append(exitCode);
			this.log = sb.toString();

			System.out.println("Download finished.");
		} catch (IOException | InterruptedException e) {
			this.log = sb.append("Downloaded exited with error:\n")
				.append(e.getMessage())
				.append("\n")
				.append(Arrays.toString(e.getStackTrace()))
				.append("\n")
				.toString();
			System.out.println("Download failed.");
		}
	}

	//ToDo More argument variation through FE
	//ToDo CurrentDownloads erst nach dem Download geladen, also Download Async und Log irgendwie alle x Sekunden oder so ans FE Schicken
	private List<String> determineArguments() {
		List<String> arguments = new ArrayList<>();

		arguments.add(YtdlwrapperApplication.tempPath + "\\yt-dlp.exe");
		arguments.add("-ffmpeg-location \"" + YtdlwrapperApplication.tempPath + "\\ffmpeg\\bin\\ffmpeg.exe\"");
		arguments.add("-f \"bv*[ext=mp4]+ba[ext=m4a]/b[ext=mp4]/bv*+ba/b\"");
		arguments.add("-P \"" + YtdlwrapperApplication.getSelectedDownloadDirectory().getPath().replace("\\", "\\\\") + "\"");
		arguments.add("-o \"%(title)s\"");
		arguments.add(" " + this.url);

		return arguments;
	}

	private void saveDownload() {
	}
}
