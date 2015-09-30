package com.tc.food3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tc.food3.R;
import com.tc.food3.bean.OrderedPlu;

import java.util.List;

/**
 * User: tianchao
 * Date: 15/9/30
 * Time: 下午5:31
 * PS: 学如逆水行舟，不进则退
 */
public class PriceListAdapter extends BaseAdapter {
    private Context context;
    private List<OrderedPlu> data;

    public PriceListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<OrderedPlu> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public OrderedPlu getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_price_list, parent, false);
            holder = new ViewHolder();
            holder.tvQty = (TextView) convertView.findViewById(R.id.tv_qty);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);
            holder.ivDelete = (ImageView) convertView.findViewById(R.id.iv_delete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        OrderedPlu item = getItem(position);
        holder.tvQty.setText(String.valueOf(item.getQty()));
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(context.getString(R.string.unit_dao, item.getPrice()));
        holder.ivDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "onclick item "+position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    private final class ViewHolder {
        TextView tvQty;
        TextView tvName;
        TextView tvPrice;
        ImageView ivDelete;
    }
}
