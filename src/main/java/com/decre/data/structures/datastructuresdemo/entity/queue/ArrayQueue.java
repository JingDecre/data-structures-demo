package com.decre.data.structures.datastructuresdemo.entity.queue;

import lombok.Data;

@Data
public class ArrayQueue {
    // 队列最大容量
    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (maxSize - 1) == rear;
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
     * 添加队列数据
     *
     * @param n
     */
    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("当前队列已满！无法添加新数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 从队列获取数据
     *
     * @return
     */
    public int getData() {
        if(this.isEmpty()) {
            System.out.println("当前队列为空，无法获取数据！");
            return -1;
        }
        front++;
        return arr[front];
    }

    /**
     * 遍历获取队列当前所有未取出的值
     */
    public void show() {
        if (this.isEmpty()) {
            System.out.println("当前队列为空！");
            return;
        }
        System.out.println("输出队列尚未取出的值~~");
        for (int i = front; i < rear; i++) {

            System.out.printf("当前遍历队列值为:%d\n", arr[i + 1]);
        }
    }


    /**
     * 显示队列的头数据， 注意不是取出数据
     *
     * @return
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }



}
