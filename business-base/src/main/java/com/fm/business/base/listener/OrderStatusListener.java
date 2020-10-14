package com.fm.business.base.listener;

import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.wx.message.impl.OrderStatusChangeMessageSender;
import com.fm.framework.core.event.OperationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * 订单状态 Listener
 *
 * @author hubo
 * @version 1.0.0
 **/
@Service
public class OrderStatusListener implements ApplicationListener<OperationEvent> {

    @Autowired
    private OrderStatusChangeMessageSender orderStatusChangeMessageSender;

    @Override
    public void onApplicationEvent(@NonNull OperationEvent event) {

        switch (event.getType()) {
            case save:
                if (event.getBefore() instanceof OrderInfo || event.getAfter() instanceof OrderInfo) {
                    OrderInfo newOrder = (OrderInfo) event.getAfter();
                    changeStatus(newOrder);
                    break;
                }
            case update:
                if (event.getBefore() instanceof OrderInfo || event.getAfter() instanceof OrderInfo) {
                    OrderInfo o2 = (OrderInfo) event.getAfter();
                    OrderInfo o1 = (OrderInfo) event.getBefore();
                    if (!o1.getStatus().equals(o2.getStatus())) {
                        changeStatus(o2);
                    }
                }
        }
    }

    private void changeStatus(OrderInfo newStatusOrder) {
        //根据新的状态发送通知。
        orderStatusChangeMessageSender.sendStatusChangeMessage(newStatusOrder);
    }


}
