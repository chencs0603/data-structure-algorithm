package personal.chencs.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: chencs
 * @date: 2018/10/23
 */
public class TestCases {

    @Test
    public void maxContinueCharLen() {
        Assert.assertTrue(0 == AlgorithmUtils.maxContinueCharLen(""));
        Assert.assertTrue(1 == AlgorithmUtils.maxContinueCharLen("a"));
        Assert.assertTrue(1 == AlgorithmUtils.maxContinueCharLen("abc"));
        Assert.assertTrue(2 == AlgorithmUtils.maxContinueCharLen("sfddffed"));
        Assert.assertTrue(5 == AlgorithmUtils.maxContinueCharLen("aaassdddddeeeedddd"));
    }


}
