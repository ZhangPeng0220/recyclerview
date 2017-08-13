package com.hbf.text.muke_recyclerview10.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbf.text.muke_recyclerview10.R;
import com.hbf.text.muke_recyclerview10.modledata.DataModleSix;

/**
 * 作者：Hbf
 */

public class TypeSixViwHolder extends TypeAbstractViewHolder<DataModleSix> {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public TypeSixViwHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar6);
        name= (TextView) itemView.findViewById(R.id.name6);
        content= (TextView) itemView.findViewById(R.id.content6);
        itemView.setBackgroundColor(Color.GREEN);
    }
//    将ViewHolder的数据与外面的数据绑定起来
    @Override
    public void  bindholder(DataModleSix modle){
        avatar.setBackgroundResource(modle.avatarColor);
        name.setText(modle.name);
        content.setText(modle.content);

    }
}
