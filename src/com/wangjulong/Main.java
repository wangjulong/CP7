package com.wangjulong;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello CP7");

        InitDataOkhttp initDataOkhttp = new InitDataOkhttp();
        int[][] temp = initDataOkhttp.initData();

        for (int[] aTemp : temp) {

            System.out.print(aTemp[0] + " ");
            System.out.print(aTemp[1] + " ");
            System.out.print(aTemp[2] + " ");
            System.out.print(aTemp[3] + " ");
            System.out.print(aTemp[4] + " ");
            System.out.print(aTemp[5] + " ");
            System.out.print(aTemp[6] + " ");
            System.out.print(aTemp[7] + " ");
            System.out.println(aTemp[8]);
        }
    }
}
