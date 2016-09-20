package com.wangjulong;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Okhttp 获取网络内容
 * Created by Administrator on 2016/9/20.
 */
class InitDataOkhttp implements InitDataInterface {

    // Okhttp 官方示例代码
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    @Override
    public int[][] initData() {

        InitDataOkhttp initDataOkhttp = new InitDataOkhttp();

        try {
            // 获取网页内容
            String response = initDataOkhttp.run("http://trend.caipiao.163.com/qlc/?periodNumber=100");

            // 处理获得的网页内容 返回整形数组(开奖号码的二维数组)
            return this.strToIntArray(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 处理得到的网页内容
     *
     * @param str 网页内容
     * @return int[][] 二维数组：int[开奖期数][serial,title,n1,n2,n3,n4,n5,n6,n7]
     */
    private int[][] strToIntArray(String str) {

        String[] arr0 = str.split("data-period=\"");

        // 临时变量
        int s0, n1, n2, n3, n4, n5, n6, n7;
        int serial = 0;

        // 循环字符串数组
        for (String abc : arr0) {
            // 正则表达式匹配开始的8个字符是否是数字，更新数据库
            // 2016011" data-award="05 07 10 13 21 25 27:09">
            if (abc.substring(0, 7).matches("\\d{7}")) {
                s0 = Integer.parseInt(abc.substring(0, 7));
                n1 = Integer.parseInt(abc.substring(21, 23));
                n2 = Integer.parseInt(abc.substring(24, 26));
                n3 = Integer.parseInt(abc.substring(27, 29));
                n4 = Integer.parseInt(abc.substring(30, 32));
                n5 = Integer.parseInt(abc.substring(33, 35));
                n6 = Integer.parseInt(abc.substring(36, 38));
                n7 = Integer.parseInt(abc.substring(39, 41));
                serial++;

                System.out.println(Integer.parseInt(abc.substring(0, 7)));
                System.out.println(Integer.parseInt(abc.substring(21, 23)));
                System.out.println(Integer.parseInt(abc.substring(24, 26)));
                System.out.println(Integer.parseInt(abc.substring(27, 29)));
                System.out.println(Integer.parseInt(abc.substring(30, 32)));
                System.out.println(Integer.parseInt(abc.substring(33, 35)));
                System.out.println(Integer.parseInt(abc.substring(36, 38)));
                System.out.println(Integer.parseInt(abc.substring(39, 41)));
            }
        }
        return null;
    }
}
