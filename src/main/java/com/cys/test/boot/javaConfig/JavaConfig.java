package com.cys.test.boot.javaConfig;

import org.springframework.context.annotation.Bean;

class JavaConfig {
    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UserFunctionService userFunctionService(FunctionService functionService){
        UserFunctionService userFunctionService = new UserFunctionService();
        userFunctionService.setFunctionService(functionService);
        return userFunctionService;
    }
}
