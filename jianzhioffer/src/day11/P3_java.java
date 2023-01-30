package day11;

import java.util.Arrays;
import java.util.List;

public class P3_java {
    public int toNumber(String time) {
        return (time.charAt(4) - '0') + 10 * (time.charAt(3) - '0') + ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60;
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        short[] timeNumber = new short[timePoints.size()];
        for (int i = 0; i < timeNumber.length; i++) {
            timeNumber[i] = (short) toNumber(timePoints.get(i));
        }
        Arrays.sort(timeNumber);
        int minRange = 1500, btw;
        for (int i = 0; i < timeNumber.length - 1; i++) {
            btw = timeNumber[i + 1] - timeNumber[i];
            minRange = Math.min(minRange, btw);
        }

        minRange = Math.min(minRange, 1440 - (timeNumber[timeNumber.length - 1] - timeNumber[0]));

        return minRange;
    }
}
