package org.binggo.mockapp.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ExceptionController can be used to handle the exceptions thrown by the framework (spring & mybatis)
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="error")  
public class ExceptionController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// add the handler

}

