package com.rong.io.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Objects;

public class XMLUtil {
    //该方法用于从XML配置文件中提取图表类型，并返回类型名
	public static String getAnimalName() {
		try {
			// 创建解析器工厂
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			String path = Objects.requireNonNull(XMLUtil.class.getResource("/")).getPath();
			String pathName = path + "animal-config.xml";
			File file = new File(pathName);
			Document doc = builder.parse(file);
		
			//获取包含图表类型的文本节点
			NodeList nodeList = doc.getElementsByTagName("animalName");
            Node classNode = nodeList.item(0).getFirstChild();
			return classNode.getNodeValue().trim();
        } catch(Exception e) {
			throw new RuntimeException(e);
        }
	}
}