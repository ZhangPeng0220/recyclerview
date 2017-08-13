package com.hbf.text.muke_recyclerview10;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hbf.text.muke_recyclerview10.modledata.DataModle;
import com.hbf.text.muke_recyclerview10.modledata.DataModleFive;
import com.hbf.text.muke_recyclerview10.modledata.DataModleFour;
import com.hbf.text.muke_recyclerview10.modledata.DataModleOne;
import com.hbf.text.muke_recyclerview10.modledata.DataModleSix;
import com.hbf.text.muke_recyclerview10.modledata.DataModleThree;
import com.hbf.text.muke_recyclerview10.modledata.DataModleTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private DemoAdapter mAdapter;
//    自定义一些颜色,系统内获取
    int colors[]={android.R.color.holo_red_dark,android.R.color.holo_blue_dark,android.R.color.holo_orange_dark,android.R.color.holo_purple};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        final GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);//填写列数的最小公倍数
//        设置
//        mrecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
               @Override
               public int getSpanSize(int position) {
    //         **该方法可以区分你是第几个Item，那个类型，需要你横跨多少
                   int type=mrecyclerView.getAdapter().getItemViewType(position);//得打每个Item的Type
                   if(type==DataModle.TYPE_THREE){
                    return gridLayoutManager.getSpanCount();//该数字是上面2的分子
                   }else if(type==DataModle.TYPE_ONE){
                       return gridLayoutManager.getSpanCount();
                   }else if(type==DataModle.TYPE_FIVE){
                       return gridLayoutManager.getSpanCount();
                   }  else {
                       return 2;
                   }
               }
       });
        mrecyclerView.setLayoutManager(gridLayoutManager);

        mAdapter=new DemoAdapter(this);
        mrecyclerView.setAdapter(mAdapter);
//       设置Item的间隔
        mrecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

//           得到当前行数
                GridLayoutManager.LayoutParams layoutParams=(GridLayoutManager.LayoutParams)view.getLayoutParams();
                int spansize=layoutParams.getSpanSize();
                int spanIndex=layoutParams.getSpanIndex();
                outRect.top=20;//距离顶部的距离
                if(spansize!=gridLayoutManager.getSpanCount()){
             if(spanIndex==1){
                outRect.left=10;
             }else {
                 outRect.right=10;
             }
                }
            }
        });
//       数据
        initData();
    }

    private void initData() {
//        模拟后台的数据
        List<DataModle> list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int type= (int) ((Math.random()*3)+1);
            if(i<5||(i>15&&i<20)){
            type=1;
            }else if(i<10||i>26){
              type=2;
            }else {
                type=3;
            }
//不让超过线  让其一行一个
       DataModle data=new DataModle();
            data.avatarColor=colors[type-1];
            data.type=type;
            data.name="name:"+type;
            data.content="content"+i;
            data.contentColor=colors[(type+1)%3];//顺向取永远在avatarColor后面取
            list.add(data);
        }
        List<DataModleOne>list1=new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DataModleOne data=new DataModleOne();
            data.avatarColor=colors[0];
            data.name="name:"+1;
            list1.add(data);
        }
        List<DataModleTwo>list2=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModleTwo data=new DataModleTwo();
            data.avatarColor=colors[1];
            data.name="name:"+1;
            data.content="content"+1;
            list2.add(data);
        }
        List<DataModleThree>list3=new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DataModleThree data=new DataModleThree();
            data.avatarColor=colors[0];
            data.name="name:"+1;
            data.content="content"+1;
            data.contentColor=colors[2];
            list3.add(data);
        }
        List<DataModleFour>list4=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModleFour data=new DataModleFour();
            data.avatarColor=colors[3];
            data.name="name:"+1;
            list4.add(data);
        }
        List<DataModleFive>list5=new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DataModleFive data=new DataModleFive();
            data.avatarColor=colors[0];
            data.name="name:";
            list5.add(data);
        }
        List<DataModleSix>list6=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModleSix data=new DataModleSix();
            data.avatarColor=colors[1];
            data.name="name:";
            list6.add(data);
        }
        mAdapter.addList(list1,list2,list3,list4,list5,list6);
        mAdapter.notifyDataSetChanged();
    }
}
