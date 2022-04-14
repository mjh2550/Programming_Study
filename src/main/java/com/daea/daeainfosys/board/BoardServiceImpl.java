package com.daea.daeainfosys.board;

import com.daea.daeainfosys.mapper.BoardMapper;
import com.daea.daeainfosys.mapper.TestMapper;
import com.daea.daeainfosys.model.BoardVO;
import com.daea.daeainfosys.model.Pagination;
import com.daea.daeainfosys.model.TestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final TestMapper testMapper;
    private final BoardMapper boardMapper;

    @Override
    public ArrayList<TestVO> getTest() {
        return testMapper.getTest();
    }

    @Override
    public ArrayList<BoardVO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public String getListCount() {
        return boardMapper.getListCount();
    }

    @Override
    public ArrayList<BoardVO> getBoardListWithPaging(HashMap<String, Object> paramMap) {
        return boardMapper.getBoardListWithPaging(paramMap);
    }

}
