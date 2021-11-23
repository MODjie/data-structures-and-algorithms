package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 树节点
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 刘小杰
 * @date 2021年11月23日
 * @since 1.8
 */
public class TreeNode<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 左节点
     */
    private TreeNode<T> left;

    /**
     * 右节点
     */
    private TreeNode<T> right;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
