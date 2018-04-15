package com.cys.boot.base;

import org.springframework.stereotype.Service;

@Service
class FunctionService {
    public String sayHello(String word) {
        return "Hello " + word + " !";
    }
}
