package org.example.springmvc.controller;

import org.example.springmvc.exception.RecordNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(RecordNotFoundException.class)
    public ModelAndView recordNotFoundErrorHandler(RecordNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

}
