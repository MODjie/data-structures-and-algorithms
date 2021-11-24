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
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        TreeNode<String> rootNode = new TreeNode<>("A");
        TreeNode<String> node1 = new TreeNode<>("B");
        TreeNode<String> node2 = new TreeNode<>("C");
        TreeNode<String> node3 = new TreeNode<>("D");
        TreeNode<String> node4 = new TreeNode<>("E");
        TreeNode<String> node5 = new TreeNode<>("F");
        TreeNode<String> node6 = new TreeNode<>("G");
        TreeNode<String> node7 = new TreeNode<>("H");
        TreeNode<String> node8 = new TreeNode<>("I");
        binaryTree.setRootNode(rootNode);
        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node3.setLeft(node6);
        node3.setRight(node7);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setRight(node8);
        System.out.println("先序遍历：");
        binaryTree.preSort(rootNode);
        System.out.println();
        System.out.println("中序遍历：");
        binaryTree.middleSort(rootNode);
        System.out.println();
        System.out.println("后序遍历：");
        binaryTree.postSort(rootNode);
        System.out.println();

        System.out.println("先序查找：");
        binaryTree.preSearch(rootNode, node2, 1);
        System.out.println("中序查找：");
        binaryTree.middleSearch(rootNode, node2, 1);
        System.out.println("后序查找：");
        binaryTree.postSearch(rootNode, node2, 1);
    }

}
