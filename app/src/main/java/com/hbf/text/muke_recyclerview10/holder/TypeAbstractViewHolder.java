package com.hbf.text.muke_recyclerview10.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：Hbf
 */
//将bindholder方法提取
public  abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }
//    该方法也可以不抽象，子类做处理
    public abstract void bindholder(T modle);//将DataModle设置成了T泛型 **上面也要加
}
