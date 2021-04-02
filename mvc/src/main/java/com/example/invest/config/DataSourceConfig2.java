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
@MapperScan(value = ContextConstant.BASE_PACKAGE + ".mapper.**", sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSourceConfig2 {

    @Bean
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory2(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sql-mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
