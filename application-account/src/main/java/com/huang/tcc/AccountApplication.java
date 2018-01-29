package com.huang.tcc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Description:
 * Created on 2018/1/29 22:37
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@SpringBootApplication
@ImportResource("classpath:tcc-transaction.xml")
public class AccountApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder().sources(AccountApplication.class).web(false).run(args);
        com.alibaba.dubbo.container.Main.main(args);
    }
}
