package de.doppelkool.ytdlwrapper.entity;

import lombok.*;

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
	public int timer;

	public Download() {}

	public Download(String url, String videoTitle, String log, int timer) {
		this.url = url;
		this.videoTitle = videoTitle;
		this.log = log;
		this.timer = timer;
	}
}
