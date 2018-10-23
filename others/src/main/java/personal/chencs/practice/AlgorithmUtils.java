package personal.chencs.practice;

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

}
