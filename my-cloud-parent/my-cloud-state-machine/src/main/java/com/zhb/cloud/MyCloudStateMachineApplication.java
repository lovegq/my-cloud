package com.zhb.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import com.zhb.cloud.constants.Events;
import com.zhb.cloud.constants.States;

@SpringBootApplication
public class MyCloudStateMachineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudStateMachineApplication.class, args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... strings) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
