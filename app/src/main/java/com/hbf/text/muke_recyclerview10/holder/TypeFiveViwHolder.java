package com.hbf.text.muke_recyclerview10.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbf.text.muke_recyclerview10.R;
import com.hbf.text.muke_recyclerview10.modledata.DataModleFive;


/**
 * 作者：Hbf
 */

public class TypeFiveViwHolder extends TypeAbstractViewHolder<DataModleFive> {

    public ImageView avatar;
    public TextView name;
    public TypeFiveViwHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar5);
        name= (TextView) itemView.findViewById(R.id.name5);
        itemView.setBackgroundColor(Color.BLACK);
    }
//    将ViewHolder的数据与外面的数据绑定起来
    @Override
    public void  bindholder(DataModleFive modle){
//        avatar.setBackgroundColor(modle.avatarColor);资源文件
        avatar.setBackgroundResource(modle.avatarColor);//R文件id

        name.setText(modle.name);
    }
}
