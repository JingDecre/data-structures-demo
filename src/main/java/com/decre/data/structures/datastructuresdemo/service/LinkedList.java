package com.decre.data.structures.datastructuresdemo.service;

/**
 * 节点接口
 *
 * @param <T>
 */
public interface LinkedList<T> {

    /**
     * 添加节点
     *
     * @param note
     */
    void addNote(T note);

    /**
     * 更新节点
     *
     * @param note
     */
    void updateNote(T note);

    /**
     * 删除指定编号的节点
     * @param no
     */
    void delNote(int no);

    /**
     * 展示所有节点数据
     */
    void showList();

    /**
     * 获取链表有效数量
     *
     * @return
     */
    int getLength();

    /**
     * 链表反转
     */
    void reverse();

}
