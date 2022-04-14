package com.android.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.android.spring.domain.BoardVO;
import com.android.spring.domain.FileBoardVO;
import com.android.spring.domain.PagingVO;

@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;
	/*
	 * @Autowired private BoardMapper mapper;
	 */
	private final static String namespace = "com.android.spring.dao.BoardDAO";

	@Override
	public List<BoardVO> viewAll() {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectList(namespace + ".viewAll");
	}

	// 게시글 등록
	@Override
	public boolean insertPro(BoardVO vo) {

		int tf = SqlSessionTemplate.insert(namespace + ".insertPro", vo);
		if (tf == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int countBoard() {
		return SqlSessionTemplate.selectOne(namespace + ".countBoard");
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		return SqlSessionTemplate.selectList(namespace + ".selectBoard", vo);
	}
	
	@Override
	public List<BoardVO> selectAppBoard(PagingVO vo) {
		return SqlSessionTemplate.selectList(namespace + ".selectAppBoard", vo);
	}

	@Override
	public BoardVO viewDetail(int seq) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne(namespace + ".viewDetail", seq);
	}

	@Override
	public boolean incCnt(int seq) {
		// TODO Auto-generated method stub
		int result = SqlSessionTemplate.update(namespace + ".incCnt", seq);
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteBoard(int seq) {
		// TODO Auto-generated method stub
		int result = SqlSessionTemplate.delete(namespace + ".deleteBoard", seq);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 게시물 수정
	public boolean updateBoard(BoardVO vo) {
		int result = SqlSessionTemplate.update(namespace + ".updateBoard", vo);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public  ArrayList<Map<String, BoardVO>> appviewAll() {

		List<Map<String, BoardVO>> mList = SqlSessionTemplate.selectList(namespace + ".appviewAll");
	
		return (ArrayList<Map<String, BoardVO>>) mList;
	}

	@Override
	public boolean uploadfile(FileBoardVO vo) {
		
		int tf = SqlSessionTemplate.insert(namespace + ".insertUpload", vo);
		if (tf == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int countAppBoard() {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne(namespace + ".countAppBoard");
	}

}
