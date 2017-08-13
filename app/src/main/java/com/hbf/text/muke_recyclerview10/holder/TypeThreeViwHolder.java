package com.hbf.text.muke_recyclerview10.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbf.text.muke_recyclerview10.R;
import com.hbf.text.muke_recyclerview10.modledata.DataModleThree;

/**
 * 作者：Hbf
 */

public class TypeThreeViwHolder extends TypeAbstractViewHolder<DataModleThree> {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;
    public TypeThreeViwHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);
        content= (TextView) itemView.findViewById(R.id.content);
        contentImage= (ImageView) itemView.findViewById(R.id.contentImage);
        itemView.setBackgroundColor(Color.GRAY);
    }
//    将ViewHolder的数据与外面的数据绑定起来
    @Override
    public void  bindholder(DataModleThree modle){
        avatar.setBackgroundResource(modle.avatarColor);
        name.setText(modle.name);
        content.setText(modle.content);
        contentImage.setBackgroundResource(modle.contentColor);
    }
}
