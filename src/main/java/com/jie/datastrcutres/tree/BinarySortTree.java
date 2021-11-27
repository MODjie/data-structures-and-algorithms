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
    public void add(TreeNode<Integer> addNode) {
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
        System.out.println();
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

    /**
     * <p>
     * Title: 删除
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param removeData 要删除的数据
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    public void remove(int removeData){
        if (this.rootNode == null){
            System.out.println("当前是空树");
            return;
        }
        this.doRemove(null,this.rootNode,removeData);
    }

    /**
     * <p>
     * Title: 执行删除操作
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param currentNode 当前节点
     * @param removeData 要删除的节点
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void doRemove(TreeNode<Integer> parentNode,TreeNode<Integer> currentNode,int removeData){
        int currentData = currentNode.getData();
        if (currentData == removeData){
            this.removeRecursion(parentNode,currentNode);
        }else if (removeData < currentData && currentNode.getLeft()!=null){
            this.doRemove(currentNode,currentNode.getLeft(),removeData);
        }else if (removeData > currentData && currentNode.getRight()!=null){
            this.doRemove(currentNode,currentNode.getRight(),removeData);
        }
    }

    /**
     * <p>
     * Title: 删除递归
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param targetNode 目标节点
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private void removeRecursion(TreeNode<Integer> parentNode,TreeNode<Integer> targetNode) {
        //目标节点是叶子节点，则直接移除
        if (targetNode.getLeft() == null && targetNode.getRight() == null){
            if (parentNode == null){
                this.rootNode = null;
            }else {
                if (parentNode.getLeft()!=null && parentNode.getLeft().equals(targetNode)){
                    parentNode.setLeft(null);
                }else if (parentNode.getRight() !=null && parentNode.getRight().equals(targetNode)){
                    parentNode.setRight(null);
                }
            }
        }else if (targetNode.getLeft() !=null && targetNode.getRight() == null){
            if (parentNode == null){
                this.rootNode = targetNode.getLeft();
            }else {
                if ( parentNode.getLeft().equals(targetNode)){
                    parentNode.setLeft(targetNode.getLeft());
                }else if (parentNode.getRight().equals(targetNode)){
                    parentNode.setRight(targetNode.getLeft());
                }
            }
        }else if (targetNode.getLeft() == null && targetNode.getRight()!=null){
            if (parentNode == null){
                this.rootNode = targetNode.getRight();
            }else {
                if ( parentNode.getLeft().equals(targetNode)){
                    parentNode.setLeft(targetNode.getRight());
                }else if (parentNode.getRight().equals(targetNode)){
                    parentNode.setRight(targetNode.getRight());
                }
            }
        }else {
            //从目标节点中序遍历，找到他的前驱或后继节点，代替目标节点(此处采用前驱节点，得到前驱节点的父节点)
            TreeNode<Integer> targetPreParentNode = this.findTargetParentPreNode(targetNode);
            TreeNode<Integer> targetPreNode = targetPreParentNode.getLeft();
            if (parentNode == null){
                if (targetPreNode.getRight()!=null){
                    targetPreParentNode.setLeft(targetPreNode.getRight());
                }else{
                    targetPreParentNode.setLeft(null);
                }
                targetPreNode.setLeft(this.rootNode.getLeft());
                targetPreNode.setRight(this.rootNode.getRight());
                this.rootNode = targetNode;
            }else {
                if (parentNode.getLeft().equals(targetNode)){
                    if (targetPreNode.getRight()!=null){
                        targetPreParentNode.setLeft(targetPreNode.getRight());
                    }else{
                        targetPreParentNode.setLeft(null);
                    }
                    targetPreNode.setLeft(targetNode.getLeft());
                    targetPreNode.setRight(targetNode.getRight());
                    parentNode.setLeft(targetPreNode);
                }else if (parentNode.getRight().equals(targetNode)){
                    if (targetPreNode.getRight()!=null){
                        targetPreParentNode.setLeft(targetPreNode.getRight());
                    }else{
                        targetPreParentNode.setLeft(null);
                    }
                    targetPreNode.setLeft(targetNode.getLeft());
                    targetPreNode.setRight(targetNode.getRight());
                    parentNode.setRight(targetPreNode);
                }
            }

        }

    }

    /**
     * <p>
     * Title: 获取目标节点的前驱节点的父节点
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param targetNode
     * @return com.jie.datastrcutres.tree.TreeNode<java.lang.Integer>
     * @author 刘小杰
     * @date 2021年11月27日
     * @since 1.8
     */
    private TreeNode<Integer> findTargetParentPreNode(TreeNode<Integer> targetNode) {
        if (targetNode.getLeft().getLeft()!=null){
            return this.findTargetParentPreNode(targetNode.getLeft());
        }
        return targetNode;
    }
}
