package com.NimapTask.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping("/")
	public String apicall()
	{
		return "apicall";
	}

}
