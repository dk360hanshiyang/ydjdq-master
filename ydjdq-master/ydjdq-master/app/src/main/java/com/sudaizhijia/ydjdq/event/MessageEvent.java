package com.sudaizhijia.ydjdq.event;

/**
 * Author: William Wang
 * Date:   On 2018/12/7
 */
public class MessageEvent {
    public int progress;

    public MessageEvent(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
