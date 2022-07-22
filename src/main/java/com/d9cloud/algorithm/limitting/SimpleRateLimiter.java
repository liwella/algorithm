package com.d9cloud.algorithm.limitting;

import cn.hutool.core.util.StrUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/07/19
 */
public class SimpleRateLimiter {

    private Jedis jedis;

    private Map<String, String> evalShaMap = new HashMap<>();

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }


    public boolean isActionAllowed(String key, int maxCount, int period) {
        String evalSha = evalShaMap.get(key);
        if (StrUtil.isBlank(evalSha)) {
            evalSha = jedis.scriptLoad(RedisLuaConfig.SLIDING_WINDOW_LIMIT);
            evalShaMap.put(key, evalSha);
        }
        // 当前时间
        long now = System.currentTimeMillis();
        // 超时间隔
        long ttl = period * 1000;
        // 超时时间
        long expireTime = now - ttl;
        Long count = (Long) jedis.evalsha(evalSha, 1, key, now + "",  ttl + 1 + "", expireTime + "", maxCount + "");
        if (count == 0) {
            System.out.println(key + " 在单位时间" + period + "秒内已达到访问上限，当前接口上限" + maxCount);
            return false;
        }
        System.out.println(key + " 在单位时间" + period + "秒内访问次数" + count);
        return true;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.16.2.13", 6379);

        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        int userId = 1;
        String actionKey = "add";
        int maxCount = 50;
        int period = 1;

        int allowed = 0;
        int unAllowd = 0;

        String key = "LIMITER:" + userId + ":" + actionKey;
        for (int i = 700; i > 0; ) {
            boolean actionAllowed = limiter.isActionAllowed(key, maxCount, period);
            System.out.println(actionAllowed);
            if (actionAllowed) {
                i--;
                allowed++;
                continue;
            }
            unAllowd++;
        }
        System.out.println(allowed + " : " +unAllowd);
    }

}
