package com.example.multithread.bq;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ItemVo<T> implements Delayed {

    //到期时间,但传入的数值代表过期的时长，传入单位毫秒
    private long activeTime;
    private T data;//业务数据，泛型

    //传入过期时长,单位秒，内部转换
    public ItemVo(long expirationTime, T data) {
        this.activeTime = expirationTime * 1000 + System.currentTimeMillis();
        this.data = data;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public T getData() {
        return data;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long d = timeUnit.convert(this.activeTime
                - System.currentTimeMillis(), timeUnit);
        return d;
    }

    @Override
    public int compareTo(Delayed delayed) {
        long d = (getDelay(TimeUnit.MILLISECONDS)
                - delayed.getDelay(TimeUnit.MILLISECONDS));
        if (d == 0) {
            return 0;
        } else {
            if (d < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
