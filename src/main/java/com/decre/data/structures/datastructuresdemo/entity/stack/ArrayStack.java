package com.decre.data.structures.datastructuresdemo.entity.stack;

import lombok.Data;

import java.util.stream.IntStream;

/**
 * @className: ArrayStack
 * @description:  数组栈对象
 * @author: decre
 * @date: 2021/1/19
 **/
@Data
public class ArrayStack {

    /**
     * 栈最大容量
     */
    private int maxSize;

    /**
     * 存放栈节点的数组
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    /**
     * 栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 初始化栈
     *
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 往栈里面推入数据
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，添加数据失败");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     *出栈，将栈顶数据弹出
     *
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("获取数据失败，栈顶为空!");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        // 遍历输出现有栈元素
        IntStream.iterate(top, i->i - 1).limit(top + 1).forEach(i -> System.out.printf("stack[%d] = %d\n", i, stack[i]));

    }
}
