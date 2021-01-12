package com.fm.business.base.listener;

import com.fm.business.base.enums.DemandAttestationType;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.service.wx.message.impl.DemandExamineSender;
import com.fm.framework.core.event.OperationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author G
 * @date 2020/12/16 下午4:40
 */

@Service
public class ExamineStatusListener implements ApplicationListener<OperationEvent> {

    @Autowired
    private DemandExamineSender demandExamineSender;

    @Override
    public void onApplicationEvent(OperationEvent event) {

        switch (event.getType()) {
            case update:
                if (event.getBefore() instanceof DemandInfo || event.getAfter() instanceof DemandInfo) {
                    DemandInfo o2 = (DemandInfo) event.getAfter();
                    DemandInfo o1 = (DemandInfo) event.getBefore();
                    if (o1.getAttestation() != null &&!o1.getAttestation().equals(o2.getAttestation())) {
                        if (o1.getAttestation().equals(DemandAttestationType.NO_ATTESTATION.getCode()) &&
                                o2.getAttestation() != null){
                            changeStatus(o2);
                        }
                    }
                }

        }

    }

    private void changeStatus(DemandInfo demandInfo) {
        //根据新的状态发送通知。
        demandExamineSender.sendStatusChangeMessage(demandInfo);
    }
}
