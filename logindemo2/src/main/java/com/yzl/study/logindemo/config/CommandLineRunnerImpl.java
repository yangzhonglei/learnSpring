package com.yzl.study.logindemo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n\n======application start success======\n\n\n\n");
    }
}