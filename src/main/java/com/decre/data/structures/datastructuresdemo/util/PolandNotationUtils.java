package com.decre.data.structures.datastructuresdemo.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @className: PolandNotation
 * @description: 逆波兰表达式工具类
 * @author: decre
 * @date: 2021/1/19
 **/
public class PolandNotationUtils {

    private static String positiveRegex = "^\\d+(\\.\\d+)?$";

    private static String leftParenthesis = "(";
    private static String rightParenthesis = ")";

    /**
     * 根据逆波兰表达式计算结果
     *
     * @param expresionList
     * @return
     */
    public static Double calculateByPoland(List<String> expresionList) {
        if (CollectionUtils.isEmpty(expresionList)) {
            throw new RuntimeException("错误的逆波兰表达式");
        }
        Stack<String> stack = new Stack<>(); // 存放数值的栈
        expresionList.forEach(item -> {
            if (item.matches(positiveRegex)) {
                stack.push(item);
            } else {
                double val;
                double n1 = Double.parseDouble(stack.pop());
                double n2 = Double.parseDouble(stack.pop());
                switch (item) {
                    case "+":
                        val = n1 + n2;
                        break;
                    case "-":
                        val = n2 - n1;
                        break;
                    case "*":
                        val = n1 * n2;
                        break;
                    case "/":
                        val = n2 / n1;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                //把val 入栈
                stack.push("" + val);
            }
        });
        return Double.parseDouble(stack.pop());
    }

    /**
     * 中缀表达式的list转成后缀表达式的list
     *
     * @param infixExpressionList
     * @return
     */
    public static List<String> parseInfixToSuffixExpreesionList(List<String> infixExpressionList) {
        Stack<String> signStack = new Stack<>();
        List<String> list = new ArrayList<>(infixExpressionList.size());
        infixExpressionList.forEach(item -> {
            if (item.matches(positiveRegex)) {
                list.add(item);
            } else if (leftParenthesis.equals(item)) {
                signStack.push(item);
            } else if (rightParenthesis.equals(item)) { // 遇到括号则删除括号对
                while (!leftParenthesis.equals(signStack.peek())) {
                    list.add(signStack.pop());
                }
                signStack.pop(); // 移除括号队
            } else {
                //当item的优先级小于等于signStack栈顶运算符, 将s1栈顶的运算符弹出并加入到list中
                if (!signStack.isEmpty() && OperationUtils.getValue(item) <= OperationUtils.getValue(signStack.peek())) {
                    list.add(signStack.pop());
                }
                signStack.push(item);
            }
        });
        // 最后将signStack的剩余符号压入list中
        while (!signStack.isEmpty()) {
            list.add(signStack.pop());
        }
        return list;
    }


    /**
     * 中缀表达式字符串转list
     * 中缀表达式如： (（1 + 2） * 5  + 10) / 5  => [(, (, 1, 2, +, ) *, 5, +, 10, ), /, 5]
     *
     * @param expression
     * @return
     */
    public static List<String> expressionStringToList(String expression) {
        expression = expression.replace(" ", "");
        int length = expression.length();
        List<String> list = new ArrayList<>(length);
        int i = 0;
        String str;
        char c;
        do {
            if ((c = expression.charAt(i)) != 46 && ((c = expression.charAt(i)) < 48 ||  (c = expression.charAt(i)) > 57)) { // 如果不是数也不是小数
                list.add("" + c);
                i++;
            } else { //如果是一个数，需要考虑多位数
                str = "";
                if (c == 46) {
                    throw new RuntimeException("存在无效的小数点!");
                }
                while (i < length && (((c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) || ((c = expression.charAt(i)) == 46)) ) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < length);
        return list;
    }
}
