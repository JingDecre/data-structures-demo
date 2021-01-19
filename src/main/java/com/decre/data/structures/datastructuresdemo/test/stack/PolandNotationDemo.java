package com.decre.data.structures.datastructuresdemo.test.stack;

import com.decre.data.structures.datastructuresdemo.util.PolandNotationUtils;

import java.util.List;

/**
 * @className: PolandNotationDemo
 * @description: 逆波兰表达式测试类
 * @author: decre
 * @date: 2021/1/19
 **/
public class PolandNotationDemo {

    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
        //2. 因为直接对str 进行操作，不方便，因此 先将  "1+((2+3)×4)-5" =》 中缀的表达式对应的List
        //   即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]

        String expression = "1 + ((2.2+3 )*4)-5";//注意表达式
        List<String> infixExpressionList = PolandNotationUtils.expressionStringToList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = PolandNotationUtils.parseInfixToSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.printf("expression=%f", PolandNotationUtils.calculateByPoland(suffixExpreesionList)); // ?
    }
}
