package com.wangjulong;

/**
 * 数据初始化的接口
 * 返回类型：int[期数][2+7]
 *      第一维：开奖号码的期数
 *      第二维：serial(序号)，title(期号)，n1,n2,n3,n4,n5,n6,n7
 * Created by Administrator on 2016/9/20.
 */
interface InitDataInterface {
    int[][] initData();
}
