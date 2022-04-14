package com.daea.daeainfosys.mapper;

import com.daea.daeainfosys.model.BoardVO;
import com.daea.daeainfosys.model.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface BoardMapper {
    ArrayList<BoardVO> getBoardList();
    String getListCount();
    ArrayList<BoardVO> getBoardListWithPaging(HashMap<String,Object> paramMap);
}
