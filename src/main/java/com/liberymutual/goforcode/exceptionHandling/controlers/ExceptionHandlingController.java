// ExceptionHandlingController.java
package com.liberymutual.goforcode.exceptionHandling.controlers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ExceptionHandlingController {

    @GetMapping("/")
    public String showForm() {
        return "exceptionHandling/default";
    }

    @PostMapping("/handleString")
    public ModelAndView handleString(String probablySomeText) {
    	try {
	        ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("stringResult", probablySomeText.substring(4));
	        return mv;
    	}
    	catch (StringIndexOutOfBoundsException se) {
    		ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("stringResult", "String is not long enough");
	        return mv;
    	}
    }

    @PostMapping("/handleUrl")
    public ModelAndView handleUrl(String probablyAUrl) throws MalformedURLException {
    	try {
	        ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("urlResult", new URL(probablyAUrl));
	        return mv;
    	}
    	catch (MalformedURLException se) {
    		ModelAndView mv = new ModelAndView("exceptionHandling/default");
            mv.addObject("urlFailure", "Needs to be a URL");
            return mv;
    	}
    }

    @PostMapping("/handleInteger")
    public ModelAndView handleInteger(String probablyAnInteger) {
    	try {
    		ModelAndView mv = new ModelAndView("exceptionHandling/default");
            mv.addObject("integerResult", Integer.parseInt(probablyAnInteger));
            return mv;
    	}
    	catch (NumberFormatException se) {
    		ModelAndView mv = new ModelAndView("exceptionHandling/default");
            mv.addObject("integerResult", "Needs to be a number");
            return mv;
    	}
        
    }

    @PostMapping("/handleDecimal")
    public ModelAndView handleDecimal(String probablyADecimal) {
    	try {
	        ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("decimalResult", Double.parseDouble(probablyADecimal));
	        return mv;
    	}
        catch (NumberFormatException se){
        	ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("decimalResult", "Needs to be a decimal");
	        return mv;
        }
       
    }

    @PostMapping("/handleDate")
    public ModelAndView handleDate(String probablyADate) {
    	try {
	        ModelAndView mv = new ModelAndView("exceptionHandling/default");
	        mv.addObject("dateResult", LocalDate.parse(probablyADate));
	        return mv;
    	}
    	catch (DateTimeParseException se) {
    		 ModelAndView mv = new ModelAndView("exceptionHandling/default");
    	     mv.addObject("dateResult","Needs to be a date");
    	     return mv;
    		
    	}
    }

}
