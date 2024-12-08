package de.doppelkool.ytdlwrapper.entity;

import lombok.*;

import java.util.Timer;
import java.util.TimerTask;

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

		startDownload();
		startTimer();
	}

	//TODO
	private void startDownload() {
		//executeDL Method in C#
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
}
