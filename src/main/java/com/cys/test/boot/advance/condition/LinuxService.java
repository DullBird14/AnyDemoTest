package com.cys.test.boot.advance.condition;

public class LinuxService implements ConditionService {

    @Override
    public String fileListCommand() {
        return "ls";
    }
}
