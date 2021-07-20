package com.android.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.android.spring.domain.BoardVO;
import com.android.spring.domain.FileBoardVO;
import com.android.spring.domain.PagingVO;

public interface BoardDAO {

	public List<BoardVO> viewAll();

	//게시글 등록
	public boolean insertPro(BoardVO vo);
	public int countBoard();
	public List<BoardVO> selectBoard(PagingVO vo) ;
	public BoardVO viewDetail(int seq);
	public boolean incCnt(int seq) ;
	public boolean deleteBoard(int seq) ;
	// 게시물 수정
	public boolean updateBoard(BoardVO vo);

	public  ArrayList<Map<String, BoardVO>> appviewAll() ;
	
	public boolean uploadfile(FileBoardVO vo);

	public List<BoardVO> selectAppBoard(PagingVO vo);

	public int countAppBoard();
}
