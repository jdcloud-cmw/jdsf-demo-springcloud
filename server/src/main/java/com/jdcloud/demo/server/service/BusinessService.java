package com.jdcloud.demo.server.service;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @program: jdsf_demo_springcloud
 * @description: 业务实现类
 * @author: jdsf
 * @create: 2018-12-20 20:03
 **/
@Service
public class BusinessService {

    @Autowired
    private ConsulClient consulClient;

    public String getBusinessRandom(){
        Random random = new Random();
        int nextIt = random.nextInt();
        String nodeName = consulClient.getAgentSelf().getValue().getConfig().getNodeName();
        return  nodeName + ":::" + nextIt;
    }
}
