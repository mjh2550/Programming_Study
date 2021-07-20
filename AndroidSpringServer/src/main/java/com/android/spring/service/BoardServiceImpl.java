package com.android.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.spring.dao.BoardDAO;
import com.android.spring.domain.BoardVO;
import com.android.spring.domain.FileBoardVO;
import com.android.spring.domain.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> viewAll() {
		// TODO Auto-generated method stub
		return boardDAO.viewAll();
	}

	// 게시글 등록
	@Override
	public boolean insertPro(BoardVO vo) {

		boolean tf = boardDAO.insertPro(vo);
		return tf;
	}

	@Override
	public int countBoard() {
		return boardDAO.countBoard();
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		return boardDAO.selectBoard(vo);
	}
	@Override
	public List<BoardVO> selectAppBoard(PagingVO vo) {
		return boardDAO.selectAppBoard(vo);
	}

	@Override
	public BoardVO viewDetail(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.viewDetail(seq);
	}

	@Override
	public boolean incCnt(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.incCnt(seq);
	}

	@Override
	public boolean deleteBoard(int seq) {
		// TODO Auto-generated method stub
		boolean result = boardDAO.deleteBoard(seq);
		return result;
	}

	// 게시물 수정
	public boolean updateBoard(BoardVO vo) {
		boolean result = boardDAO.updateBoard(vo);
		return result;
	}

	@Override
	public  ArrayList<Map<String, BoardVO>> appviewAll() {

		return boardDAO.appviewAll();
	}

	@Override
	public boolean uploadfile(FileBoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.uploadfile(vo);
	}

	@Override
	public int countAppBoard() {
		// TODO Auto-generated method stub
		return boardDAO.countAppBoard();
	}

}
