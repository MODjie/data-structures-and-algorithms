package com.jie.datastrcutres.tree.huffman;

import java.util.*;

/**
 * <p>
 * Title: 赫夫曼树
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月25日
 * @since 1.8
 */
public class HuffmanTree {

    /**
     * 根节点
     */
    private HuffmanTreeNode<String> rootNode;

    /**
     * 源字符串（待编码）
     */
    private String source;

    public HuffmanTree(String source) {
        if (source == null || source == ""){
            throw new RuntimeException("源字符串不能为空");
        }
        this.source = source;
    }

    /**
     * <p>
     * Title: 创建树
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    public HuffmanTreeNode createTree(){
        //统计每个字符出现的次数
        Map<String,Integer> frequencyMap = this.getFrequencyMap();
        //获取所有节点
        List<HuffmanTreeNode<String>> nodes = this.getAllNodes(frequencyMap);
        //开始构造赫夫曼树
        while(nodes.size() > 1){
            //将所有节点按权重升序
            Collections.sort(nodes,Comparator.comparing(HuffmanTreeNode::getWeightValue));
            //取出权重最小的两个节点
            HuffmanTreeNode<String> leftNode = nodes.get(0);
            HuffmanTreeNode<String> rightNode = nodes.get(1);
            HuffmanTreeNode<String> parentNode = new HuffmanTreeNode<>(null,leftNode.getWeightValue()+ rightNode.getWeightValue());
            parentNode.setLeftNode(leftNode);
            parentNode.setRightNode(rightNode);
            //将最小的两个节点从所有节点列表中删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新生成的节点，加入节点列表
            nodes.add(parentNode);
        }
        this.rootNode = nodes.get(0);
        return nodes.get(0);
    }

    /**
     * <p>
     * Title: 获取所有的节点
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param frequencyMap 字符串出现次数的Map
     * @return java.util.List<com.jie.datastrcutres.tree.huffman.HuffmanTreeNode<java.lang.String>>
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    private List<HuffmanTreeNode<String>> getAllNodes(Map<String, Integer> frequencyMap) {
        List<HuffmanTreeNode<String>> nodes = new ArrayList<>();
        frequencyMap.forEach((string,frequency)->{
            HuffmanTreeNode<String> currentNode = new HuffmanTreeNode<>(string,frequency);
            nodes.add(currentNode);
        });
        return nodes;
    }

    /**
     * <p>
     * Title: 获取每个字符出现的次数的map
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return java.util.Map<java.lang.String,java.lang.Integer>
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    private Map<String, Integer> getFrequencyMap() {
        Map<String,Integer> frequencyMap = new HashMap<>(15);
        for (int i = 0; i < this.source.length(); i++) {
            String currentString = this.source.substring(i,i+1);
            if (frequencyMap.containsKey(currentString)){
                frequencyMap.put(currentString,frequencyMap.get(currentString)+1);
            }else {
                frequencyMap.put(currentString,1);
            }
        }
        return frequencyMap;
    }

    /**
     * <p>
     * Title: 先序遍历
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    public void preSort(){
        if (this.rootNode == null){
            System.out.println("当前是一个空树");
            return;
        }
        this.doSort(this.rootNode);
    }


    /**
     * <p>
     * Title: 执行遍历
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param currentNode
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    public void doSort(HuffmanTreeNode<String> currentNode){
        System.out.println(currentNode);
        if (currentNode.getLeftNode() != null){
            this.doSort(currentNode.getLeftNode());
        }
        if (currentNode.getRightNode() != null){
            this.doSort(currentNode.getRightNode());
        }

    }
}
