package com.huang.tcc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huang.tcc.bean.Account;
import com.huang.tcc.service.AccountService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.api.TransactionContextEditor;

/**
 * Description:
 * Created on 2018/1/29 22:23
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    @Compensable(confirmMethod = "confirm", cancelMethod = "cancel")
    public void tryAccount(TransactionContext context, Account account) {
        System.out.println("try account");
    }

    @Override
    public void confirm(TransactionContext context, Account account) {
        System.out.println("confirm account");
    }

    @Override
    public void cancel(TransactionContext context, Account account) {
        System.out.println("cancel account");

    }
}
