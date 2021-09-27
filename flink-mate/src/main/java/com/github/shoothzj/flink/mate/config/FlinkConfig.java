package com.github.shoothzj.flink.mate.config;

import com.github.shoothzj.flink.mate.module.DeployType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author hezhangjian
 */
@Configuration
@Service
public class FlinkConfig {

    @Value("${DEPLOY_TYPE:STANDALONE}")
    public DeployType deployType;

}
