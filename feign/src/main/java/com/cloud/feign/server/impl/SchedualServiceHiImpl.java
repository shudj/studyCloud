package com.cloud.feign.server.impl;

import com.cloud.feign.server.SchedualServiceHi;
import org.springframework.stereotype.Service;

/**
 * @author: shudj
 * @time: 2019/6/13 18:19
 * @description:
 */
@Service("schedualServiceHi")
public class SchedualServiceHiImpl implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return null;
    }
}
