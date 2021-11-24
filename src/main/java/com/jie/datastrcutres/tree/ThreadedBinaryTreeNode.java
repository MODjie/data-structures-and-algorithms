package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 线索二叉树
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 刘小杰
 * @date 2021年11月24日
 * @since 1.8
 */
public class ThreadedBinaryTreeNode<T> {

    /**
     * 是否线索节点
     */
    public static final int THREADED_NODE = 1;
    /**
     * 是否普通节点
     */
    public static final int NORMAL_NODE = 0;

    /**
     * 数据
     */
    private T data;

    /**
     * 左节点
     */
    private ThreadedBinaryTreeNode<T> left;

    /**
     * 右节点
     */
    private ThreadedBinaryTreeNode<T> right;

    /**
     * 左节点类型 0:左节点，1：前驱节点
     */
    private int leftType;

    /**
     * 右节点类型 0：右节点，1：后继节点
     */
    private int rightType;

    public ThreadedBinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadedBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode<T> left) {
        this.left = left;
    }

    public ThreadedBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
