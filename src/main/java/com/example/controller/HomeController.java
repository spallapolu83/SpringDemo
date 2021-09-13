/**
 * 
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author palla
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/show")
	public String show() {
		return "HomePage";
	}

}
