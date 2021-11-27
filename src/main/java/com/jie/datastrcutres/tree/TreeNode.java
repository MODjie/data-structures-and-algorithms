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

    /**
     * <p>
     * Title: 获取当前节点的高度
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int
     * @author 刘小杰
     * @date 2021年11月28日
     * @since 1.8
     */
    public int getHeight(){
        return Math.max(this.left == null ? 0 : this.left.getHeight(),this.right == null ? 0: this.right.getHeight()) +1;
    }


    /**
     * <p>
     * Title: 获取左子树的高度
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int
     * @author 刘小杰
     * @date 2021年11月28日
     * @since 1.8
     */
    public int getLeftChildHeight(){
        if (this.left == null){
            return 0;
        }
        return this.left.getHeight();
    }

    /**
     * <p>
     * Title: 获取右子树的高度
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int
     * @author 刘小杰
     * @date 2021年11月28日
     * @since 1.8
     */
    public int getRightChildHeight(){
        if (this.right == null){
            return 0;
        }
        return this.right.getHeight();
    }

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
