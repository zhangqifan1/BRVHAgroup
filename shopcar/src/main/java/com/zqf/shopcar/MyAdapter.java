package com.zqf.shopcar;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -----------------------------
 * Created by zqf on 2018/3/27.
 * ---------------------------
 */

public class MyAdapter extends BaseQuickAdapter<HashMap<String, String>, BaseViewHolder> {
    public IRefresh iRefresh;

    public void setiRefresh(IRefresh iRefresh) {
        this.iRefresh = iRefresh;
    }

    private HashMap<String, Boolean> map = new HashMap<>();
    private List<HashMap<String, String>> dataList;

    public MyAdapter(int layoutResId, @Nullable List<HashMap<String, String>> dataList) {
        super(layoutResId, dataList);
        this.dataList = dataList;
        //cb标识
        if (dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                map.put(dataList.get(i).get("id"), false);
            }
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        final int position = helper.getPosition();

        final CheckBox cb = helper.getView(R.id.cb);
        TextView tvContent = helper.getView(R.id.tvContent);
        PlusReduceView addsub = helper.getView(R.id.abbsub);
        Button butDelete = helper.getView(R.id.butDelete);
        final TextView tvTotal = helper.getView(R.id.tvTotal);


        //首先判空
        if (dataList.size() > 0) {
            String id = dataList.get(position).get("id");
            cb.setChecked(map.get(id));
            iRefresh.refreshIsChecked(selectAll());
            iRefresh.refreshPrice(map);
        }
        //商品信息
        final HashMap<String, String> GoodsInfoHashMap = dataList.get(position);

        tvContent.setText("商品:" + GoodsInfoHashMap.get("name") + "\n" + "商品单价:" + GoodsInfoHashMap.get("price"));
        tvTotal.setText(GoodsInfoHashMap.get("count") + "件,共计:" + Integer.parseInt(GoodsInfoHashMap.get("price")) * Integer.parseInt(GoodsInfoHashMap.get("count")) + "元");

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.remove(GoodsInfoHashMap.get("id"));
                dataList.remove(position);
                notifyDataSetChanged();
                iRefresh.refreshPrice(map);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    map.put(GoodsInfoHashMap.get("id"), true);
                } else {
                    map.put(GoodsInfoHashMap.get("id"), false);
                }
                iRefresh.refreshIsChecked(selectAll());
                iRefresh.refreshPrice(map);
            }
        });

        addsub.setListener(new PlusReduceView.Listener() {
            @Override
            public void changed(String string) {
                GoodsInfoHashMap.put("count", string);
                tvTotal.setText(GoodsInfoHashMap.get("count") + "件,共计:" + Integer.parseInt(GoodsInfoHashMap.get("price")) * Integer.parseInt(GoodsInfoHashMap.get("count")) + "元");
//                notifyDataSetChanged();
            }
        });
    }
    public void setMap(HashMap<String, Boolean> map) {
        this.map.putAll(map);
        notifyDataSetChanged();
    }

    public HashMap<String, Boolean> getMap() {
        return map;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    //全选方法
    public boolean selectAll() {
        boolean isChecked = true;
        //遍历标识
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue() == false) {
                isChecked = false;
                break;
            }
        }
        return isChecked;
    }
}
