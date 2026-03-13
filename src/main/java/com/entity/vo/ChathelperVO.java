package com.entity.vo;

import java.io.Serializable;


/**
 * 聊天助手表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public class ChathelperVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 回复
     */

    private String reply;

    /**
     * 获取：回复
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置：回复
     */

    public void setReply(String reply) {
        this.reply = reply;
    }

}
