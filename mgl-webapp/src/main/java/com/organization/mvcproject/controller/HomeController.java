package com.organization.mvcproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.GameImp;
import com.organization.mvcproject.model.ReviewImp;

@Controller
public class HomeController {
   
	@RequestMapping(value="/hello")
    public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
        ModelAndView ret = new ModelAndView("home");
        // Adds an object to be used in home.jsp
        ret.addObject("name", testingMethod());
        
        //logs to console 
        practiceLoop();
        
        return ret;
    }
	@GetMapping(value = "/")
	public String home() {
		return "index";
	}

	@GetMapping(value = "/review")
	public ModelAndView review() {
		return new ModelAndView("review", "command", new ReviewImp());
	}

	@PostMapping(value = "/addReview")
	public ModelAndView addReview(ReviewImp review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("result", "submittedReview", review);
	}

	
	@GetMapping(value = "/games")
	public ModelAndView game() {
		return new ModelAndView("games", "command", new GameImp());
	}
	
	private String testingMethod() {
        return "testing Method";
    }
    private String practiceLoop() {
        String testString = "";
        for(int i=0; i<=10; i++) {
            System.out.println("i: "+i);
            testString += i;
            System.out.println("testString: " + testString);
        }
        return testString;
    }
}