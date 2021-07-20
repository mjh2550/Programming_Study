package com.android.spring.controller;

import java.awt.List;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.spring.domain.BoardVO;
import com.android.spring.domain.PagingVO;
import com.android.spring.service.BoardService;

@Controller
public class MainController {

	@Autowired
	private BoardService boardservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping("test.do")
	public String test(Model model) {

		// 메인 게시판 리스트
		model.addAttribute("viewAll", boardservice.viewAll());

		return "board/test";

	}

	// 글 보기
	@RequestMapping("viewBoard.do")
	public String viewBoard(Model model, @RequestParam("seq") int seq) {

		// 자세히 보기
		model.addAttribute("board", boardservice.viewDetail(seq));

		// 조회수 +1
		boardservice.incCnt(seq);

		return "board/viewBoard";

	}

	// 글쓰기
	@RequestMapping("insertBoard.do")
	public String insertBoard(Model model) {

		return "board/insertBoard";

	}

	@RequestMapping(value = "insertProcess.do", method = RequestMethod.POST)
	public String insertProcess(Model model, HttpServletRequest request, HttpServletResponse response, BoardVO vo)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (boardservice.insertPro(vo)) {
			model.addAttribute("viewAll", boardservice.viewAll());
			return "board/insertProcess";
		} else {
			return "board/insertBoard";
		}
	}

	// 페이징처리
	@RequestMapping("boardList.do")
	public String boardList(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {

		int total = boardservice.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", boardservice.selectBoard(vo));
		return "board/boardPaging";
	}

	@RequestMapping("delete.do")
	public String delete(@RequestParam("seq") int seq) {
		boardservice.deleteBoard(seq);
		return "redirect: boardList.do";
	}

	@GetMapping("update.do")
	public String modify(@RequestParam("seq") int seq, Model model) {
		model.addAttribute("board", boardservice.viewDetail(seq));
		return "board/boardModify";
	}

	@PostMapping("update.do")
	public String modify(BoardVO vo) {
		boardservice.updateBoard(vo);
		return "redirect: viewBoard.do?seq=" + vo.getSeq();
	}

	// 게시판 전체조회 api
	@ResponseBody
	@RequestMapping("applist.do")
	public ArrayList<Map<String, BoardVO>> applist(BoardVO vo, Model model) {

		 ArrayList<Map<String, BoardVO>> mList = 
				 (ArrayList<Map<String, BoardVO>>) boardservice.appviewAll();
	
		return mList;

	}
	
	//앱 현황
	@RequestMapping("appBoardList.do")
	public String appBoardList(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {

		int total = boardservice.countAppBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("appViewAll", boardservice.selectAppBoard(vo));
		return "appBoard/boardPaging";
	}

}
