package com.seckawijoki.androidtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.adapter.DateGroupedItemAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/8/11.
 */

public class DateGroupedActivity extends AppCompatActivity {
  private RecyclerView rv;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_date_grouped_list);
    rv = (RecyclerView) findViewById(R.id.rv_date_grouped_list);
    final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    DateGroupedItemAdapter adapter = new DateGroupedItemAdapter(this, randomDateList());
    rv.setLayoutManager(layoutManager);
    rv.setAdapter(adapter);
  }

  private List<List<Long>> randomDateList(){
    int length1 = 12;
    int length2 = 9;
    int maxSeconds = 22320;
    List<Long>[] dateList = (List<Long>[]) Array.newInstance(List.class, length1);
    for (int i = 0; i < length1; ++i) {
      dateList[i] = new ArrayList<>();
    }

    for (int i = 0; i < length2; ++i){
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.SECOND, new Random(maxSeconds).nextInt());
      for (int j = 0; j < length1; ++j) {
        calendar.add(Calendar.DATE, 1);
        dateList[j].add(calendar.getTimeInMillis());
      }
    }

    List<List<Long>> allDateList = new ArrayList<>();
    for (int i = 0; i < length1; ++i)
      allDateList.add(dateList[i]);
    return allDateList;
  }
}
