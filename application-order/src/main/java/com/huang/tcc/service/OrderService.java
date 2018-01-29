package com.huang.tcc.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huang.tcc.bean.Account;
import com.huang.tcc.bean.RedPacket;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * Created on 2018/1/29 22:56
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@Service
public class OrderService {

    @Reference
    AccountService accountService;

    @Reference
    RedPacketService redPacketService;

    @Compensable(confirmMethod = "confirm", cancelMethod = "cancel")
    public void tryOrder(TransactionContext context, String orderName){
        System.out.println("try order");
        accountService.tryAccount(null, new Account());
        redPacketService.tryRedPacket(null, new RedPacket());
    }

    public void confirm(TransactionContext context, String orderName){
        System.out.println("confirm order");

    }

    public void cancel(TransactionContext context, String orderName){
        System.out.println("cancel order");

    }
}
