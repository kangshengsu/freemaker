package com.fm.business.base.service.conf;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class IDisplayConfigServiceTest {

    @Autowired
    private IDisplayConfigService displayConfigService;

    @org.junit.Test
    public void getFirstLevelJobCateConfig() {

        List<BdJobCate> bdJobCateList = displayConfigService.getFirstLevelJobCateConfig();

        log.info("bdJobCateList: {}", bdJobCateList);
        assertEquals(1, bdJobCateList.size());

    }

    @org.junit.Test
    public void getSecondLevelJobCateConfig() {

        List<BdJobCate> bdJobCateList = displayConfigService.getSecondLevelJobCateConfig();

        log.info("bdJobCateList: {}", bdJobCateList);

        assertEquals(1, bdJobCateList.size());

    }

    @org.junit.Test
    public void getRecommendProductInfoConfig() {

        List<ProductionInfo> productionInfos = displayConfigService.getRecommendProductInfoConfig();

        log.info("productionInfos: {}", productionInfos);

        assertEquals(2, productionInfos.size());

    }
}