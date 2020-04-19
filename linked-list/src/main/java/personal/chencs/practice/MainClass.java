package personal.chencs.practice;

/**
 * @author: chencs
 * @date: 2020/4/19 16:34
 */
public class MainClass {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 1, 3, 3, 5, 5, 6, 7, 7};
        int result1 = deleteRepeatElement(array1);
        printArray(array1, result1);

        System.out.println("--------");
        int[] array2 = new int[]{11, 13, 13, 15, 15, 16, 16, 17, 17};
        int result2 = deleteRepeatElementII(array2, 1);
        printArray(array2, result2);

    }

    /**
     * 删除数组中重复的元素
     * i代表慢指针，i及i之前的数据都是非重复数据
     * j代表快指针，j及j之后的数据都是待检测数据
     * 要特别主要输入的数组是有序的
     *
     * @param array 有序数组
     * @return 不包含重复元素的新数组的长度
     */
    private static int deleteRepeatElement(int[] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int i = 0;

        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                // 不是重复元素，则搬移元素
                i++;
                array[i] = array[j];
            }
        }

        return i + 1;
    }

    /**
     * 删除数组中重复的元素
     *
     * @param array       有序数组
     * @param repeatCount 允许重复的最大次数
     * @return 不包含重复元素的新数组的长度
     */
    private static int deleteRepeatElementII(int[] array, int repeatCount) {
        if (null == array || 0 == array.length) {
            return 0;
        }

        int i = 0;
        for (int element : array) {
            if (i < repeatCount || element > array[i - repeatCount]) {
                array[i++] = element;
            }
        }

        return i;
    }

    private static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
