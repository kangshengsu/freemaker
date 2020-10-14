package com.fm.business.base.listener;

import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.wx.message.impl.OrderStatusChangeMessageSender;
import com.fm.business.base.service.wx.message.impl.RecommendMessageSender;
import com.fm.framework.core.event.BatchOperationEvent;
import com.fm.framework.core.event.OperationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Service
public class DemandProductionListener implements ApplicationListener<BatchOperationEvent> {

    @Autowired
    private RecommendMessageSender recommendMessageSender;

    @Override
    public void onApplicationEvent(@NonNull BatchOperationEvent event) {
        switch (event.getType()) {
            case batch_save:
                if (event.getAfters().size() > 0 && event.getAfters().iterator().next() instanceof DemandProductionRelation) {
                    recommend((Collection<DemandProductionRelation>) event.getAfters());
                }
        }
    }

    private void recommend(Collection<DemandProductionRelation> demandProductionRelations) {
        //根据新的状态发送通知。
        recommendMessageSender.sendMessage(demandProductionRelations);
    }
}
