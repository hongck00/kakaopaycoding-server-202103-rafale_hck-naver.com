package com.example.invest.config;

import com.example.invest.common.ContextConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = ContextConstant.BASE_PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSourceConfig1 {

    @Bean
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory1(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource1());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sql-mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
