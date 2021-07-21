package com.cloud.controller;

import com.cloud.cloudbaseutil.base.controller.GeneratorController;
import com.cloud.cloudbaseutil.base.service.SuperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class GeneratorDemoController implements GeneratorController<GeneratorDemoController.Generator> {


    @Override
    public Class<GeneratorDemoController.Generator> getEntityClass() {
        return null;
    }

    @Override
    public SuperService<GeneratorDemoController.Generator> getBaseService() {
        return null;
    }

    static class  Generator{

    }

}
