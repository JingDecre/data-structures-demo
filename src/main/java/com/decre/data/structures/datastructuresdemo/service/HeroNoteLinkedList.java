package com.decre.data.structures.datastructuresdemo.service;

import com.decre.data.structures.datastructuresdemo.entity.HeroNote;
import lombok.Data;

import java.util.Stack;

/**
 * @className: HeroNoteLinkedList
 * @description: 带头部的英雄单向链表
 * @author: decre
 * @date: 2021/1/5
 **/
@Data
public class HeroNoteLinkedList {

    private HeroNote head;

    /**
     * @description: 初始化链表
     * @return:
     * @author: decre
     * @date: 2021/1/5
     * @Param
     */
    public HeroNoteLinkedList() {
        this.head = new HeroNote(0, "", "");
    }

    /**
     * 按顺序添加节点
     *
     * @param heroNote
     */
    public void addNote(HeroNote heroNote) {
        HeroNote temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > heroNote.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            heroNote.setNext(temp.getNext());
        }
        temp.setNext(heroNote);
    }

    /**
     * 更新节点
     *
     * @param heroNote
     */
    public void updateNote(HeroNote heroNote) {
        HeroNote temp = head;
        boolean hasNo = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == heroNote.getNo()) {
                hasNo = true;
                break;
            }
            temp = temp.getNext();
        }
        if (!hasNo) {
            throw new RuntimeException("序号" + heroNote.getNo() + "的英雄节点不存在，无法更新!");
        }
        temp.getNext().setName(heroNote.getName());
        temp.getNext().setNickName(heroNote.getNickName());
    }

    /**
     * 根据序号删除节点
     *
     * @param no
     */
    public void delNote(int no) {
        HeroNote temp = head;
        boolean hasNo = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                hasNo = true;
                break;
            }
            temp = temp.getNext();
        }
        if (!hasNo) {
            throw new RuntimeException("序号[" + no + "]的英雄节点不存在无法删除!");
        }
        // 将下一个节点失去引用，让垃圾回收器自动回收，即视为删除
        temp.setNext(temp.getNext().getNext());

    }

    /**
     * 展示链表
     */
    public void showList() {
        HeroNote temp = head;
        if (temp.getNext() == null) {
            throw new RuntimeException("英雄单项链表为空！");
        }
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            System.out.printf("序号[%d]英雄名字：%s, 昵称：%s\n", temp.getNo(), temp.getName(), temp.getNickName());
        }
    }

    /**
     * 获取链表有效数量
     *
     * @return
     */
    public int getLength() {
        HeroNote temp = head;
        int length = 0;
        while (temp.getNext() != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 获取倒数第index节点数据
     *
     * @param index
     * @return
     */
    public HeroNote findLastIndexNote(int index) {
        int length = getLength();
        // 当传入的下标越界返回空
        if (length <= 0 || index > length) {
            return null;
        }
        HeroNote result = head;
        int endIndex = length - index + 1;
        int tempIndex = 0;
        while (result.getNext() != null) {
            tempIndex++;
            result = result.getNext();
            if (tempIndex >= endIndex) {
                break;
            }
        }
        return result;

    }

    /**
     * 链表反转
     */
    public void reverse() {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        HeroNote cur = head.getNext();
        HeroNote reverseNote = new HeroNote(0, "", "");
        HeroNote next = null;
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(reverseNote.getNext());
            reverseNote.setNext(cur);
            cur = next;
        }
        head.setNext(reverseNote.getNext());

    }

    /**
     * 使用stack倒叙输出
     */
    public void reversePrint() {
        if (head.getNext() == null) {
            return;
        }
        Stack<HeroNote> stack = new Stack<>();
        HeroNote temp = head.getNext();
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }
        while (!stack.empty())  {
            System.out.println(stack.pop());
        }

    }

    /**
     * 两个链表合并
     *
     * @param heroNoteLinkedList
     * @return
     */
    public void addAll(HeroNoteLinkedList heroNoteLinkedList) {
        HeroNote temp = heroNoteLinkedList.getHead();
        if (temp.getNext() == null) {
            return;
        }
        HeroNote cur = temp.getNext();
        HeroNote next = null;
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(null);
            this.addNote(cur);
            cur = next;
        }

    }

}
