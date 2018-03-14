package com.rewardshoop.utils;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * 通用工具类
 *
 * @author Sven
 */
public class CommonUtil {

    /**
     * 传入多个str进行拼接
     *
     * @param str
     * @return
     */
    public static String stitching(String... str) {
        StringBuffer buff = new StringBuffer();
        for (String aStr : str) {
            buff.append(aStr);
        }
        return buff.toString();
    }


    /**
     * 字符串根据关键字截取返还list
     *
     * @param str
     * @param key
     * @return
     */
    public static List<String> spilt(String str, String... key) {
        List<String> list = new ArrayList<>();
        int beginIndex = 0;
        int endIndex = 0;
        String tem = null;
        for (String aKey : key) {
            endIndex = str.indexOf(aKey) + 1;
            tem = str.substring(beginIndex, endIndex);
            beginIndex = endIndex;
            list.add(tem);
        }
        return list;
    }

    /**
     * 父类复制属性到子类
     *
     * @param parent
     * @param child
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void aotuCopy(Object parent, Object child) {
        if (!(child.getClass().getSuperclass() == parent.getClass())) {
            return;
        }
        Class parentClass = parent.getClass();
        Field ff[] = parentClass.getDeclaredFields();
        for (Field f : ff) {
            try {
                Method m = parentClass.getMethod(stitching("get", upperHeadChar(f.getName())));// 方法getDeleteDate
                Object obj = m.invoke(parent);// 取出属性值
                f.setAccessible(true);
                f.set(child, obj);
            } catch (SecurityException | IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 首字母大写
     *
     * @param str
     * @return
     */
    private static String upperHeadChar(String str) {
        return stitching(str.substring(0, 1).toUpperCase(), str.substring(1));
    }

    /**
     * map转换成NameValuePairs
     *
     * @param map
     * @return
     */
    public static NameValuePair[] mapToNameValuePairs(Map<String, String> map) {
        NameValuePair[] nameValuePairs = new NameValuePair[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            NameValuePair nameValuePair = new NameValuePair(key, (String) map.get(key));
            nameValuePairs[i] = nameValuePair;
            i++;
        }
        return nameValuePairs;
    }

    /**
     * map转换成String
     *
     * @param map
     * @return
     */
    public static String mapToString(Map<String, String> map) {
        StringBuffer sb = new StringBuffer("{");
        for (String key : map.keySet()) {
            sb.append("\"").append(key).append("\":\"").append(map.get(key)).append("\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key : data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); // .replaceAll("\n|\r", "");
        try {
            writer.close();
        } catch (Exception ex) {
        }
        return output;
    }

    /**
     * 获取客户端的真实IP,思路:
     * <p>
     * 如果request.getHeader("X-Forwarded-For")不为空，拿XFF的左边第一个
     * <p>
     * 如果request.getHeader("X-Forwarded-For")为空，拿request.getHeader("X-Real-IP")
     * <p>
     * 如果request.getHeader("X-Real-IP")为空，只能拿request.getRemoteAddr()，也就是只能拿到最直接发给他的机器ip
     *
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 随机字符字典
     */
    private static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成随机数
     */
    private static Random random = new Random();

    /**
     * 生成随机数
     *
     * @param max      随机数的位数
     * @param isLetter 是否需要英文符号,true是需要
     * @return
     */
    public static String getRandomString(int max, boolean isLetter) {
        if (max < 0) {
            return null;
        }

        StringBuffer bf = new StringBuffer();
        if (isLetter) {
            for (int i = 0; i < max; i++) {
                bf.append(CHARS[random.nextInt(CHARS.length)]);
            }
            return bf.toString();
        }
        for (int i = 0; i < max; i++) {
            bf.append(random.nextInt(9));
        }
        return bf.toString();
    }

    public static boolean bankCardValidated(String bankCard) {
        int[] cardNoArr = new int[bankCard.length()];
        for (int i = 0; i < bankCard.length(); i++) {
            cardNoArr[i] = Integer.valueOf(String.valueOf(bankCard.charAt(i)));
        }
        for (int i = cardNoArr.length - 2; i >= 0; i -= 2) {
            cardNoArr[i] <<= 1;
            cardNoArr[i] = cardNoArr[i] / 10 + cardNoArr[i] % 10;
        }
        int sum = 0;
        for (int i = 0; i < cardNoArr.length; i++) {
            sum += cardNoArr[i];
        }
        return sum % 10 == 0;
    }

    /**
     * 默认用","拆分
     *
     * @param str
     * @return
     */
    public static List<String> stringToList(String str) {
        String flag = ",";
        return stringToList(str, flag);
    }

    /**
     * 根据flag拆分字符串,返回list
     *
     * @param str
     * @param flag
     * @return
     */
    public static List<String> stringToList(String str, String flag) {
        List<String> list = new ArrayList<>();
        if (str == null) {
            return list;
        }
        String[] strs = str.split(flag);
        for (String obj : strs) {
            list.add(obj);
        }
        return list;
    }

    ;

    /**
     * 默认用","标识
     *
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        String flag = ",";
        return listToString(list, flag);
    }

    /**
     * 把list拼接成String,用flag标识
     *
     * @param list
     * @param flag
     * @return
     */
    public static String listToString(List<String> list, String flag) {
        if (list.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str).append(flag);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
