package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个验证系统
 */
public class Solution1797 {

    Integer timeToLive;
    Map<String, Integer> content;

    public Solution1797(int timeToLive) {
        this.timeToLive = timeToLive;
        content = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        content.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = content.get(tokenId);
        if (time == null || time <= currentTime) return;
        content.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer time : content.values()) {
            if (time > currentTime) count ++;
        }
        return count;
    }

}
