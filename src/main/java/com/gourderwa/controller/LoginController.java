package com.gourderwa.controller;

import com.gourderwa.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "")
	public @ResponseBody
    Result index(String topoId) {
        System.out.println("--");
        return null;
	}

}
