package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 二叉平衡树
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月28日
 * @since 1.8
 */
public class AvlTree extends BinarySortTree {

    public AvlTree(int[] dataSource) {
        super(dataSource);
    }

    public AvlTree() {
    }

    /**
     * <p>
     * Title: 获取树的高度
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
    public int getHeight() {
        if (super.getRootNode() == null) {
            return 0;
        }
        return super.getRootNode().getHeight();
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
    public int getLeftChildHeight() {
        if (super.getRootNode() == null) {
            return 0;
        }
        return super.getRootNode().getLeftChildHeight();
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
    public int getRightChildHeight() {
        if (super.getRootNode() == null) {
            return 0;
        }
        return super.getRootNode().getRightChildHeight();
    }

    @Override
    protected void addRecursion(TreeNode<Integer> parentNode, TreeNode<Integer> addNode) {
        super.addRecursion(parentNode, addNode);
        //添加完节点后，需要判断树是否还平衡
        if (parentNode.getRightChildHeight() - parentNode.getLeftChildHeight() > 1) {
            System.out.println("右子树的高度-左子树高度>1，平衡被破坏，需要调整");
            //如果父节点右节点的左子树高度大于右子树的高度，则需要先右旋转，再左旋转
            TreeNode<Integer> rightNode = parentNode.getRight();
            if (rightNode!=null && rightNode.getLeftChildHeight() > rightNode.getRightChildHeight()) {
                this.rightRotate(rightNode);
            }
            this.leftRotate(parentNode);
        } else if (parentNode.getLeftChildHeight() - parentNode.getRightChildHeight() > 1) {
            System.out.println("左子树的高度-右子树高度>1，平衡被破坏，需要调整");
            //如果父节点的左节点右子树高度大于左子树的高度，则需要先左旋转，再右旋转
            TreeNode<Integer> leftNode = parentNode.getLeft();
            if (leftNode!=null &&leftNode.getRightChildHeight() > leftNode.getLeftChildHeight()) {
                this.leftRotate(leftNode);
            }
            this.rightRotate(parentNode);
        }
    }

    /**
     * <p>
     * Title: 左旋转
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param node
     * @author 刘小杰
     * @date 2021年11月28日
     * @since 1.8
     */
    private void leftRotate(TreeNode<Integer> node) {
        //定义一个新节点，值为当前节点的值
        TreeNode<Integer> newNode = new TreeNode<>(node.getData());
        //赋值新节点的左节点为当前节点的左节点
        newNode.setLeft(node.getLeft());
        //赋值新节点的右节点为当前节点的右节点的左节点
        newNode.setRight(node.getRight().getLeft());
        //赋值当前节点的值为它右节点的值
        node.setData(node.getRight().getData());
        //赋值当前节点的右节点为它右节点的右节点
        node.setRight(node.getRight().getRight());
        //赋值当前节点的左节点为新节点
        node.setLeft(newNode);
    }

    /**
     * <p>
     * Title: 右旋转（和左旋转是镜像操作）
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param node
     * @author 刘小杰
     * @date 2021年11月28日
     * @since 1.8
     */
    private void rightRotate(TreeNode<Integer> node) {
        //定义一个新节点，值为当前节点的值
        TreeNode<Integer> newNode = new TreeNode<>(node.getData());
        //赋值新节点的右节点为当前节点的右节点
        newNode.setRight(node.getRight());
        //赋值新节点的左节点为当前节点的左节点的右节点
        newNode.setLeft(node.getLeft().getRight());
        //赋值当前节点的值为它左节点的值
        node.setData(node.getLeft().getData());
        //赋值当前节点的左节点为它左节点的左节点
        node.setLeft(node.getLeft().getLeft());
        //赋值当前节点的右节点为新节点
        node.setRight(newNode);
    }
}
