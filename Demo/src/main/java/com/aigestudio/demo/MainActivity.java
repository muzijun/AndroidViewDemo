package com.aigestudio.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Android控件解析基类lk
 *
 * @author AigeStudio 2015-07-15
 */
public class MainActivity extends ListActivity {
    private static final String[] VIEWS = {"Toolbar", "TabLayout"};
    private static final Class[] CLASSES = {toolbar.MainActivity.class, tablayout.TabLayoutActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VIEWS);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, CLASSES[position]));
    }
}
