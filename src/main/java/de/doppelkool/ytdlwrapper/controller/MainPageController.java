package de.doppelkool.ytdlwrapper.controller;

import de.doppelkool.ytdlwrapper.YtdlwrapperApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class Description
 *
 * @author doppelkool | github.com/doppelkool
 */
@Controller
public class MainPageController {

	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("currentDownloads", YtdlwrapperApplication.currentDownloads);
		model.addAttribute("finishedDownloads", YtdlwrapperApplication.finishedDownloads);
		return "index";
	}
}