package com.jie.datastrcutres.tree.huffman;

/**
 * <p>
 * Title: 赫夫曼树节点
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月25日
 * @since 1.8
 */
public class HuffmanTreeNode<T> {

    /**
     * 数据
     */
    private T data;
    /**
     * 权重
     */
    private int weightValue;
    /**
     * 左节点
     */
    private HuffmanTreeNode<T> leftNode;
    /**
     * 右节点
     */
    private HuffmanTreeNode<T> rightNode;

    public HuffmanTreeNode(T data, int weightValue) {
        this.data = data;
        this.weightValue = weightValue;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    public HuffmanTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HuffmanTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public HuffmanTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(HuffmanTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "data=" + data +
                ", weightValue=" + weightValue +
                '}';
    }
}
