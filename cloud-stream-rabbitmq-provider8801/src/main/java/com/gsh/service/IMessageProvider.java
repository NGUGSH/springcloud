package com.gsh.service;

import org.springframework.cloud.stream.annotation.EnableBinding;


public interface IMessageProvider {
    public String send();
}
