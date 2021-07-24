package com.cloud.service;

import com.cloud.cloudbaseutil.base.service.BaseServiceInterface;
import com.cloud.param.HotDataParam;
import com.cloud.entity.HotData;
import com.github.pagehelper.PageInfo;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-07-24
 */
public interface HotDataService extends BaseServiceInterface<HotData, HotDataParam, Long> {

    PageInfo<HotData> pageQuery(HotDataParam queryParam);

}
