package com.fm.business.base.listener;

import com.fm.business.base.model.order.OrderInfo;
import com.fm.framework.core.event.OperationEvent;
import com.fm.framework.core.model.BaseModel;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 订单状态 Listener
 * @author hubo
 * @version 1.0.0
 **/
@Service
public class OrderStatusListener implements ApplicationListener<OperationEvent> {
    @Override

    public void onApplicationEvent(@NonNull OperationEvent event) {

        if(isOrderModel(event.getBefore()) || isOrderModel(event.getAfter())) {

            switch (event.getType()) {
                case save:
                    OrderInfo newOrder = (OrderInfo) event.getAfter();
                    changeStatus(newOrder);
                    break;
                case update:
                    OrderInfo o2 = (OrderInfo) event.getAfter();
                    OrderInfo o1 = (OrderInfo) event.getBefore();
                    if(!o1.getStatus().equals(o2.getStatus())) {
                        changeStatus(o2);
                    }
                    break;

            }

        }

    }

    private boolean isOrderModel(BaseModel model) {
        return Objects.nonNull(model) && model instanceof OrderInfo;
    }

    private void changeStatus(OrderInfo newStatusOrder) {

        //根据新的状态发送通知。

    }
}
