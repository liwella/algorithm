package com.d9cloud.algorithm.limitting;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/07/19
 */
public class FunnelRateLimiter {

    private final String FUNNELRATELIMITER = "funnel:";

    class Funnel {
        int capacity;
        double leakingRate;
        int leftQuota;
        long leakingTs;

        public Funnel(int capacity, double leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;
            int deltaQuota = (int) (deltaTs * leakingRate);
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deltaQuota < 1) {
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > capacity) {
                this.leftQuota = capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }


    private Map<String, Funnel> funnels = new HashMap<>();

    public boolean isActionAllowed(int userId, String actionKey, int capacity, double leakingRate) {
        String key = FUNNELRATELIMITER + userId + ":" + actionKey;
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        return funnel.watering(1);
    }

    public static void main(String[] args) {
        FunnelRateLimiter limiter = new FunnelRateLimiter();

        int userId = 1;
        String actionKey = "add";
        int capacity = 50;
        double leakingRate = 0.05;

        int success = 0;
        int failure = 0;
        for (int i = 0; i < 200; i++) {
            boolean actionAllowed = limiter.isActionAllowed(userId, actionKey, capacity, leakingRate);
            System.out.println(actionAllowed);
            if (actionAllowed) {
                success++;
                continue;
            }
            failure++;
        }
        System.out.println(success + " : " + failure);
    }

}