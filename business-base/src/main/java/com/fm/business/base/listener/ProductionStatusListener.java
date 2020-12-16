package com.fm.business.base.listener;

import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.wx.message.impl.ProductionStatusSender;
import com.fm.framework.core.event.OperationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author G
 * @date 2020/12/16 下午7:04
 */
@Service
public class ProductionStatusListener implements ApplicationListener<OperationEvent> {

    @Autowired
    private ProductionStatusSender productionStatusSender;

    @Override
    public void onApplicationEvent(OperationEvent event) {

        switch (event.getType()) {
            case update:
                if (event.getBefore() instanceof ProductionInfo || event.getAfter() instanceof ProductionInfo) {
                    ProductionInfo o2 = (ProductionInfo) event.getAfter();
                    ProductionInfo o1 = (ProductionInfo) event.getBefore();
                    if (!o1.getStatus().equals(o2.getStatus())) {
                        if (o2.getStatus().equals(ProductionStatus.RELEASE.getCode()) || o2.getStatus().equals(ProductionStatus.REVIEW_NOT_PASS.getCode())){
                            o2.setFreelancerId(o1.getFreelancerId());
                            changeStatus(o2);
                        }
                    }
                }

        }

    }

    private void changeStatus(ProductionInfo productionInfo) {
        //根据新的状态发送通知。
        productionStatusSender.sendStatusChangeMessage(productionInfo);
    }
}
