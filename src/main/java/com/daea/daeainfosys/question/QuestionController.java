package com.daea.daeainfosys.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {

    @GetMapping("question.do")
    public ModelAndView question(){

        ModelAndView mv = new ModelAndView("question");
        mv.addObject("question","question");

        return mv;
    }
}
