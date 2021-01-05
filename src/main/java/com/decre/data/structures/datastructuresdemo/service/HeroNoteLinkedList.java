package com.decre.data.structures.datastructuresdemo.service;

import com.decre.data.structures.datastructuresdemo.entity.HeroNote;

/**
 * @className: HeroNoteLinkedList
 * @description: 带头部的英雄单向链表
 * @author: decre
 * @date: 2021/1/5
 **/
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
}
