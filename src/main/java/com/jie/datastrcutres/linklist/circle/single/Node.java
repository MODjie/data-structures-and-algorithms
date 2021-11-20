package com.jie.datastrcutres.linklist.circle.single;

/**
 * <p>
 * Title: 环形单链表节点
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月20日
 * @since 1.8
 */
public class Node<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 下一个节点
     */
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
