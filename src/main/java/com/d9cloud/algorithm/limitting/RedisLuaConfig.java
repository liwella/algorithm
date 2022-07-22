package com.d9cloud.algorithm.limitting;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/07/22
 */
public class RedisLuaConfig {

    public static final String SLIDING_WINDOW_LIMIT =
        // 下标从 1 开始
        "local key = KEYS[1]\n" +
        "local now = tonumber(ARGV[1])\n" +
        "local ttl = tonumber(ARGV[2])\n" +
        "local expired = tonumber(ARGV[3])\n" +
        // 最大访问量
        "local max = tonumber(ARGV[4])\n" +
        // 清除过期的数据
        // 移除指定分数区间内的所有元素，expired 即已经过期的 score
        // 根据当前时间毫秒数 - 超时毫秒数，得到过期时间 expired
        "redis.call('zremrangebyscore', key, 0, expired)\n" +
        // 获取 zset 中的当前元素个数
        "local current = tonumber(redis.call('zcard', key))\n" +
        "local next = current + 1\n" +
        "if next > max then\n" +
        // 达到限流大小 返回 0
        "  return 0;\n" +
        "else\n" +
        // 往 zset 中添加一个值、得分均为当前时间戳的元素，[value,score]
        "  redis.call('zadd', key, now, now)\n" +
        // 每次访问均重新设置 zset 的过期时间，单位毫秒
        "  redis.call('pexpire', key, ttl)\n" +
        "  return next\n" +
        "end";


}
