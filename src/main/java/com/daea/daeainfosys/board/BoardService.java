package com.daea.daeainfosys.board;

import com.daea.daeainfosys.model.BoardVO;
import com.daea.daeainfosys.model.Pagination;
import com.daea.daeainfosys.model.TestVO;

import java.util.ArrayList;
import java.util.HashMap;


public interface BoardService {

   ArrayList<TestVO> getTest();
   ArrayList<BoardVO> getBoardList();
   String getListCount();
   ArrayList<BoardVO> getBoardListWithPaging(HashMap<String,Object> paramMap);
}
