package com.saltedfish.demogradleservice.service;

import com.saltedfish.demogradleservice.common.Constants;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by pengchongchong on 17-12-8.
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return StringUtils.isEmpty(name) ? Constants.getStringFromConfig("name") : name;
    }
}
