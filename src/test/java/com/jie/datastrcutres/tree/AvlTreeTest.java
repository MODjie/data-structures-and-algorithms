package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 二叉平衡树测试类
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月28日
 * @since 1.8
 */
public class AvlTreeTest {

    public static void main(String[] args) {
        int[] dataSource = new int[]{1,2,3,4,5,11,10,9,8,7,6};
//        int [] dataSource = new int[]{62,88,58,47,35,73,51,99,37,93};
        AvlTree avlTree = new AvlTree(dataSource);
        avlTree.middleSort();
//        System.out.println("树的高度"+avlTree.getHeight());
//        System.out.println("左子树的高度"+avlTree.getLeftChildHeight());
//        System.out.println("右子树的高度"+avlTree.getRightChildHeight());
    }

}
