package com.ttt;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetXmlDom {
    //文件地址固定
    //第一个子节点
    private String oneItem;
    //第二个子节点
    private String twoItem;
    //返回值集合
    private List list;

    //
    public List startXML(String filelocal,String a,int b){
        // 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建一个DocumentBuilder对象
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 使用parse方法解析xml文件
            Document document = db.parse(String.valueOf(GetXmlDom.class.getResource(filelocal)));
            //获取a的节点个数
            NodeList nl = document.getElementsByTagName(a);
            System.out.println(nl.getLength());
            //获取第一个a节点
            Node book = nl.item(b);
            //获取第一个节点的所有子节点
            NodeList childNodes = book.getChildNodes();
            System.out.println(childNodes.getLength());
            //获取这个节点的所有值
            list = new ArrayList();
                //分别获取节点的值
                //将得到的值返回
                System.out.println(String.valueOf(childNodes.item(1).getFirstChild().getNodeValue()));
                list.add(String.valueOf(childNodes.item(1).getFirstChild().getNodeValue()));

            //获取a节点的第一个节点的名字
            //String firstclass = childNodes.item(0).getNodeName();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //设置节点信息
    public void setXml(String filelocal,String a,int b,int c){
        // 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建一个DocumentBuilder对象
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 使用parse方法解析xml文件
            Document document = db.parse(String.valueOf(GetXmlDom.class.getResource(filelocal)));
            //获取a的节点个数
            NodeList nl = document.getElementsByTagName(a);
            //获取第一个a节点
            Node book = nl.item(b);
            //获取第一个节点的所有子节点
            NodeList childNodes = book.getChildNodes();
            System.out.println(childNodes.getLength());
            //使用for循环获取这个节点的所有值
            list = new ArrayList();
            //分别获取节点的值
            childNodes.item(1).getFirstChild().setNodeValue(""+c+"");

            System.out.println("shezhichenggong"+c);
            //获取a节点的第一个节点的名字
            //String firstclass = childNodes.item(0).getNodeName();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
