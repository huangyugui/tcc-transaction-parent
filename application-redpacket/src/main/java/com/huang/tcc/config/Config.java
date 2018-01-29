package com.huang.tcc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Created on 2018/1/29 23:17
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@Configuration
public class Config {

    @Bean
    public DruidDataSource getTccDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/tcc?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("rootroot");
        return ds;
    }

    @Bean
    public SpringJdbcTransactionRepository getTransactionRepository(DruidDataSource tccDataSource){
        SpringJdbcTransactionRepository st = new SpringJdbcTransactionRepository();
        st.setDataSource(tccDataSource);
        st.setDomain("REDPACKET");
        st.setTbSuffix("_redpacket");
        return st;
    }

}
