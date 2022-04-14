package com.daea.daeainfosys.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("test.do")
    public ModelAndView home(){
     //   System.out.println("lasdgad");
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("test","test");

        return mv;
    }
}
