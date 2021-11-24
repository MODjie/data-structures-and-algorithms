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
public class ThreadedBinaryTree<T> {

    /**
     * 根节点
     */
    private ThreadedBinaryTreeNode<T> root;

    /**
     * 前驱节点
     */
    private ThreadedBinaryTreeNode<T> preNode;

    public ThreadedBinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(ThreadedBinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * <p>
     * Title: 中序线索化
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode
     * @author 刘小杰
     * @date 2021年11月24日
     * @since 1.8
     */
    public void middleSortCueing(ThreadedBinaryTreeNode<T> parentNode){
        if (parentNode == null){
            System.out.println("当前节点为空");
        }
        if (parentNode.getLeft()!=null){
            this.middleSortCueing(parentNode.getLeft());
        }
        //如果当前节点的左节点是空的，则将前驱节点赋值给这个左节点
        if (parentNode.getLeft() == null){
            parentNode.setLeft(preNode);
            parentNode.setLeftType(ThreadedBinaryTreeNode.THREADED_NODE);
        }
        //如果前驱节点不为空，并且前驱节点的右节点是空的，则将当前节点赋值给前驱节点的右节点
        if (preNode!=null && preNode.getRight() == null){
            preNode.setRight(parentNode);
            preNode.setRightType(ThreadedBinaryTreeNode.THREADED_NODE);
        }
        preNode = parentNode;
        if (parentNode.getRight()!=null){
            this.middleSortCueing(parentNode.getRight());
        }
    }

    /**
     * <p>
     * Title: 遍历线索二叉树
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author 刘小杰
     * @date 2021年11月24日
     * @since 1.8
     */
    public void list(){
        if (this.root == null){
            throw new RuntimeException("当前树为空");
        }
        ThreadedBinaryTreeNode<T> cursorNode = this.root;
        while (cursorNode != null){
            while (cursorNode.getLeftType() == ThreadedBinaryTreeNode.NORMAL_NODE){
                cursorNode = cursorNode.getLeft();
            }
            System.out.print(cursorNode+" ");
            while (cursorNode.getRightType() == ThreadedBinaryTreeNode.THREADED_NODE){
                cursorNode = cursorNode.getRight();
                System.out.print(cursorNode+" ");
            }
            cursorNode = cursorNode.getRight();
        }
    }
}
