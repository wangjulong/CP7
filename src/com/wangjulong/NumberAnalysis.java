package com.wangjulong;

/**
 * 号码分析类
 * Created by Administrator on 2016/9/20.
 */

abstract class NumberAnalysis {

    /**
     * 用于存储开奖号码数据
     * serial,title,n1,n2,n3,n4,n5,n6,n7
     */
    private static int[][] data;

    private InitDataInterface initDataInterface;

    public NumberAnalysis(InitDataInterface initDataInterface) {
        this.initDataInterface = initDataInterface;
    }

    /**
     * 入口方法，管理分析流程的方法
     * 本方法调用类的其他方法处理分析数据
     */

    void analysisMain() {

        // 第一步：初始化数据

        NumberAnalysis.data = initDataInterface.initData();


    }


}
