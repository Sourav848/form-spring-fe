package com.form.spring.fe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.form.spring.common.Constants;
import com.form.spring.common.GenericBackendResponse;
import com.form.spring.common.GenericResponse;
import com.form.spring.interceptor.SessionWrapper;
import com.form.spring.model.ContactUs;
import com.form.spring.utils.TutionUtils;
import com.google.gson.Gson;
import com.form.spring.common.ContactUsService;

@Controller
public class FormController {
	
	@Autowired
	ContactUsService contactUsService;
	
	Gson gson = new Gson();
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FormController.class);
	
	@RequestMapping(value = "/personal/detail/save", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse conatactUs(@RequestBody String data, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("session") SessionWrapper session) {
		GenericResponse feResopnse = new GenericResponse();
		if (TutionUtils.isNotEmpty(data)) {
			ContactUs contactUs = gson.fromJson(data, ContactUs.class);
				try {
						GenericBackendResponse beResponse = contactUsService.contactUsSave(contactUs);
						if (beResponse != null) {
							if (beResponse.isS()) {
								feResopnse.setStatus(Constants.SUCCESS);
								feResopnse.setSuccessMsg(beResponse.getMsg());
							} else {
								feResopnse.setStatus(Constants.FAILED);
								feResopnse.setErrorDetails(beResponse.getEd());
							}
						}
					
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			
		} else {
			feResopnse.setErrorDetails(Constants.SOME_THING_WENT_WRONG);
			feResopnse.setStatus(Constants.FAILED);
		}
		return feResopnse;
	}

}
