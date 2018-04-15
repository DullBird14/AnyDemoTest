package com.cys.test.boot.advance.condition;

public class WindowsService implements ConditionService {

    @Override
    public String fileListCommand() {
        return "dir";
    }
}
