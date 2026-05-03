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
 * 菜品分类
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2026-03-03 11:44:37
 */
@TableName("caipinfenlei")
public class CaipinfenleiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 菜品分类
     */

    private String caipinfenlei;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public CaipinfenleiEntity() {

    }


    public CaipinfenleiEntity(T t) {
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
     * 获取：菜品分类
     */
    public String getCaipinfenlei() {
        return caipinfenlei;
    }

    /**
     * 设置：菜品分类
     */
    public void setCaipinfenlei(String caipinfenlei) {
        this.caipinfenlei = caipinfenlei;
    }

}
