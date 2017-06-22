package com.kbeanie.runner;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.kbeanie.runner.adapters.MessagesAdapter;
import com.kbeanie.runner.adapters.OrderItemsAdapter;
import com.kbeanie.runner.data.OrdersProvider;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by vidushi on 21/6/17.
 */

public class OrderDetailsActivity extends RunnerActivity {
    @BindView(R.id.rvOrderItems)
    RecyclerView rvOrderItems;

    @BindView(R.id.rvMessages)
    RecyclerView rvMessages;

    @BindView(R.id.btnOrderAction)
    Button btnOrderAction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvOrderItems.setLayoutManager(lm);

        OrderItemsAdapter adapter = new OrderItemsAdapter(this, OrdersProvider.getSampleItems());
        rvOrderItems.setAdapter(adapter);

        LinearLayoutManager mlm = new LinearLayoutManager(this);
        rvMessages.setLayoutManager(mlm);
        MessagesAdapter messagesAdapter = new MessagesAdapter(this, OrdersProvider.getSampleMessages());
        rvMessages.setAdapter(messagesAdapter);

        // Button Tinting
        btnOrderAction.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.colorDarkGreen), PorterDuff.Mode.MULTIPLY);
    }

    @OnClick(R.id.ivClose)
    public void onCloseClick(){
        finish();
    }

    @OnClick(R.id.btnLeaveMessage)
    public void onLeaveMessage(){
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnOrderAction)
    public void onOrderAction(){

    }
}
