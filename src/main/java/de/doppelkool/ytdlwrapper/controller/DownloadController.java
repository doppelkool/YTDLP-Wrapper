package de.doppelkool.ytdlwrapper.controller;

import de.doppelkool.ytdlwrapper.YtdlwrapperApplication;
import de.doppelkool.ytdlwrapper.entity.Download;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Class Description
 *
 * @author doppelkool | github.com/doppelkool
 */
@Controller
public class DownloadController {

	@PostMapping("/download")
	public String downloadFile(@RequestParam("url") String url, RedirectAttributes redirectAttributes) {
		if (url == null || url.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "URL cannot be empty!");
			return "redirect:/";
		}

		System.out.println("Downloading from URL: " + url);

		String videoTitle = fetchTitle();
		YtdlwrapperApplication.currentDownloads.add(new Download(url, videoTitle, null));



		redirectAttributes.addFlashAttribute("currentDownloads", YtdlwrapperApplication.currentDownloads);
		return "redirect:/";
	}

	private String fetchTitle() {
		return "Hello world!";
	}
}