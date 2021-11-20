package com.jie.datastrcutres.linklist.circle.single;


/**
 * <p>
 * Title: 环形单链表
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月20日
 * @since 1.8
 */
public class CircleSingleLinkList<T> {

    /**
     * 链表第一个元素
     */
    private Node<T> first;

    /**
     * 链表大小
     */
    private int size;

    public CircleSingleLinkList() {
    }

    /**
     * <p>
     * Title: 添加元素
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param data 待插入数据
     * @author 刘小杰
     * @date 2021年11月20日
     * @since 1.8
     */
    public void add(T data) {
        if (data == null) {
            throw new RuntimeException("传入数据不能为空");
        }
        if (this.isEmpty()) {
            this.first = new Node<T>(data,this.first);
            size++;
            return;
        }
        Node<T> addNode = new Node<>(data, this.first);
        this.get(size-1).setNext(addNode);
        size++;
    }

    /**
     * <p>
     * Title: 更新某个位置的元素
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param data 数据
     * @param index 更新位置
     * @author 刘小杰
     * @date 2021年11月20日
     * @since 1.8
     */
    public void update(T data, int index){
        if (data == null) {
            throw new RuntimeException("传入数据不能为空");
        }
        if (this.isEmpty()) {
            throw new RuntimeException("当前链表为空");
        }
        if (index > size -1){
            throw new RuntimeException("超出当前链表长度："+size);
        }
        Node<T> oldNode = this.get(index);
        Node<T> updateNode = new Node<>(data,oldNode.getNext());
        this.get(index-1).setNext(updateNode);
    }

    /**
     * <p>
     * Title: get
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param index 索引
     * @return com.jie.datastrcutres.linklist.circle.single.Node<T>
     * @author 刘小杰
     * @date 2021年11月20日
     * @since 1.8
     */
    public Node<T> get(int index){
        if (this.isEmpty()) {
            throw new RuntimeException("当前链表为空");
        }
        if (index > size -1){
            throw new RuntimeException("超出当前链表长度："+size);
        }
        Node<T> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (i == index){
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * <p>
     * Title: 根据索引删除元素
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param index 删除位置索引
     * @author 刘小杰
     * @date 2021年11月20日
     * @since 1.8
     */
    public void delete(int index){
        if (this.isEmpty()) {
            throw new RuntimeException("当前链表为空");
        }
        if (index > size -1){
            throw new RuntimeException("超出当前链表长度："+size);
        }
        Node<T> preNode = this.get(index-1);
        Node<T> nextNode = preNode.getNext().getNext();
        preNode.setNext(nextNode);
        size--;
    }


    /**
     * <p>
     * Title: 链表是否为空
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return boolean
     * @author 刘小杰
     * @date 2021年11月20日
     * @since 1.8
     */
    public boolean isEmpty(){
        return this.first == null;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> temp = this.first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.getData());
            if (i!=size-1){
                stringBuilder.append(",");
            }
            temp = temp.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
