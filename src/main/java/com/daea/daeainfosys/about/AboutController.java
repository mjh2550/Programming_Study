package com.daea.daeainfosys.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

    @GetMapping("about.do")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView("about");
        mv.addObject("about","about");

        return mv;
    }
}
