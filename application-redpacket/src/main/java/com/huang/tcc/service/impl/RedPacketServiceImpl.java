package com.huang.tcc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huang.tcc.bean.RedPacket;
import com.huang.tcc.service.RedPacketService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

/**
 * Description:
 * Created on 2018/1/29 22:32
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Override
    @Compensable(confirmMethod = "confirm", cancelMethod = "cancel")
    public void tryRedPacket(TransactionContext context, RedPacket redpacket) {
        System.out.println("try RedPacket");
    }

    @Override
    public void confirm(TransactionContext context, RedPacket redpacket) {
        System.out.println("confirm RedPacket");
    }

    @Override
    public void cancel(TransactionContext context, RedPacket redpacket) {
        System.out.println("cancel RedPacket");
    }
}
