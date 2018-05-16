package com.cys.test.call.back;

public class PersonA implements CallBackInterface{
    private PersonB personB;

    public PersonA(PersonB person) {
        this.personB = person;
    }


    public void askBQuestion(){
        System.out.println("问你一个问题 1+4=？");
        new Thread(new Runnable() {
            @Override
            public void run() {
                personB.doThink(PersonA.this);
            }
        }).start();

        play();
    }

    private void play(){
        System.out.println("我还有事，我先去忙，我去去就回！！！！！！！");
    }

    @Override
    public void doCallBack(String answer) {
        System.out.println("B说" + answer);
    }
}
