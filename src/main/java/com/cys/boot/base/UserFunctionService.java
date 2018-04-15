package com.cys.boot.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserFunctionService {
    @Autowired
    FunctionService functionService;

    public String sayHello (String word) {
        return functionService.sayHello(word);
    }
}
