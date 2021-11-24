package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: BinarryTreeTest
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 刘小杰
 * @date 2021年11月23日
 * @since 1.8
 */
public class ThreadedBinaryTreeTest {

    public static void main(String[] args) {
        ThreadedBinaryTree<String> threadedBinaryTree = new ThreadedBinaryTree<>();
        ThreadedBinaryTreeNode<String> rootNode = new ThreadedBinaryTreeNode<>("A");
        ThreadedBinaryTreeNode<String> node1 = new ThreadedBinaryTreeNode<>("B");
        ThreadedBinaryTreeNode<String> node2 = new ThreadedBinaryTreeNode<>("C");
        ThreadedBinaryTreeNode<String> node3 = new ThreadedBinaryTreeNode<>("D");
        ThreadedBinaryTreeNode<String> node4 = new ThreadedBinaryTreeNode<>("E");
        ThreadedBinaryTreeNode<String> node5 = new ThreadedBinaryTreeNode<>("F");
        ThreadedBinaryTreeNode<String> node6 = new ThreadedBinaryTreeNode<>("G");
        ThreadedBinaryTreeNode<String> node7 = new ThreadedBinaryTreeNode<>("H");
        ThreadedBinaryTreeNode<String> node8 = new ThreadedBinaryTreeNode<>("I");
        threadedBinaryTree.setRoot(rootNode);
        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node3.setLeft(node6);
        node3.setRight(node7);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setRight(node8);
        System.out.println("中序线索化：");
        threadedBinaryTree.middleSortCueing(rootNode);
        System.out.println();
    }

}
