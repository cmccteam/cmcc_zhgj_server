package com.cmcc.common.utils;

import java.math.BigDecimal;

/**
 * @author zwq
 * @create 2019-06-25 9:19
 */
public class MathUtil {
    public static Integer percentage(Integer score, Integer totalScore) {
        if (score == null || totalScore == null) {
            return null;
        }
        if (totalScore <= 0) {
            return score;
        }
        if (score <= 0) {
            return 0;
        }
        BigDecimal bigDecimalScore = new BigDecimal(score);
        BigDecimal bigDecimalTotalScore = new BigDecimal(totalScore);
        BigDecimal divide = bigDecimalScore.divide(bigDecimalTotalScore, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal multiply = divide.multiply(new BigDecimal(100));
        return multiply.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP).intValue();
    }
}
