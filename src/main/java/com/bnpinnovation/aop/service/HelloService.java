package com.bnpinnovation.aop.service;

import com.bnpinnovation.aop.aspect.ArgumentLog;
import com.bnpinnovation.aop.aspect.CheckType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HelloService {
    void helloStrings(List<String> helloStrings);

    void helloString(String good);

    @Slf4j
    @Service("hello")
    class Default implements HelloService {

        @Override
        @ArgumentLog(dummy= CheckType.Multi)
        public void helloStrings(List<String> helloStrings) {
        }

        @Override
        @ArgumentLog(dummy = CheckType.Single)
        public void helloString(String good) {
        }
    }
}
