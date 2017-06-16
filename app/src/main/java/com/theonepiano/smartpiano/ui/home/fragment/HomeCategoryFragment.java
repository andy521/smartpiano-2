package com.theonepiano.smartpiano.ui.home.fragment;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.theonepiano.smartpiano.R;
import com.theonepiano.smartpiano.base.BaseFragment;
import com.theonepiano.smartpiano.base.BaseView;
import com.theonepiano.smartpiano.model.home.HomeCategoryModel;
import com.theonepiano.smartpiano.model.home.bean.HomeCateList;
import com.theonepiano.smartpiano.model.home.bean.HomeCategoryGenreList;
import com.theonepiano.smartpiano.presenter.home.impl.HomeCategoryPresenter;
import com.theonepiano.smartpiano.presenter.home.interfaces.HomeCategoryContract;
import com.theonepiano.smartpiano.ui.home.adapter.GenresDropDownAdapter;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jim on 2017/6/13.
 */

public class HomeCategoryFragment extends BaseFragment<HomeCategoryModel, HomeCategoryPresenter> implements HomeCategoryContract.View {
    @BindView(R.id.drop_down_menu)
    DropDownMenu mGenreDropDownMenu;

    GenresDropDownAdapter mGenreListAdapter1;
    GenresDropDownAdapter mGenreListAdapter2;
    GenresDropDownAdapter mGenreListAdapter3;
    GenresDropDownAdapter mGenreListAdapter4;
    GenresDropDownAdapter mGenreListAdapter5;


    private String headers[] = {"难度", "人群", "风格", "场景", "更多"};
    private String difficulties[] = {"不限", "新手", "流行", "古典", "轻音乐"};
    private String peoples[] = {"儿童", "成人", "老师"};
    private String styles[] = {"流行", "古典", "轻音乐"};
    private String scenes[] = {"弹唱", "节日", "求婚", "练琴"};
    private String more[] = {"最新曲集", "最热曲集", "经典教材", "考级教材", "直播课专区"};

    private List<View> popupViews = new ArrayList<>();

    public static HomeCategoryFragment getInstance(HomeCateList homeCateList, int position) {
        HomeCategoryFragment fragment = new HomeCategoryFragment();

        // TODO

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_category;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

    @Override
    protected BaseView getViewImpl() {
        return this;
    }

    @Override
    protected void lazyFetchData() {
        mPresenter.getHomeCategoryGenreList();
    }

    @Override
    public void onGetCategoryGenreList(List<HomeCategoryGenreList> genreList) {
        initGenresDropDownMenu(genreList);
    }

    private void initGenresDropDownMenu(List<HomeCategoryGenreList> genreList) {
        final ListView genresListView1 = new ListView(getActivity());

        mGenreListAdapter1 = new GenresDropDownAdapter(getActivity(), Arrays.asList(difficulties));
        genresListView1.setDividerHeight(0);
        genresListView1.setAdapter(mGenreListAdapter1);

        popupViews.add(genresListView1);

        genresListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGenreListAdapter1.setCheckedItemPosition(position);
                mGenreDropDownMenu.setTabText(position == 0 ? headers[0] : difficulties[position]);
                mGenreDropDownMenu.closeMenu();
            }
        });

        final ListView genresListView2 = new ListView(getActivity());

        mGenreListAdapter2 = new GenresDropDownAdapter(getActivity(), Arrays.asList(peoples));
        genresListView2.setDividerHeight(0);
        genresListView2.setAdapter(mGenreListAdapter2);

        popupViews.add(genresListView2);

        genresListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGenreListAdapter2.setCheckedItemPosition(position);
                mGenreDropDownMenu.setTabText(position == 0 ? headers[1] : peoples[position]);
                mGenreDropDownMenu.closeMenu();
            }
        });

        final ListView genresListView3 = new ListView(getActivity());

        mGenreListAdapter2 = new GenresDropDownAdapter(getActivity(), Arrays.asList(styles));
        genresListView3.setDividerHeight(0);
        genresListView3.setAdapter(mGenreListAdapter2);

        popupViews.add(genresListView3);

        genresListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGenreListAdapter2.setCheckedItemPosition(position);
                mGenreDropDownMenu.setTabText(position == 0 ? headers[2] : styles[position]);
                mGenreDropDownMenu.closeMenu();
            }
        });

        final ListView genresListView4 = new ListView(getActivity());

        mGenreListAdapter3 = new GenresDropDownAdapter(getActivity(), Arrays.asList(scenes));
        genresListView4.setDividerHeight(0);
        genresListView4.setAdapter(mGenreListAdapter3);

        popupViews.add(genresListView4);

        genresListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGenreListAdapter3.setCheckedItemPosition(position);
                mGenreDropDownMenu.setTabText(position == 0 ? headers[3] : scenes[position]);
                mGenreDropDownMenu.closeMenu();
            }
        });

        final ListView genresListView = new ListView(getActivity());

        mGenreListAdapter5 = new GenresDropDownAdapter(getActivity(), Arrays.asList(more));
        genresListView.setDividerHeight(0);
        genresListView.setAdapter(mGenreListAdapter5);

        popupViews.add(genresListView);

        genresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGenreListAdapter5.setCheckedItemPosition(position);
                mGenreDropDownMenu.setTabText(position == 0 ? headers[4] : more[position]);
                mGenreDropDownMenu.closeMenu();
            }
        });

        TextView contentView = new TextView(getActivity());
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        // init dropdownview
        mGenreDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, contentView);
    }
}
