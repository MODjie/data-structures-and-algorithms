package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 二叉排序树
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月26日
 * @since 1.8
 */
public class BinarySortTree {

    /**
     * 根节点
     */
    private TreeNode<Integer> rootNode;


    public BinarySortTree() {

    }

    public BinarySortTree(int[] dataSource) {

        this.createTree(dataSource);

    }

    /**
     * <p>
     * Title: 创建二叉排序树
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param dataSource 数据源
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void createTree(int[] dataSource) {
        for (int data : dataSource) {
            TreeNode<Integer> node = new TreeNode<>(data);
            this.add(node);
        }

    }

    /**
     * <p>
     * Title: add 插入
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param addNode 要插入的节点
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void add(TreeNode<Integer> addNode) {
        if (this.rootNode == null){
            this.rootNode = addNode;
            return;
        }
        this.addRecursion(this.rootNode,addNode);
    }

    /**
     * <p>
     * Title: 插入递归
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param addNode 要插入节点
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void addRecursion(TreeNode<Integer> parentNode, TreeNode<Integer> addNode) {
        if (addNode.getData()<=parentNode.getData()){
            if (parentNode.getLeft()==null){
                parentNode.setLeft(addNode);
                return;
            }
            this.addRecursion(parentNode.getLeft(),addNode);
        }else {
            if (parentNode.getRight()==null){
                parentNode.setRight(addNode);
                return;
            }
            this.addRecursion(parentNode.getRight(),addNode);
        }
    }

    /**
     * <p>
     * Title: 中序遍历
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    public void middleSort(){
        if (this.rootNode == null){
            System.out.println("当前是空树");
            return;
        }
        this.middleSortRecursion(this.rootNode);
    }

    /**
     * <p>
     * Title: 中序遍历递归
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param currentNode
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void middleSortRecursion(TreeNode<Integer> currentNode) {
        if (currentNode.getLeft()!=null){
            this.middleSortRecursion(currentNode.getLeft());
        }
        System.out.print(currentNode +" ");
        if (currentNode.getRight()!=null){
            this.middleSortRecursion(currentNode.getRight());
        }
    }
}
