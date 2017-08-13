package com.hbf.text.muke_recyclerview10;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hbf.text.muke_recyclerview10.holder.TypeFiveViwHolder;
import com.hbf.text.muke_recyclerview10.holder.TypeFourViwHolder;
import com.hbf.text.muke_recyclerview10.holder.TypeOneViwHolder;
import com.hbf.text.muke_recyclerview10.holder.TypeSixViwHolder;
import com.hbf.text.muke_recyclerview10.holder.TypeThreeViwHolder;
import com.hbf.text.muke_recyclerview10.holder.TypeTwoViwHolder;
import com.hbf.text.muke_recyclerview10.modledata.DataModle;
import com.hbf.text.muke_recyclerview10.modledata.DataModleFive;
import com.hbf.text.muke_recyclerview10.modledata.DataModleFour;
import com.hbf.text.muke_recyclerview10.modledata.DataModleOne;
import com.hbf.text.muke_recyclerview10.modledata.DataModleSix;
import com.hbf.text.muke_recyclerview10.modledata.DataModleThree;
import com.hbf.text.muke_recyclerview10.modledata.DataModleTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Hbf
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //  指定类型.type不能重复
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR=4;
    public static final int TYPE_FIVE=5;
    public static  final int TYPE_SIX=6;

    private LayoutInflater mlayoutInflater;
    private List<DataModle> mList = new ArrayList<>();

    public DemoAdapter(Context context) {//LayoutInflater必须context获取
        mlayoutInflater = LayoutInflater.from(context);
    }

    private List<DataModleOne> list1;
    private List<DataModleTwo> list2;
    private List<DataModleThree> list3;
    private List<DataModleFour>list4;
    private List<DataModleFive>list5;
    private List<DataModleSix>list6;

    private List<Integer> types = new ArrayList<>();//相当于每个位置的Type
    private Map<Integer, Integer> mPotion = new HashMap<>();//记录每个list的Type的起始位置

    //    创建外面操作的方法
    public void addList(List<DataModleOne> list1, List<DataModleTwo> list2, List<DataModleThree> list3, List<DataModleFour>list4,List<DataModleFive>list5,List<DataModleSix>list6) {

        addlistByType(TYPE_ONE, list1);
        addlistByType(TYPE_TWO, list2);
        addlistByType(TYPE_THREE, list3);
        addlistByType(TYPE_FOUR,list4);
        addlistByType(TYPE_FIVE,list5);
        addlistByType(TYPE_SIX,list6);


        this.list1 = list1;
        this.list2=list2;
        this.list3=list3;
        this.list4=list4;
        this.list5=list5;
        this.list6=list6;
    }

    private void addlistByType(int type, List list) {
        mPotion.put(type, types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case DataModle.TYPE_ONE:
                return new TypeOneViwHolder(mlayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModle.TYPE_TWO:
                return new TypeTwoViwHolder(mlayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModle.TYPE_THREE:
                return new TypeThreeViwHolder(mlayoutInflater.inflate(R.layout.item_type_three, parent, false));
            case DataModle.TYPE_FOUR:
                return  new TypeFourViwHolder(mlayoutInflater.inflate(R.layout.item_type_four,parent,false));
            case DataModle.TYPE_FIVE:
                return new TypeFiveViwHolder(mlayoutInflater.inflate(R.layout.item_type_five,parent,false));
            case DataModle.TYPE_SIX:
                return new TypeSixViwHolder(mlayoutInflater.inflate(R.layout.item_type_six,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//需要获取getType，2处理typeh和数据
        int viewType = getItemViewType(position);
//        列表中真是的位置
        int realPosition = position - mPotion.get(viewType);//传进来的position减掉起始位置的position得到每个列表中的position
        switch (viewType) {
            case DataModle.TYPE_ONE:
                ((TypeOneViwHolder)holder).bindholder(list1.get(realPosition));
                break;
            case DataModle.TYPE_TWO:
                ((TypeTwoViwHolder)holder).bindholder(list2.get(realPosition));
                break;
            case DataModle.TYPE_THREE:
                ((TypeThreeViwHolder)holder).bindholder(list3.get(realPosition));
                break;
            case DataModle.TYPE_FOUR:
                ((TypeFourViwHolder)holder).bindholder(list4.get(realPosition));
                break;
            case DataModle.TYPE_FIVE:
                ((TypeFiveViwHolder)holder).bindholder(list5.get(realPosition));
                break;
            case DataModle.TYPE_SIX:
                ((TypeSixViwHolder)holder).bindholder(list6.get(realPosition));
        }

//      holder需要强转
//        ((TypeAbstractViewHolder)holder).bindholder(mList.get(position));


//       在没有抽象下都要switch
//        switch (viewType) {
//            case DataModle.TYPE_ONE:
//                ((TypeAbstractViewHolder)holder).bindholder(mList.get(0));
//                break;
//            case DataModle.TYPE_TWO:
//                ((TypeAbstractViewHolder)holder).bindholder(mList.get(1));
//                break;
//            case DataModle.TYPE_THREE:
//                ((TypeAbstractViewHolder)holder).bindholder(mList.get(2));
//                break;
//        }
    }

    @Override
    public int getItemViewType(int position) {//1位置，类型做处理
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
