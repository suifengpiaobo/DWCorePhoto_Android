package davidwang.tm.dwcorephoto;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;

import davidwang.tm.adapter.MixListAdapter;
import davidwang.tm.model.ImageBrowseBean;
import davidwang.tm.model.Mixinfo;
import davidwang.tm.view.PullToZoomListView;

public class MixShowActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    public PullToZoomListView mixlist;
    private MixListAdapter adapterData;
    private ArrayList<Mixinfo> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_show);
        findID();
        InData();
        AddToolbar();
    }


    @Override
    protected void findID() {
        super.findID();
        mixlist = (PullToZoomListView)findViewById(R.id.mixlist);
        mixlist.getHeaderView().setImageResource(R.mipmap.mixheadimg);
        mixlist.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        mixlist.setOnItemClickListener(this);
    }

    @Override
    public void InData() {
        super.InData();
        data = new ArrayList<Mixinfo>();
        Mixinfo info1 = new Mixinfo();
        info1.username = "DavidWang";
        info1.userimg = "http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg";
        info1.content = "这是一个单张的演示";
        info1.data = AddData(1,0);
        data.add(info1);

        Mixinfo info2 = new Mixinfo();
        info2.username = "DavidWang";
        info2.userimg = "http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg";
        info2.content = "这是一个单张的演示";
        info2.data = AddData(1,1);
        data.add(info2);

        Mixinfo info3 = new Mixinfo();
        info3.username = "DavidWang";
        info3.userimg = "http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg";
        info3.content = "这是一个单张的演示";
        info3.data = AddData(1,2);
        data.add(info3);

        for (int i = 2; i < 10; i++){
            Mixinfo info4 = new Mixinfo();
            info4.username = "DavidWang";
            info4.userimg = "http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg";
            info4.content = "这是"+i+"个单张的演示";
            info4.data = AddData(i,2);
            data.add(info4);
        }

        adapterData = new MixListAdapter(MixShowActivity.this,data);
        mixlist.setAdapter(adapterData);

    }

    private ArrayList<ImageBrowseBean> AddData(int num,int type){
        ArrayList<ImageBrowseBean> data = new ArrayList<>();
        for (int i = 0 ; i < num; i++){
            if (type == 0){
                ImageBrowseBean info = new ImageBrowseBean();
                info.setUrl("http://img4q.duitang.com/uploads/item/201408/11/20140811141753_iNtAF.jpeg");
                info.setWidth(1280);
                info.setHeight(720);
                data.add(info);
            }else if(type == 1) {
                ImageBrowseBean info = new ImageBrowseBean();
                info.setUrl("http://article.joyme.com/article/uploads/allimg/140812/101I01291-10.jpg");
                info.setWidth(640);
                info.setHeight(960);
                data.add(info);
            }else{
                ImageBrowseBean info = new ImageBrowseBean();
                info.setUrl("http://h.hiphotos.baidu.com/album/scrop%3D236%3Bq%3D90/sign=2fab0be130adcbef056a3959dc921cee/4b90f603738da977c61bb40eb151f8198618e3db.jpg");
                info.setWidth(236);
                info.setHeight(236);
                data.add(info);
            }
        }
        return data;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("1",position+"haha");
    }
}
