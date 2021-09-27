package com.github.shoothzj.flink.mate.service;

import com.github.shoothzj.flink.mate.constant.PathConst;
import com.github.shoothzj.flink.mate.config.FlinkConfig;
import com.github.shoothzj.javatool.util.ShellUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class LifecycleService {

    @Autowired
    private FlinkConfig flinkConfig;

    @PostConstruct
    public void init() throws Exception {
        // change config
        genConfig();
        // start flink
        startFlink();
    }

    /**
     *
     */
    public void genConfig() throws Exception {

    }

    public void startFlink() throws Exception {
        switch (flinkConfig.deployType) {
            case WORKER:
                ShellUtil.executeCmd("bash -x " + PathConst.FLINK_START_WORKER_SCRIPT);
                break;
            case MASTER:
                ShellUtil.executeCmd("bash -x " + PathConst.FLINK_START_MASTER_SCRIPT);
                break;
            case STANDALONE:
                ShellUtil.executeCmd("bash -x " + PathConst.FLINK_START_STAND_ALONE_SCRIPT);
                break;
            default:
                break;
        }
    }

}
