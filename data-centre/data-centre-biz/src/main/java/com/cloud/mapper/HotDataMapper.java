package com.cloud.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.HotData;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cloud.param.HotDataParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-07-24
 */
@Repository
public interface HotDataMapper extends BaseMapper<HotData> {


    List<HotData> listQuery(HotDataParam queryParam);

}
