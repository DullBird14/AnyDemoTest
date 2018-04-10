package com.cys.test.boot.base.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
class DemoPrototypeService {

}
