package com.daea.daeainfosys.board;


import com.daea.daeainfosys.model.BoardVO;
import com.daea.daeainfosys.model.Pagination;
import com.daea.daeainfosys.model.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BoardController {

    @Autowired
    public BoardService boardService;

    @GetMapping("board.do")
    public ModelAndView board(){
        ModelAndView mv = new ModelAndView("board");

        //TestVO vo = boardService.getTest();
        ArrayList<BoardVO> voList = boardService.getBoardList();
        mv.addObject("boardList",voList);

        return mv;
    }

    /**
     * ajax로 게시글 조회
     * @param request
     * @return model
     */
    @ResponseBody
    @PostMapping("goList.do")
    public ModelAndView goList(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("jsonView");

        /**
         * 0.파라미터 받기
         */
        String pageNum = request.getParameter("PAGE_NUM")==null? "0" : request.getParameter("PAGE_NUM");
        String searchWord = request.getParameter("SEARCH_WORD")==null? "": request.getParameter("SEARCH_WORD");
        /* String searchType = request.getParameter("SEARCH_TYPE");*/

        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("SEARCH_WORD","%"+searchWord+"%");
        /**
         * 1.전체 게시글 수 가져오기
         * 2.페이지 수 파싱 후 페이징처리를 위한 객체 생성
         * 3.게시글 조회 (분기 : 서치타입)
         * 서치타입 : 제목(T), 작성자(U)
         */

        //1.
        int listCnt = Integer.parseInt(boardService.getListCount());
        //2.
        int curPage = Integer.parseInt(pageNum);
        Pagination pagination = new Pagination(listCnt,curPage,10);//게시글 수

        paramMap.put("pagination",pagination);
        //3.
        ArrayList<BoardVO> getBoardList = boardService.getBoardListWithPaging(paramMap);
        
        //4.결과 객체 전송
        mv.addObject("list",getBoardList);
        mv.addObject("pagination",pagination);


        return mv;
    }
}
