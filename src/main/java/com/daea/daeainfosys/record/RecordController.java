package com.daea.daeainfosys.record;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecordController {

    @GetMapping("record.do")
    public ModelAndView record(){

        ModelAndView mv = new ModelAndView("record");
        mv.addObject("record","record");

        return mv;
    }
}
