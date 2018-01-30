package com.huang.tcc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mengyun.tcctransaction.recover.TransactionRecovery;
import org.mengyun.tcctransaction.spring.ConfigurableCoordinatorAspect;
import org.mengyun.tcctransaction.spring.ConfigurableTransactionAspect;
import org.mengyun.tcctransaction.spring.recover.RecoverScheduledJob;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.mengyun.tcctransaction.spring.support.SpringBeanFactory;
import org.mengyun.tcctransaction.spring.support.SpringTransactionConfigurator;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

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
        st.setDomain("ACCOUNT");
        st.setTbSuffix("_account");
        return st;
    }

//    @Bean
//    public SpringBeanFactory getSpringBeanFactory(){
//        return new SpringBeanFactory();
//    }
//
//    @Bean
//    public SpringTransactionConfigurator getSpringTransactionConfigurator(){
//        return new SpringTransactionConfigurator();
//    }
//
//    @Bean
//    public ConfigurableTransactionAspect getConfigurableTransactionAspect(SpringTransactionConfigurator springTransactionConfigurator){
//        ConfigurableTransactionAspect cta = new ConfigurableTransactionAspect();
//        cta.setTransactionConfigurator(springTransactionConfigurator);
//        return cta;
//    }
//
//    @Bean
//    public ConfigurableCoordinatorAspect getConfigurableCoordinatorAspect(SpringTransactionConfigurator springTransactionConfigurator){
//        ConfigurableCoordinatorAspect cca = new ConfigurableCoordinatorAspect();
//        cca.setTransactionConfigurator(springTransactionConfigurator);
//        return cca;
//    }
//
//    @Bean
//    public TransactionRecovery getTransactionRecovery(SpringTransactionConfigurator springTransactionConfigurator){
//        TransactionRecovery tr = new TransactionRecovery();
//        tr.setTransactionConfigurator(springTransactionConfigurator);
//        return tr;
//    }
//
//    @Bean
//    public SchedulerFactoryBean getSchedulerFactoryBean(){
//        return new SchedulerFactoryBean();
//    }
//
//    @Bean
//    public RecoverScheduledJob getRecoverScheduledJob(SpringTransactionConfigurator springTransactionConfigurator,
//            TransactionRecovery transactionRecovery, Scheduler schedulerFactoryBean){
//        RecoverScheduledJob rsj = new RecoverScheduledJob();
//        rsj.setTransactionConfigurator(springTransactionConfigurator);
//        rsj.setTransactionRecovery(transactionRecovery);
//        rsj.setScheduler(schedulerFactoryBean);
//        return rsj;
//    }
}
