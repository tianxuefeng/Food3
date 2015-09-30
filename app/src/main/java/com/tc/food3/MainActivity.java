package com.tc.food3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tc.food3.adapter.PriceListAdapter;
import com.tc.food3.bean.OrderedPlu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView priceListView;
    private PriceListAdapter adapter;
    private TextView submitTv;
    private TextView totalPriceTv;
    private float totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        priceListView = (ListView) findViewById(R.id.lv_price);
        List<OrderedPlu> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            OrderedPlu order = new OrderedPlu();
            order.setQty(i);
            order.setName("item " + i);
            float price = ((int) (100 * Math.random())) / 6 + 0.5f;
            totalPrice = totalPrice + price;
            order.setPrice(String.valueOf(price));
            data.add(order);
        }
        adapter = new PriceListAdapter(this);
        adapter.setData(data);
        priceListView.setAdapter(adapter);

        submitTv = (TextView) findViewById(R.id.tv_submit);
        submitTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ZxingCaptureActivity.class);
                startActivityForResult(intent, 99);
            }
        });
        totalPriceTv = (TextView) findViewById(R.id.tv_price_total);
        totalPriceTv.setText(getString(R.string.unit_dao, totalPrice));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && data != null) {
            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}
