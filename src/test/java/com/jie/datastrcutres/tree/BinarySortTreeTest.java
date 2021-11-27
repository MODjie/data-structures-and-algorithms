package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 二叉排序树测试类
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月27日
 * @since 1.8
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {
        int [] dataSource = new int[]{62,88,58,47,35,73,51,99,37,93};
        BinarySortTree binarySortTree = new BinarySortTree(dataSource);
        binarySortTree.middleSort();
        binarySortTree.remove(93);
        binarySortTree.middleSort();
    }

}
