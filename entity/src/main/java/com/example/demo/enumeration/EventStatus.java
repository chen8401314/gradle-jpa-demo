package com.example.demo.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EventStatus {
    /**
     * 事件未发布
     */
    EVENT_UNPUBLISHED(-2, "事件未发布"),
    /**
     * 关闭事件
     */
    EVENT_CLOSED(-1, "关闭事件 "),
    /**
     * 办理中
     */
    EVENT_HANDLING(0, "办理中"),
    /**
     * 事件结束
     */
    EVENT_END(1, "事件结束");

    private int key;

    private String value;

    EventStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonCreator
    public static EventStatus fromKey(Integer i) {
        for (EventStatus s : EventStatus.values()) {
            if (s.key == i) {
                return s;
            }
        }
        return EVENT_UNPUBLISHED;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
