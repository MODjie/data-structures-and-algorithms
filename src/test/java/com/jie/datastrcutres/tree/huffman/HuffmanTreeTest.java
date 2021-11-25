package com.jie.datastrcutres.tree.huffman;

/**
 * <p>
 * Title: 赫夫曼树测试类
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月25日
 * @since 1.8
 */
public class HuffmanTreeTest {

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree("i like like like java do you like a java");
        huffmanTree.createTree();
        huffmanTree.preSort();
    }

}
