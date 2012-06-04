/** $Id: StringTools.java,v 1.3 2005/11/14 03:17:07 zhangcheng Exp $ */
package mytools.util;

import java.io.*;
import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
//import org.apache.regexp.*;

import org.w3c.dom.*;


public final class StringTools {

  private StringTools() {
  }
  
  /*加密*/
  public static String encodePwd(String passwd){

      String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
      String tempStr = "";
      if(passwd == null){
        passwd = "";
      }
      int i;
      for(i = 0; i < passwd.length(); i++){
        tempStr = tempStr + (char)(passwd.charAt(i) ^ encodeStr.charAt(i));
      }
      return tempStr;
    }
  public static InputStream stringToInputStream(String s) {
    byte[] bs = null;
    try {
      bs = s.getBytes("unicode");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ByteArrayInputStream(bs);
  }

  private static final String maxMargin = "                                                                ";

  private static final String[] margins = new String[] { "", "  ", "    ",
      "      ", "        ", "          ", "            " };
  
  /**获取空格数量*/
  public static String getMargin(int i) {
	if(i<=0)return "";
    if (i < margins.length) {
      return margins[i];
    }
    return maxMargin.substring(0, i * 2);
  }

  /**
   * 处理换行符，替换为网页中的换行符 &#10;
   */
  public static String escapeLineBreak(String source) {
    if (-1 == source.indexOf('\r') && -1 == source.indexOf('\n')) {
      return source;
    }
    StringBuffer result = new StringBuffer(source);
    for (int i = result.length() - 1; i >= 0; i--) {
      if ('\r' == result.charAt(i)) {
        result.delete(i, i + 1);
      }
      if ('\n' == result.charAt(i)) {
        result.replace(i, i + 1, "&#10;");
      }
    }
    return result.toString();
  }

  /**
   * 生成双倍的单引号
   * @param source
   * @return
   */
  public static String doubleApos(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf("'", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "'"
          + result.substring(j, result.length());
    }
    return result;
  }
  
  /**
   * 转变引号为网页中显示的引号
   * @param source
   * @return
   */
  public static String quot(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf("\"", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&quot;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }

  /**
   * 将数字转换成千分位格式.
   *
   * @param s
   *          要进行千分位转换的源字符串.
   * @return 已经进行千分位转换的字符串
   * @author leejianwei
   */
  public static String kiloStyle(String s1) {
    if (s1 == null || s1.length() == 0)
      return "";
    StringBuffer result = new StringBuffer();
    boolean isMinus = false;
    if (s1.startsWith("-")) {
      s1 = s1.substring(1);
      isMinus = true;
    }
    int index = s1.indexOf(".");
    String s = null;
    String s2 = null;
    if (index != -1) {
      s = s1.substring(0, index);
      s2 = s1.substring(index);
    } else {
      s = s1;
      s2 = "";
    }
    // 千分位格式化后字符串中第一个逗号前字符个数.
    int head = s.length() % 3;
    // 需要加入逗号的个数
    int numOfComma = s.length() / 3;
    if ((head != 0) && (numOfComma != 0)) {
      result.append(s.substring(0, head));
      result.append(",");
      for (int i = 0; i < numOfComma; i++) {
        result.append(s.substring(i * 3 + head, (i + 1) * 3 + head));
        if (i != numOfComma - 1) {
          result.append(",");
        }
      }
    } else if ((head != 0) && (numOfComma == 0)) {
      result.append(s.substring(0, head));
    } else if ((head == 0) && (numOfComma != 0)) {
      for (int j = 0; j < numOfComma; j++) {
        result.append(s.substring(j * 3, (j + 1) * 3));
        if (j != numOfComma - 1) {
          result.append(",");
        }
      }
    } else {
      result.append("");
    }
    result.append(s2);
    String res = result.toString();
    if (isMinus) {
      res = "-" + res;
    }
    return res;
  }
  /**
   * 转换空格位网页中显示的空格
   * @param source
   * @return
   */
  public static String nbsp(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf(" ", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&nbsp;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }
  
  /**
   * ？？不知道什么意思
   * @param source
   * @return
   */
  public static String apos(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf("'", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&apos;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }
  /**
   * 转换为网页中的<
   * @param source
   * @return
   */
  public static String lt(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf("<", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&lt;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }

  // 把&lt;变为< ,20040727,wtm
  public static String oplt(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 5) {
      j = result.indexOf("&lt;", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "<"
          + result.substring(j + 4, result.length());
    }
    return result;
  }

  // 把&gt;变为> ,20040727,wtm
  /**
   * 把htmlde >变成普通字符
   */
  public static String opgt(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 5) {
      j = result.indexOf("&gt;", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + ">"
          + result.substring(j + 4, result.length());
    }
    return result;
  }

  public static String gt(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf(">", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&gt;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }
  
  /**
   * 转换成html,&
   * @param source
   * @return
   */
  public static String amp(String source) {
    String result = source;
    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
      j = result.indexOf("&", i);
      if (j < 0) {
        break;
      }
      result = result.substring(0, j) + "&amp;"
          + result.substring(j + 1, result.length());
    }
    return result;
  }
  
  /**
   * 转换成xml字符串
   */
  public static String toXMLString(String source) {
    return (gt(lt(apos(quot(amp(source))))));
  }
  
  public static String packSpecial(String source) {
    return (gt(lt(quot(amp(source)))));
  }
  /**
   * 给字符串家0，个数为Z个
   * @param source
   * @param z
   * @return
   */
  public static String addZero(String source, int z) {
    if (source == null || source.equals("")) {
      source = "0";
    }
    StringBuffer result = new StringBuffer(source);
    int i = source.indexOf(".");
    if (i == -1) {
      if (z > 0) {
        result.append(".");
      }
      while (z > 0) {
        result.append("0");
        z--;
      }
    } else {
      z = z - (source.length() - i - 1);
      while (z > 0) {
        result.append("0");
        z--;
      }
    }
    if (i == 0)
      result.insert(0, "0");
    return result.toString();
  }
  /**
   * 把网页中的单引号转变成'
   * @param source
   * @return
   */
  public static String aposConvert(String source) {
    String result = source;
    for (int i = 0, j = 0; i < source.length(); i = j + 1) {
      j = result.indexOf("&apos;", i);
      if (j < 0) {
        break;
      }
      String aaa = result.substring(0, j);
      String bbb = result.substring(j + 6, result.length());
      result = aaa + "'" + bbb;
    }
    return result;
  }

  /*--
   public static String toScript(String source){
   String result = source;
   for(int i = 0, j = 0; i < result.length(); i = j + 1){
   j = result.indexOf("\\", i);
   if(j < 0){
   break;
   }
   result = result.substring(0, j) + "\\" + result.substring(j, result.length());
   }
   for(int i = 0, j = 0; i < result.length(); i = j + 2){
   j = result.indexOf("\"", i);
   if(j < 0){
   break;
   }
   result = result.substring(0, j) + "\\" + result.substring(j, result.length());
   }
   return result;
   }
   */
  
  public static String replaceText(String strTmp, String strS, String strD) {
    // TODO: use StringBuffer
    String result = strTmp;
    int index = result.indexOf(strS);
    while (index > -1) {
      result = result.substring(0, index) + strD
          + result.substring(index + strS.length(), result.length());
      index = result.indexOf(strS);
    }
    return result;
  }


  // 按照 separator 分离字符串 s 为字符串数组
  public static String[] split2Array(String s, String separator) {

    if (null == s || 0 == s.trim().length()) {
      return null;
    }
    String[] result = null;
    String tmp[] = new String[1000]; // TODO:

    int k = 0;

    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (separator.equals(s.substring(i, i + 1))) {
        tmp[k++] = s.substring(j, i);
        j = i + 1;
      }
    }

    tmp[k++] = s.substring(j, s.length());
    if (k == 0) {
      return result;
    }

    result = new String[k];

    for (int i = 0; i < k; i++) {
      result[i] = tmp[i];
    }

    return result;

  }

  /**
   * @Title 将条件以逗号为分隔符分开，返回字符串的list，包括引号
   * @param strS
   *          源串
   * @param strChar
   *          分隔符
   * @return
   */
  public static List split(String strS, String strChar) {
    List list = new ArrayList();
    int index = strS.indexOf(strChar);
    String strTmp = strS;
    int len = strS.length(), charLen = strChar.length();
    if (index == -1) {
      list.add(strS); // 只有一个条件时的处理
    } else {
      while (index > -1) { // 两个以上条件的处理
        len = strTmp.length();
        list.add(strTmp.substring(0, index + charLen - 1));
        strTmp = strTmp.substring(index + strChar.length(), len);
        index = strTmp.indexOf(strChar);
        if (index == -1) { // 剩下最后一个条件时
          list.add(strTmp.substring(0, strTmp.length()));
        }
      }
    }
    return list;
  }

  /**
   * @Title 处理成用户可以识别的条件，in、between and、>=、<=、=等条件 此条件为一个字段所对应的全部条件
   * @param list
   * @return
   */
  public static List sortList(List list) {
    List result = new ArrayList();
    StringBuffer sbIn = new StringBuffer("in (");
    int nTmp = 0;
    for (int i = 0, j = list.size(); i < j; i++) {
      String tmp = (String) list.get(i);
      if (tmp.indexOf("..") == -1) { // 没有..的情况
        String strFirst = tmp.substring(0, 1);
        if (strFirst.equalsIgnoreCase("<") || strFirst.equalsIgnoreCase(">")
            || strFirst.equalsIgnoreCase("=") || strFirst.equalsIgnoreCase("!")) {
          // 处理>、<、=、<>、>=、<=等的情况
          result.add(tmp);
        } else if ((tmp.length() > 5)
            && (tmp.substring(0, 5).equalsIgnoreCase("like "))) {
          result.add(tmp);
        } else {
          // 处理in的情况
          if (nTmp != 0) {
            sbIn.append(",");
          }
          sbIn.append(tmp);
          nTmp = 1;
        }
      } else {
        // 处理between的情况
        int index = tmp.indexOf("..");
        String strBetween = "between " + tmp.substring(0, index) + " and "
            + tmp.substring(index + 2, tmp.length());
        result.add(strBetween);
      }
    }
    sbIn.append(")");
    if (sbIn.toString().indexOf("in ()") == -1) {
      result.add(sbIn.toString());
    }
    return result;
  }

  /**
   * 将8859字符编码转换成gbk字符编码
   * @param strS
   * @return
   */
  public static String conv8859(String strS) {
    if(strS==null)return null;
    String result = null;
    try {
      byte[] byteTemp = strS.getBytes("8859_1");
      result = new String(byteTemp, "gb2312");
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("StringTools类的conv8859方法：取值集时错误！"
          + "Byte字符处理：" + ex.toString());
    }
    return result;
  }
 
  /**
   * 将gb2312字符编码转换成iso-8859-1字符编码
   * @param strS
   * @return
   */
  public static String convGB2312(String strS) {
    if(strS==null)return null;
    String result = null;
    try {
      byte[] byteTemp = strS.getBytes("gb2312");
      result = new String(byteTemp, "iso-8859-1");
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("StringTools类的convGB2312方法：取值集时错误！"
          + "Byte字符处理：" + ex.toString());
    }
    return result;
  }

  /** 把"yyyy-MM-dd"的日期形式转换为java.sql.Date类型 */
  public static Date getSQLDateFromString(String strDate) {
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    try {
      date = new Date(formater.parse(strDate).getTime());
    } catch (java.text.ParseException e) {
      return null;
    }
    return date;
  }

  /**
   * 判断是否是空字符串
   *
   * @param obj
   *          要判断的对象
   * @return 如果 obj 为 null 或者是长度为零的字符串，返回 true； 其它情况返回 false，如果 obj 不是 String
   *         类型，返回 false。<code>
   *   return (null == obj ||
   *          (obj instanceof String && 0 == ((String)obj).length()));
   * </code>
   */
  public static boolean isEmptyString(Object obj) {
    return (null == obj || (obj instanceof String && 0 == ((String) obj)
        .length()));
  }

 /* public static boolean isIn(String matchStr, String value) {
    boolean result = false;
    try {
      boolean matched = false;

      matchStr = matchStr + ",";
      int tempi = matchStr.indexOf(",");
      while (tempi > -1) {
        RE r = new RE(matchStr.substring(0, tempi));
        matched = r.match(value);
        if (matched) {
          int startWholeExpr = r.getParenStart(0);
          if (startWholeExpr == 0) {
            result = true;
            break;
          }
        }
        matchStr = matchStr.substring(tempi + 1);
        tempi = matchStr.indexOf(",");
      }

    } catch (Exception ex) {
      // System.out.println(ex.toString());
    }
    return result;
  }*/

/*  public static boolean isMatched(String matchStr, String value) {
    boolean result = false;
    try {
      RE r = new RE(matchStr);
      boolean matched = false;
      matched = r.match(value);
      if (matched) {
        if (matchStr.indexOf(".") == -1) {
          if (matchStr.length() == value.length()) {
            result = true;
          }
        } else {
          int startWholeExpr = r.getParenStart(0);
          if (startWholeExpr == 0) {
            result = true;
          }
        }
      }
    } catch (Exception ex) {
      // System.out.println(ex.toString());
    }
    return result;
  }
*/
  
  public static String getDateString(java.util.Date dt) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    return df.format(dt);
  }

  /**
   * 本函数由刘明编写，2003-2-28 将日期转换为 任意格式输出 格式输出
   *
   * @param dt
   * @return
   */
  public static String getDateString(java.util.Date dt, String formatString) {
    SimpleDateFormat df = new SimpleDateFormat(formatString);
    return df.format(dt);
  }

  /**
   * 获取 digest;
   *
   * @param sText
   * @return String digest / ""
   */
  /*public static String getDigest(String sText) {
    if (sText == null)
      return "";
    String vsDigest = "";
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("SHA");
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    md.update(sText.getBytes());
    byte[] m = md.digest();
    byte[] b = Base64.encode(m);
    vsDigest = new String(b);
    return vsDigest;
  }*/

  /**
   * 取制定年月最大日期
   */
  public static int getMaxDay(int year, int month) {
    int result = 31;
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12) {
      result = 31;
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      result = 30;
    } else {
      if (year % 4 == 0) {
        result = 29;
      } else {
        result = 28;
      }
    }
    return result;
  }
  
  /**
   * 删除指定字符之间的字符
   * @param source
   * @param strBegin
   * @param strEnd
   * @return
   */
  public static String deleteStringInTag(String source, String strBegin,
      String strEnd) {
    StringBuffer result = new StringBuffer();
    int searchBeginIndex = 0;
    while (true) {
      int beginIndex = source.indexOf(strBegin, searchBeginIndex);
      if (beginIndex < 0) {
        break;
      }
      int endIndex = source.indexOf(strEnd, beginIndex);
      result.append(source.substring(searchBeginIndex, beginIndex));
      result.append(strBegin + strEnd);
      searchBeginIndex = endIndex + strEnd.length();
    }
    result.append(source.substring(searchBeginIndex));
    return result.toString();
  }
  
  /**
   * 删除制定字符之间的字符，包括制定的字符
   * @param source
   * @param strBegin
   * @param strEnd
   * @return
   */
  public static String deleteStringBetweenTag(String source, String strBegin, String strEnd) {
    StringBuffer result = new StringBuffer();
    int searchBeginIndex = 0;
    while (true) {
      int beginIndex = source.indexOf(strBegin, searchBeginIndex);
      if (beginIndex < 0) {
        break;
      }
      int endIndex = source.indexOf(strEnd, beginIndex);
      result.append(source.substring(searchBeginIndex, beginIndex));
      searchBeginIndex = endIndex + strEnd.length();
    }
    result.append(source.substring(searchBeginIndex));
    return result.toString();
  }
  
  /**
   * 去除两边的字符,offset指定了要去除的字符数量
   * @param source
   * @param offset
   * @return
   */
  public static String getMiddleString(String source,int offset){
      return  source.substring(offset,source.length()-offset);
  }
  /**
   * 给指定字符之间的字符加双引号
   * @param source
   * @param strBegin
   * @param strEnd
   * @return
   */
  public static String addDoubleQuot(String source){
	return "\""+source+"\"";
  }
  /**
   * 对双引号进行转义 
   * @param source
   * @return
   */
  public static String convertDoubleQuot(String source){
	    String result = source;
	    for (int i = 0, j = 0; i < result.length(); i = j + 2) {
	      j = result.indexOf("\"", i);
	      if (j < 0) {
	        break;
	      }
	      result = result.substring(0, j) + "\\"
	          + result.substring(j , result.length());
	    }
	    return result;
	  
  }
  /**
   * 给指定字符之间的字符加双引号
   * @param source
   * @param strBegin
   * @param strEnd
   * @return
   */
  public static String addDoubleQuot(String source, String strBegin,
      String strEnd) {
    StringBuffer result = new StringBuffer();
    int searchBeginIndex = 0;
    for (; true;) {
      int beginIndex = source.indexOf("id=", searchBeginIndex);
      if (beginIndex < 0) {
        break;
      }
      int endIndex = source.indexOf(" ", beginIndex);

      //判断beginIndex,与endIndex之间是否有"号 ，如果有，说明id不是标记，而是属性值
      if(source.substring(beginIndex,endIndex).indexOf("\"")!=-1)break;
      
      result.append(source.substring(searchBeginIndex, beginIndex + strBegin.length()));
      result.append("\"");
      result.append(source.substring(beginIndex + strBegin.length(), endIndex));
      result.append("\"");
      searchBeginIndex = endIndex;
    }
    result.append(source.substring(searchBeginIndex));
    return result.toString();
  }

  public static String convXML(String source) {
    String strTd = deleteStringInTag(source, "<TD", ">");
    String strTr = deleteStringInTag(strTd, "<TR", ">");
    String strInput = deleteStringBetweenTag(strTr, "<TD><INPUT", "</TD>");
    String strChk = deleteStringBetweenTag(strInput, "<COL id=chkCol", "</COL>");
    String strId = addDoubleQuot(strChk, "id=", " ");
    return strId;
  }

  
  public static String deleteComma(String source1) {
    String result = "";
    if (source1.equalsIgnoreCase("")) {
      return "";
    }
    int index;
    String source = "";
    String source2 = "";
    boolean isMinus = false;
    String firstChar = source1.substring(0, 1);
    if (firstChar.equalsIgnoreCase("-")) {
      source1 = source1.substring(1);
      isMinus = true;
    }
    index = source1.indexOf(".");
    if (index != -1) {
      source = source1.substring(0, index);
      source2 = source1.substring(index);
    } else {
      source = source1;
      source2 = "";
    }
    int first = source.indexOf(",");
    if (first == -1) {
      if (isMinus) {
        source1 = "-" + source1;
      }
      return source1;
    }
    while (first != -1) {
      result = result + source.substring(0, first);
      source = source.substring(first + 1);
      first = source.indexOf(",");
    }
    result = result + source;
    result = result + source2;
    if (isMinus) {
      result = "-" + result;
    }
    return result;
  }

 
  

  /**
   * 用一字符分隔字符串
 * @param source
   *          -字符串
 * @param separator
   *          -分割字符
   *
   * @return Vector
   */
  public static List splitToList(String source, String separator) {
    List list = new ArrayList();
    String tmpStr = "";
    int startIndex = 0;
    if (separator != null && separator.length() > 0 && source != null && source.length() > 0) {
      for (; source.indexOf(separator) > -1;) {
        startIndex = source.indexOf(separator);
        tmpStr = source.substring(0, startIndex);
        source = source.substring(startIndex + separator.length(), source.length());
        list.add(tmpStr);
      }
      list.add(source);
    }
    return list;
  }

  /**
   * <p>
   * 将字符串用分割符分割(单一字符) 例如"aaa|bbb|ccc|ddd",分割符'|' 形成Vector类型
   *
   * @param str
   *          原字符串
   * @param c
   *          分割字符
   * @return Vector
   */
  public static final Vector split(String str, char c) {
    Vector vec = new Vector();
    if (str == null || str.length() == 0) {
      return vec;
    }
    if (!str.endsWith(String.valueOf(c))) {
      str = str + c;
    }
    int i = 0;
    int j = 0;
    while ((j = str.indexOf(c, i)) != -1) {
      // System.out.println(str.substring(i,j));
      vec.add(str.substring(i, j));
      i = j + 1;
    }
    return vec;
  }

  /**
   * @Title 取得某月的起止日期，供部件的日期字段专用
   * @return result[0]开始日期，result[1]终止日期
   */
  public static String[] getBeginEndDate() {
    String[] result = new String[2];
    GregorianCalendar currentDate = new GregorianCalendar();
    int iyear = currentDate.get(Calendar.YEAR);
    int imonth = currentDate.get(Calendar.MONTH) + 1;
    int maxDay = StringTools.getMaxDay(iyear, imonth);
    String startDate = null;
    if (imonth < 10) {
      startDate = String.valueOf(iyear) + "-0" + String.valueOf(imonth) + "-01";
    } else {
      startDate = String.valueOf(iyear) + "-" + String.valueOf(imonth) + "-01";
    }
    result[0] = startDate;
    String endDate = null;
    if (imonth < 10) {
      endDate = String.valueOf(iyear) + "-0" + String.valueOf(imonth) + "-"
          + String.valueOf(maxDay);
    } else {
      endDate = String.valueOf(iyear) + "-" + String.valueOf(imonth) + "-"
          + String.valueOf(maxDay);
    }
    result[1] = endDate;
    return result;
  }

  /**
   * @Title 截取起始字符串和终止字符串之间的子串 从config_xxxx.xml文件名截取子系统名专用
   * @param source
   * @param firstStr
   * @param lastStr
   * @return
   */
  public static String getSubStrByTags(String source, String firstStr,
      String lastStr) {
    String result = null;
    int first, last;
    first = source.indexOf(firstStr);
    last = source.indexOf(lastStr);
    if (first > 0 && last > 0 && last > first) {
      result = source.substring(first + 1, last).toUpperCase();
    }
    return result;
  }

  /**
   * 将数值变为 0 填充的字符串
   *
   * @param index
   *          整数
   * @return 返回至少为五位数字的序列号，例如 00001, 01000, 1000000 等，不带引号
   */
  public static String getTextSeq(int index) {
    StringBuffer result = new StringBuffer();
    java.util.Date dt = new java.util.Date();
    result.append(String.valueOf(dt.getTime()));
    if (index < 10) {
      result.append("0000");
    } else if ((index >= 10) && (index < 100)) {
      result.append("000");
    } else if ((index >= 100) && (index < 1000)) {
      result.append("00");
    } else {
      result.append("0");
    }
    result.append(String.valueOf(index));
    return result.toString();
  }


  /**
   * 字符串为空则转换为网页空格
   * @param strInput
   * @return
   */
  public static String nullToSpace(String strInput) {
    if (strInput == null) {
      return "&nbsp";
    }
    return strInput;
  }

  public static String replaceAll(String strSource, String strOld, String strNew) {
    if (null == strSource || null == strOld || null == strNew
        || 0 == strOld.length()) {
      return strSource;
    }
    String strDest = "";
    String strTemp;
    int iOldLength = strOld.length();
    int iStartIndex = strSource.indexOf(strOld);

    while (iStartIndex >= 0) {
      strTemp = strSource.substring(0, iStartIndex);
      strDest = strDest + strTemp + strNew;
      strSource = strSource.substring(iStartIndex + iOldLength, strSource
          .length());
      iStartIndex = strSource.indexOf(strOld);
    }
    strDest = strDest + strSource;

    return strDest;
  }

  /**
   * 新加的方法 zuodongfa；2004、06、24
   */

  public static final String CONTENT_TYPE = "text/html; charset=GBK";

  /**
   * 获取有效的 XML tag 名称，将非法字符替换为下划线 _
   *
   * @param name
   * @return
   */
  public static String getValidTagName(String name) {
    return replaceChars(name, " /", "__");
  }

  /**
   * 一次性替换多个字符
   */
  public static String replaceChars(String str, String searchChars,
      String replaceChars) {
    if (str == null || str.length() == 0 || searchChars == null
        || searchChars.length() == 0) {
      return str;
    }
    char[] chars = str.toCharArray();
    int len = chars.length;
    boolean modified = false;
    for (int i = 0, isize = searchChars.length(); i < isize; i++) {
      char searchChar = searchChars.charAt(i);
      if (replaceChars == null || i >= replaceChars.length()) {
        // delete
        int pos = 0;
        for (int j = 0; j < len; j++) {
          if (chars[j] != searchChar) {
            chars[pos++] = chars[j];
          } else {
            modified = true;
          }
        }
        len = pos;
      } else {
        // replace
        for (int j = 0; j < len; j++) {
          if (chars[j] == searchChar) {
            chars[j] = replaceChars.charAt(i);
            modified = true;
          }
        }
      }
    }
    if (modified == false) {
      return str;
    }
    return new String(chars, 0, len);
  }

  public static String[] splitA(String str, char separatorChar) {
    // Performance tuned for 2.0 (JDK1.4)

    if (str == null) {
      return null;
    }
    int len = str.length();
    if (len == 0) {
      return new String[0];
    }
    List list = new ArrayList();
    int i = 0, start = 0;
    boolean match = false;
    while (i < len) {
      if (str.charAt(i) == separatorChar) {
        if (match) {
          list.add(str.substring(start, i));
          match = false;
        }
        start = ++i;
        continue;
      }
      match = true;
      i++;
    }
    if (match) {
      list.add(str.substring(start, i));
    }
    return (String[]) list.toArray(new String[list.size()]);
  }

  /** 如果字符串为 null，返回 ""，否则直接返回 */
  public static String toStringSafty(Object s) {
    return (null == s) ? "" : s.toString();
  }


  /**
   * 节点的值
   *
   * @param field
   *          Node 节点对象
   * @return String 值
   */
  private static String getNodeValue(Node field) {
    String result = "";
    NodeList values = field.getChildNodes();
    for (int r = 0, s = values.getLength(); r < s; r++) {
      Node value = values.item(r);
      if (value.getNodeType() == Node.TEXT_NODE) {
        Text text = (Text) value;
        result = text.getData();
        break;
      }
    }
    return result;
  }
  
  /**
   * TODO:有用吗
   * @param source
   * @return
   */
  public static String cutLastDblQuot(String source) {
    String result = source;
    if (source == null)
      return null;
    int lastIndex = result.lastIndexOf("\"");
    if (lastIndex > 0)
      result = result.substring(0, lastIndex);
    return result;
  }

  /**
   * 把形如yyyymmddhhmmss形式的时间转换为yyyy-mm-dd hh:mm:ss
   *
   * @param String
   *          inTime 输入时间
   * @return String
   */

  public static String toTimeString(String inTime) {
    if (inTime == null) {
      return "";
    }
    if (inTime.length() != 14) {
      return inTime;
    }
    StringBuffer outTime = new StringBuffer();
    try {
      outTime.append(inTime.substring(0, 4)).append("-");
      outTime.append(inTime.substring(4, 6)).append("-");
      outTime.append(inTime.substring(6, 8)).append(" ");
      outTime.append(inTime.substring(8, 10)).append(":");
      outTime.append(inTime.substring(10, 12)).append(":");
      outTime.append(inTime.substring(12));
    } catch (IndexOutOfBoundsException e) {
      return inTime;
    }
    return outTime.toString();
  }

 
  /**
   * 将字符串转换成Integer
   * @param str 需要转换的字符串
   * @return 返回转换后的Integer值。如果不能转换，返回null
   * 		  如果str为null，也返回null
   */
  /* by zhanggh 050623*/
  public static Integer parseStr2Int(String str){
    Integer intResult = null;
    try{
      intResult = Integer.valueOf(str);
    }catch(NumberFormatException e){
      //str can't be parsed to Integer,there's nothing need to do.
      //return null
    }
    return intResult;
  }
  /**
   * 将字符串转换成Float
   * @param str 需要转换的字符串
   * @return 返回转换后的Float值。如果不能转换，返回null
   * 		  如果str为null，也返回null
   */
  /* by zhanggh 050623*/
  public static Float parseStr2Float(String str){
    Float floatResult = null;
    try{
      floatResult = Float.valueOf(str);
    }catch(NumberFormatException e){
      //str can't be parsed to Float,there's nothing need to do.
      //return null
    }
    return floatResult;
  }

  /**
   * 空值情况下的返回值;
   * @param sValue
   * @param sRetValue
   * @return String
   */
  public static String ifNull(String sValue, String sRetValue) {
    if (sValue== null) return sRetValue;
    return sValue;
  }


public static String ArrayToString(Object array[]) {
	// TODO Auto-generated method stub
	StringBuffer result=new StringBuffer();
	boolean isFirst=true;
	for(int i=0,j=array.length;i<j;i++){
		if(!isFirst)result.append(",");
		result.append(StringTools.addDoubleQuot(StringTools.toStringSafty(array[i])));
		if(isFirst)isFirst=false;
	}
	return result.toString();
}

public static java.util.Date getDate(String strTime) throws Exception {
	// TODO Auto-generated method stub
	if(!strTime.matches("\\d{8}"))throw new RuntimeException("字符串转换成Date时候出错,因为字符串不符合格式!");
	Calendar calendar=Calendar.getInstance();
	calendar.set(Integer.parseInt(strTime.substring(0,4)),
			Integer.parseInt(strTime.substring(4,6)),
			Integer.parseInt(strTime.substring(6)));
	
	return calendar.getTime();
}
public static String getStackTraceString(Exception e){
	StringWriter sw=new StringWriter();
	PrintWriter pw=new PrintWriter(sw);
	e.printStackTrace(pw);
	
	return sw.toString();
}
/**
 *如果给定字符串超出最大长度，cut it off.
 *
 */
public static String getBriefString(String src,int maxAllowedlength){
	if(src==null)return null;
	if(src.length()<=maxAllowedlength)return src;
	return src.substring(0,maxAllowedlength)+"。。。";
}

public static String getSafeWindowsDirecotyPath(String outputpath) {
	outputpath=StringTools.replaceAll(outputpath,"/","\\");
	if(!outputpath.endsWith("\\"))outputpath+="\\";
	File f=new File(outputpath);
	if(!f.isDirectory()){
		f.mkdir();
	}
	return outputpath;
}
}
