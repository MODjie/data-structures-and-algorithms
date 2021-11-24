package com.jie.datastrcutres.tree;

/**
 * <p>
 * Title: 二叉树
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 刘小杰
 * @date 2021年11月23日
 * @since 1.8
 */
public class BinaryTree<T> {

    /**
     * 根节点
     */
    private TreeNode<T> rootNode;

    public TreeNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * <p>
     * Title: 先序遍历
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 当前父节点
     * @author 刘小杰
     * @date 2021年11月23日
     * @since 1.8
     */
    public void preSort(TreeNode<T> parentNode){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        System.out.print(parentNode+" ");
        if (parentNode.getLeft()!=null){
            this.preSort(parentNode.getLeft());
        }
        if (parentNode.getRight()!=null){
            this.preSort(parentNode.getRight());
        }
    }

    /**
     * <p>
     * Title: 前序查找
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param searchNode 待查找节点
     * @param level 当前层级
     * @author 刘小杰
     * @date 2021年11月23日
     * @since 1.8
     */
    public void preSearch(TreeNode<T> parentNode,TreeNode<T> searchNode,int level){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        if (parentNode.equals(searchNode)){
            System.out.println("在第"+level+"层找到");
            return;
        }
        if (parentNode.getLeft()!=null){
            if (parentNode.getLeft().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的左节点找到");
                return;
            }
            this.preSearch(parentNode.getLeft(),searchNode,level+1);
        }
        if (parentNode.getRight()!=null){
            if (parentNode.getRight().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的右节点找到");
                return;
            }
            this.preSearch(parentNode.getRight(),searchNode,level+1);
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
     * @param parentNode 当前父节点
     * @author 刘小杰
     * @date 2021年11月23日
     * @since 1.8
     */
    public void middleSort(TreeNode<T> parentNode){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        if (parentNode.getLeft()!=null){
            this.middleSort(parentNode.getLeft());
        }
        System.out.print(parentNode+" ");
        if (parentNode.getRight()!=null){
            this.middleSort(parentNode.getRight());
        }
    }

    /**
     * <p>
     * Title: 中序查找
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param searchNode 待查找节点
     * @param level 当前层级
     * @author 刘小杰
     * @date 2021年11月24日
     * @since 1.8
     */
    public void middleSearch(TreeNode<T> parentNode,TreeNode<T> searchNode,int level){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        if (parentNode.getLeft()!=null){
            if (parentNode.getLeft().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的左节点找到");
                return;
            }
            this.preSearch(parentNode.getLeft(),searchNode,level+1);
        }
        if (parentNode.equals(searchNode)){
            System.out.println("在第"+level+"层找到");
            return;
        }
        if (parentNode.getRight()!=null){
            if (parentNode.getRight().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的右节点找到");
                return;
            }
            this.preSearch(parentNode.getRight(),searchNode,level+1);
        }
    }


    /**
     * <p>
     * Title: 后序遍历
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 当前父节点
     * @author 刘小杰
     * @date 2021年11月23日
     * @since 1.8
     */
    public void postSort(TreeNode<T> parentNode){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        if (parentNode.getLeft()!=null){
            this.postSort(parentNode.getLeft());
        }
        if (parentNode.getRight()!=null){
            this.postSort(parentNode.getRight());
        }
        System.out.print(parentNode+" ");
    }

    /**
     * <p>
     * Title: 后序查找
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param parentNode 父节点
     * @param searchNode 待查找节点
     * @param level 当前层级
     * @author 刘小杰
     * @date 2021年11月24日
     * @since 1.8
     */
    public void postSearch(TreeNode<T> parentNode,TreeNode<T> searchNode,int level){
        if (parentNode == null){
            System.out.println("当前树为空");
            return;
        }
        if (parentNode.getLeft()!=null){
            if (parentNode.getLeft().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的左节点找到");
                return;
            }
            this.preSearch(parentNode.getLeft(),searchNode,level+1);
        }
        if (parentNode.getRight()!=null){
            if (parentNode.getRight().equals(searchNode)){
                System.out.println("在第"+level+"层"+parentNode+"节点的右节点找到");
                return;
            }
            this.preSearch(parentNode.getRight(),searchNode,level+1);
        }
        if (parentNode.equals(searchNode)){
            System.out.println("在第"+level+"层找到");
            return;
        }
    }
}
