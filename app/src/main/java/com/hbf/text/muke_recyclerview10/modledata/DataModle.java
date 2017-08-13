package com.hbf.text.muke_recyclerview10.modledata;

/**
 * 作者：Hbf
 */

public class DataModle {
    //  指定类型.type不能重复
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR=4;
    public static final int TYPE_FIVE=5;
    public static final int TYPE_SIX=6;
    //    服务端的数据限制时 使用该方法
    public int type;
    public int avatarColor;//头像颜色
    public String name;
    public String content;//内容
    public int contentColor;//右边的颜色

}
