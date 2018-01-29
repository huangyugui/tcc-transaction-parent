package com.huang.tcc.service;

import com.huang.tcc.bean.Account;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

/**
 * Description:
 * Created on 2018/1/29 22:09
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
public interface AccountService {

    @Compensable
    public void tryAccount(TransactionContext context, Account account);

    @Compensable
    public void confirm(TransactionContext context, Account account);

    @Compensable
    public void cancel(TransactionContext context, Account account);
}
