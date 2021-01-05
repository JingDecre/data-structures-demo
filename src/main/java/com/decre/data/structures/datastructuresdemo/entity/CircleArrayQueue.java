package com.decre.data.structures.datastructuresdemo.entity;

import lombok.Data;

@Data
public class CircleArrayQueue {

    private int maxSize;

    private int front;

    private int rear; // 队列尾部不存储数据

    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize; // 队列的有效数据最大是maxSize - 1
        arr = new int[maxSize];
    }

    /**
     * 队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return  (rear + 1) % maxSize == front;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 队列添加数据
     */
    public void addQueue(int val) {
        if (isFull()) {
            System.out.printf("队列已满，数据无法添加!");
            return;
        }
        arr[rear] = val;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出队列数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 1
        // front = 2
        // maxSize = 5
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }

}
