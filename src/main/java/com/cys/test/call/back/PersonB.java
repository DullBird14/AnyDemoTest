package com.cys.test.call.back;

public class PersonB {


    public PersonB() {
    }

    public void doThink(CallBackInterface a){
        System.out.println("让我想一想");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.doCallBack("答案是5");
    }

    public static void main(String[] args) {
        PersonB b = new PersonB();
        PersonA a = new PersonA(b);
        a.askBQuestion();
    }
}
