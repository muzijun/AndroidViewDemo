package tablayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aigestudio.demo.R;

/**
 * TabLayout与ViewPager
 *
 * @author AigeStudio 2015-07-29
 */
public class TabLayoutActivity extends Activity {
    /**
     * 数据源
     */
    private static final String[] DATA = {"AigeStudio", "Aige", "Studio", "Android", "Java", "Design"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_tab_layout);

        // 获取ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.ac_tab_vp);

        // 构造一个TabPagerAdapter对象
        TabPagerAdapter adapter = new TabPagerAdapter();

        // 获取ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.ac_tab_layout);

        // 设置TabLayout模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

//        // 设置从PagerAdapter中获取Tab
//        tabLayout.setTabsFromPagerAdapter(adapter);
//
//        // 设置Tab的选择监听
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                // 每当我们选择了一个Tab就将ViewPager滚动至对应的Page
//                viewPager.setCurrentItem(tab.getPosition(), true);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//        // 构造一个TabLayoutOnPageChangeListener对象
//        TabLayout.TabLayoutOnPageChangeListener listener =
//                new TabLayout.TabLayoutOnPageChangeListener(tabLayout);
//
//        // 设置ViewPager页面改变后的监听
//        viewPager.addOnPageChangeListener(listener);

        // 设置ViewPager的适配器
        viewPager.setAdapter(adapter);

        // 设置ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    private class TabPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return DATA.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tvContent = new TextView(TabLayoutActivity.this);
            tvContent.setText(DATA[position]);
            tvContent.setGravity(Gravity.CENTER);
            container.addView(tvContent,
                    ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return tvContent;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return DATA[position];
        }
    }
}