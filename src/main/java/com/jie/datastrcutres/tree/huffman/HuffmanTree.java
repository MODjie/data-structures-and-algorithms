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
        if (source == null || source == "") {
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
    public HuffmanTreeNode createTree() {
        //统计每个字符出现的次数
        Map<String, Integer> frequencyMap = this.getFrequencyMap();
        //获取所有节点
        List<HuffmanTreeNode<String>> nodes = this.getAllNodes(frequencyMap);
        //开始构造赫夫曼树
        while (nodes.size() > 1) {
            //将所有节点按权重升序
            Collections.sort(nodes, Comparator.comparing(HuffmanTreeNode::getWeightValue));
            //取出权重最小的两个节点
            HuffmanTreeNode<String> leftNode = nodes.get(0);
            HuffmanTreeNode<String> rightNode = nodes.get(1);
            HuffmanTreeNode<String> parentNode = new HuffmanTreeNode<>(null, leftNode.getWeightValue() + rightNode.getWeightValue());
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
     * @return java.util.List<com.jie.datastrcutres.tree.huffman.HuffmanTreeNode < java.lang.String>>
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    private List<HuffmanTreeNode<String>> getAllNodes(Map<String, Integer> frequencyMap) {
        List<HuffmanTreeNode<String>> nodes = new ArrayList<>();
        frequencyMap.forEach((string, frequency) -> {
            HuffmanTreeNode<String> currentNode = new HuffmanTreeNode<>(string, frequency);
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
     * @return java.util.Map<java.lang.String, java.lang.Integer>
     * @author 刘小杰
     * @date 2021年11月25日
     * @since 1.8
     */
    private Map<String, Integer> getFrequencyMap() {
        Map<String, Integer> frequencyMap = new HashMap<>(15);
        for (int i = 0; i < this.source.length(); i++) {
            String currentString = this.source.substring(i, i + 1);
            if (frequencyMap.containsKey(currentString)) {
                frequencyMap.put(currentString, frequencyMap.get(currentString) + 1);
            } else {
                frequencyMap.put(currentString, 1);
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
    public void preSort() {
        if (this.rootNode == null) {
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
    public void doSort(HuffmanTreeNode<String> currentNode) {
        System.out.println(currentNode);
        if (currentNode.getLeftNode() != null) {
            this.doSort(currentNode.getLeftNode());
        }
        if (currentNode.getRightNode() != null) {
            this.doSort(currentNode.getRightNode());
        }

    }
    
    /**
     * <p>
     * Title: 编码
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return java.lang.String
     * @author 刘小杰
     * @date 2021年11月26日
     * @since 1.8
     */
    public String encode(){
        if (this.rootNode == null) {
            System.out.println("当前是一个空树");
            return null;
        }
        //获取编码后的二进制和字符的映射关系
        Map<String,String> stringCodeMap = new HashMap<>(15);
        StringBuilder codeCollector = new StringBuilder();
        this.doEncode(this.rootNode,"",stringCodeMap,codeCollector);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.source.length(); i++) {
            String currentString =this.source.substring(i,i+1);
            result.append(stringCodeMap.get(currentString));
        }
        return result.toString();
    }

    /**
     * <p>
     * Title: 执行编码递归
     * </p>
     * <p>
     * Description:
     * </p>
     *
     *
     * @param currentNode 当前节点
     * @param code 当前节点编码
     * @param stringCodeMap 字符和编码的映射关系
     * @param codeCollector 二进制码收集器
     * @author 刘小杰
     * @date 2021年11月26日
     * @since 1.8
     */
    private void doEncode(HuffmanTreeNode<String> currentNode,String code, Map<String, String> stringCodeMap, StringBuilder codeCollector) {
        if (currentNode == null){
            return;
        }
        StringBuilder currentCodeCollector = new StringBuilder(codeCollector);
        currentCodeCollector.append(code);
        if (currentNode.getData()==null){
            this.doEncode(currentNode.getLeftNode(),"0",stringCodeMap,currentCodeCollector);
            this.doEncode(currentNode.getRightNode(),"1",stringCodeMap,currentCodeCollector);
        }else {
            stringCodeMap.put(currentNode.getData(),currentCodeCollector.toString());

        }
    }

    /**
     * <p>
     * Title: 获取当前树的二进制编码转byte数组
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return byte[]
     * @author 刘小杰
     * @date 2021年11月26日
     * @since 1.8
     */
    public byte [] getCodeByte(){
        return this.getCodeByte(this.encode());
    }

    /**
     * <p>
     * Title: 获取二进制编码的byte数组，8位二进制为一组转成byte类型存储
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param code 二进制编码
     * @return byte[]
     * @author 刘小杰
     * @date 2021年11月26日
     * @since 1.8
     */
    public byte [] getCodeByte(String code){
        int byteLength = code.length();
        if (byteLength % 8 == 0){
            byteLength = byteLength / 8;
        }else {
            byteLength = byteLength / 8 + 1;
        }
        byte [] result = new byte[byteLength];
        int resultIndex = 0;
        for (int i = 0; i < code.length(); i+=8) {
            String stringByre;
            if (i + 8 <= code.length()){
                stringByre = code.substring(i,i+8);
            }else {
                stringByre = code.substring(i);
            }
            result[resultIndex] = (byte) Integer.parseInt(stringByre,2);
            resultIndex++;
        }
        return result;
    }
}
