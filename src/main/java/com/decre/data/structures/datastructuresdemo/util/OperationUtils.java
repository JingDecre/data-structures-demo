package com.decre.data.structures.datastructuresdemo.util;

/**
 * @className: OperationUtils
 * @description: 运算操作符工具类
 * @author: decre
 * @date: 2021/1/19
 **/
public class OperationUtils {
    // 运算符优先级
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}
