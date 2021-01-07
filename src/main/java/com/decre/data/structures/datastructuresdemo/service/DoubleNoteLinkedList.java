package com.decre.data.structures.datastructuresdemo.service;

import com.decre.data.structures.datastructuresdemo.entity.DoubleNote;

/**
 * @className: DoubleNoteLinkedList
 * @description: TODO 类描述
 * @author: decre
 * @date: 2021/1/7
 **/
public class DoubleNoteLinkedList implements LinkedList<DoubleNote>{
    /**
     * 头部节点
     */
    private DoubleNote head;

    public DoubleNoteLinkedList() {
        this.head = new DoubleNote(0, "", "");
    }

    @Override
    public void addNote(DoubleNote note) {
        DoubleNote temp = head;
        boolean flag = false; // 标识是否中途有序号大于加入节点的序号
        while (temp != null) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > note.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 按照序号中途插入数据
        if (flag) {
            note.setNext(temp.getNext());
        }
        note.setPre(temp);
        temp.setNext(note);


    }

    @Override
    public void updateNote(DoubleNote note) {
        if (head.getNext() == null) {
            System.out.println("链表为空，更新失败！");
            return;
        }
        DoubleNote temp = head.getNext();
        boolean flag = false;

        while (temp != null) {
            if (temp.getNo() == note.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(note.getName());
            temp.setNickName(note.getNickName());
        } else {
            System.out.println("未找到对应编号的链表节点，更新失败！");
        }
    }

    @Override
    public void delNote(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空，删除节点失败！");
            return;
        }
        DoubleNote temp = head.getNext();
        boolean flag = false;
        while (temp != null) {
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        temp.getPre().setNext(temp.getNext());
    }

    @Override
    public void showList() {
        DoubleNote temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    @Override
    public int getLength() {
        DoubleNote temp = head.getNext();
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public void reverse() {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        DoubleNote cur = head.getNext();
        DoubleNote next = null;
        DoubleNote reverse = new DoubleNote(0, "", "");
        while (cur != null) {
            next = cur.getNext();
            // pre暂时置空，下一次循环再添加
            cur.setPre(null);
            cur.setNext(reverse.getNext());
            reverse.setNext(cur);
            cur = next;
        }
        cur = reverse;
        // 设置pre
        while (cur.getNext() != null) {
            cur.getNext().setPre(cur);
            cur = cur.getNext();
        }
        head.setNext(reverse.getNext());
    }
}
