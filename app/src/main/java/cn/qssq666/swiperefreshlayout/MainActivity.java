package cn.qssq666.swiperefreshlayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HorizontalSwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerview));
        refreshLayout = ((HorizontalSwipeRefreshLayout) findViewById(R.id.swiperefreshlayout));
        refreshLayout.setOnRefreshListener(new HorizontalSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        Toast.makeText(MainActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.YELLOW);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public ArrayList<String> getStrings() {
            return strings;
        }

        public void setStrings(ArrayList<String> strings) {
            this.strings = strings;
        }

        ArrayList<String> strings = new ArrayList<>();

        {
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
            strings.add("情随事迁");
            strings.add("情迁QQ抢红包");
            strings.add("情迁微信抢红包");
            strings.add("情迁系统工具箱");
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_text, parent, false);

//            int padding = 10;
//            textView.setPadding(padding, padding, padding, padding);
            return new MyViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText("" + strings.get(position));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}

