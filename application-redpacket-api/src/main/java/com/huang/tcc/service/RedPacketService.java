package com.huang.tcc.service;

import com.huang.tcc.bean.RedPacket;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

/**
 * Description:
 * Created on 2018/1/29 22:28
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
public interface RedPacketService {

    @Compensable
    public void tryRedPacket(TransactionContext context, RedPacket redpacket);

    @Compensable
    public void confirm(TransactionContext context, RedPacket redpacket);

    @Compensable
    public void cancel(TransactionContext context, RedPacket redpacket);
}
