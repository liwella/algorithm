package com.d9cloud.algorithm.limitting;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/07/19
 */
public class SimpleRateLimiter {

    private final String limiter = "LIMITER:";

    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(int userId, String actionKey, int maxCount, int period) {
        String key = limiter + userId + ":" + actionKey;
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, nowTs + "");
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.16.2.13", 6379);

        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        int userId = 1;
        String actionKey = "add";
        int maxCount = 2;
        int period = 60;

        int allowed = 0;
        int unAllowd = 0;
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean actionAllowed = limiter.isActionAllowed(userId, actionKey, maxCount, period);
            System.out.println(actionAllowed);
            if (actionAllowed) {
                allowed++;
                continue;
            }
            unAllowd++;
        }
        System.out.println(allowed + " : " +unAllowd);
    }

}
