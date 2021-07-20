package com.android.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.android.spring.domain.BoardVO;
import com.android.spring.domain.FileBoardVO;
import com.android.spring.domain.PagingVO;

public interface BoardService {
	
	
	public List<BoardVO> viewAll();
	
	public ArrayList<Map<String, BoardVO>> appviewAll(); 
	
	public boolean insertPro(BoardVO vo);

	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO vo);
	
	public BoardVO viewDetail(int seq);
	
	public boolean incCnt(int seq);
	
	// 게시물 삭제
	public boolean deleteBoard(int seq);
	
	// 게시물 수정
	public boolean updateBoard(BoardVO vo);
	
	// 게시물 업로드
	public boolean uploadfile(FileBoardVO vo);

	public List<BoardVO> selectAppBoard(PagingVO vo);

	public int countAppBoard();

}
