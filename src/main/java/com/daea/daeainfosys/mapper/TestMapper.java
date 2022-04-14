package com.daea.daeainfosys.mapper;

import com.daea.daeainfosys.model.BoardVO;
import com.daea.daeainfosys.model.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface TestMapper {
    ArrayList<TestVO> getTest();
}
