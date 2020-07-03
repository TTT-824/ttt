package com.ttt;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
解析xml用dom4j
 */
public class ParsingXML {

    private static Document document;
    private static SAXReader saxReader;

    //查询方法
    //参数说明：filelocal-查询的xml地址 item-查询第几个节点 element-查询item下节点的名字
    //返回的是查询到的值value
    public String QueryElementValve(String filelocal, int item, String element) throws DocumentException {
        //拼接文件地址
        String filename = filelocal;
        //String filename = String.valueOf(ParsingXML.class.getResource(filelocal));
        //读取xml的方式
        saxReader = new SAXReader();
        document = saxReader.read(filename);
        //获取根节点
        Element root = document.getRootElement();
        //获取根节点下面所有的节点集合
        List<Element> list = root.elements();
        //获取根节点下面第一个节点下面的值
        String returnElement = list.get(item).elementText(element);
        return returnElement;
    }

    //添加方法
    //参数说明：filelocal-xml文件的绝对地址 item-要添加的节点下的索引 elementname-添加的节点名称 value-添加的节点的值
    //返回值：
    public void AddToXml(String filelocal, int item, String elementname, String value) throws IOException, DocumentException {
        //拼接文件地址
        String filename = filelocal;
        //读取xml的方式
        saxReader = new SAXReader();
        document = saxReader.read(filename);
        //获取根节点
        Element root = document.getRootElement();
        //获取根节点下面所有的节点集合
        List<Element> list = root.elements();
        //获取根节点下面第item个节点
        Element elementitem = list.get(item).addElement(elementname);
        //定义数据
        elementitem.addText(value);
        //添加后需要重新写入
        show(filelocal);
    }

    //删除方法
    //参数说明：filelocal-xml路径 item-删除节点在根节点的索引
    //返回值：
    public void RemoveElement(String filelocal,int item) throws DocumentException, IOException {
        //拼接文件地址
        String filename = filelocal;
        //读取xml的方式
        saxReader = new SAXReader();
        document = saxReader.read(filename);
        //获取根节点
        Element root = document.getRootElement();
        //获取根节点下面所有的节点集合
        List<Element> list = root.elements();
        //获取根节点下面第一个节点下面的值
        Element returnElement = list.get(item);
        //查找二级路径
        //List<Element> list1 = returnElement.elements();
        //Element returnElement2 =  list1.get(0);
        //通过父节点来删除节点
        returnElement.getParent().remove(returnElement);
        //删除后需要写入
        show(filelocal);
    }

    //修改方法
    //参数说明：filelocal-xml路径 item-修改节点在根节点的索引 item2-修改节点在根节点的索引
    //返回值：
    public void SetElementValue(String filelocal,int item,int item2,String values) throws DocumentException, IOException {
        //拼接文件地址
        String filename = filelocal;
        //读取xml的方式
        saxReader = new SAXReader();
        document = saxReader.read(filename);
        //获取根节点
        Element root = document.getRootElement();
        //获取根节点下面所有的节点集合
        List<Element> list = root.elements();
        //获取根节点下面第一个节点下面的值
        Element returnElement = list.get(item);
        //查找二级路径
        List<Element> list1 = returnElement.elements();
        Element returnElement2 =  list1.get(item2);
        //通过setText修改节点
        returnElement2.setText(values);
        //修改后需要写入
        show(filelocal);
    }

    //增删改查后的写入方法
    //参数说明：filelocal-xml路径
    //返回值：
    private static void show(String filelocal) throws IOException {
        //指定io流
        OutputFormat format = OutputFormat.createPrettyPrint();
        //指定字符集
        format.setEncoding("UTF-8");
        //写入数据
        XMLWriter xmlWriter = new XMLWriter(new FileWriter(new File(filelocal)), format);
        xmlWriter.write(document);
        //关闭流
        xmlWriter.close();
    }
}
