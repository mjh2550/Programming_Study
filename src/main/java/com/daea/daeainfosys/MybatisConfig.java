package com.daea.daeainfosys;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    /*@Bean
    public SqlSessionTemplate sqlSession(){

        return new SqlSessionTemplate(sqlSessionFactory());
    }*/
}
