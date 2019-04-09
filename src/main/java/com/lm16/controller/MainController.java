package com.lm16.controller;

import com.lm16.bean.Father;
import com.lm16.service.FatherService;
import com.lm16.service.impl.FatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private FatherService fatherService;

    @Autowired
    public MainController(FatherServiceImpl fatherService){
        this.fatherService = fatherService;
    }

    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Father> list = fatherService.list();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
