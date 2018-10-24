package personal.chencs.practice;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 算法工具类
 *
 * @author: chencs
 * @date: 2018/10/23
 */
public class AlgorithmUtils {

    /**
     * 找出字符串中最大连续字符的个数
     *
     * @param string 字符串
     * @return 最大连续字符的个数
     */
    public static int maxContinueCharLen(String string) {
        int length = string.length();
        if (1 == length) {
            return 1;
        }

        int maxLen = 0;
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (string.charAt(i - 1) == string.charAt(i)) {
                count++;
            } else {
                if (count > maxLen) {
                    maxLen = count;
                }
                count = 1;
            }
        }
        return maxLen;
    }

    /**
     * 验证字符串是否符合xml格式
     *
     * @param string
     * @return
     */
    public static boolean verifyXmlString(String string) {
        // 找出所有的元素标签
        Pattern pattern = Pattern.compile("<\\w+>|</\\w+>");
        Matcher matcher = pattern.matcher(string);

        Stack<String> stack = new Stack<String>();
        while (matcher.find()) {
            String element = matcher.group();
            String elementName = getElementName(element);
            // 遇到左标签元素入栈
            if (isLeftMarker(element)) {
                stack.push(elementName);
            } else {
                // 遇到右标签，则将栈顶元素出栈进行比较，不相同则不合法
                if(!elementName.equals(stack.pop())){
                    return false;
                }
            }
        }
        // 最终栈的元素应该为0
        if (0 != stack.size()) {
            return false;
        }
        return true;
    }

    /**
     * 验证字符串是否为左标签
     *
     * @param element
     * @return
     */
    private static boolean isLeftMarker(String element) {
        return !element.contains("/");
    }

    /**
     * 获取元素名称
     *
     * @param element
     * @return
     */
    private static String getElementName(String element) {
        return element.replaceAll("<|>|/", "");
    }

}
