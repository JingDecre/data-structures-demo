package com.decre.data.structures.datastructuresdemo.service.linkedlist;

import com.decre.data.structures.datastructuresdemo.entity.linkedlist.JosephuNote;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * @className: JosephuLinkedList
 * @description: TODO 类描述
 * @author: decre
 * @date: 2021/1/12
 **/
@Data
public class JosephuLinkedList {

    private JosephuNote first = new JosephuNote(-1);

    /**
     * 生成指定大小的约瑟夫环形链表
     *
     * @param nums
     */
    public void produceJosephu(int nums) {
        if (nums < 1) {
            return;
        }
        AtomicReference<JosephuNote> curNote = new AtomicReference<>();
        IntStream.range(1, nums + 1).forEach(i -> {
            JosephuNote tempNote = new JosephuNote(i);
            if (i == 1) {
                first = tempNote;
                first.setNext(first);
                curNote.set(first);
            } else {
                curNote.get().setNext(tempNote);
                tempNote.setNext(first);
                curNote.set(tempNote);
            }
        });
    }

    /**
     * 打印所有节点信息
     */
    public void showNotes() {
        if (first.getNext() == null) {
            return;
        }

        JosephuNote curNote = first;
        while (true) {
            System.out.println(curNote);
            if (first.equals(curNote.getNext())) {
                break;
            }
            curNote = curNote.getNext();
        }
    }

    /**
     *
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少小孩在圈中
     */
    public void countNote(int startNo, int countNum, int nums) {
        if (first.getNext() == null || startNo < 1 || startNo > nums) {
            return;
        }
        // 辅助节点
        JosephuNote helper = first;
        //  辅助节点初始化指向最后一个节点
        while (true) {
            if (first.equals(helper.getNext())) {
                break;
            }
            helper = helper.getNext();
        }
        // 头节点和辅助节点同时向后移动startNo - 1 个位置
        JosephuNote finalHelper = helper;
        IntStream.range(1, startNo).forEach(i -> {
            first.setNext(first.getNext());
            finalHelper.setNext(finalHelper.getNext());
        });

        while (true) {
            // 当辅助节点 等于头节点，表示链表里面只剩最后一个数据
            if (first.equals(helper)) {
                break;
            }
            // 数数，当到达countNum跳出循环
            for (int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("节点%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的节点编号%d \n", first.getNo());

    }

}
