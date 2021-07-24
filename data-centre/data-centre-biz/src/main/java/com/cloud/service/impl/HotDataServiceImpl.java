package com.cloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.HotDataParam;
import com.cloud.entity.HotData;
import com.cloud.mapper.HotDataMapper;
import com.cloud.service.HotDataService;


import java.util.List;

import org.springframework.stereotype.Service;


import java.util.Map;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-07-24
 */
@Service
public class HotDataServiceImpl implements HotDataService {


    @Autowired
        HotDataMapper hotDataMapper;

    @Override
    public int save(HotData entity) {
        return hotDataMapper.insert(entity);
    }

    @Override
    public int update(HotData entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return hotDataMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return hotDataMapper.deleteById(id);
    }

    @Override
    public HotData getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return hotDataMapper.selectById(id);
    }

    @Override
    public PageInfo<HotData> pageQuery(HotDataParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> hotDataMapper.listQuery(queryParam));
    }


}
