package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 趣味答题表
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2026-03-03 11:44:37
 */
@TableName("exampaper")
public class ExampaperEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 趣味答题名称
     */

    private String name;
    /**
     * 考试时长(分钟)
     */

    private Integer time;
    /**
     * 趣味答题状态
     */

    private Integer status;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public ExampaperEntity() {

    }


    public ExampaperEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：趣味答题名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：趣味答题名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：考试时长(分钟)
     */
    public Integer getTime() {
        return time;
    }

    /**
     * 设置：考试时长(分钟)
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * 获取：趣味答题状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：趣味答题状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

}
