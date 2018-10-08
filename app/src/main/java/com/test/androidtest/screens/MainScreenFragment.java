package com.test.androidtest.screens;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.androidtest.MainApplication;
import com.test.androidtest.R;
import com.test.androidtest.dependencies.DaggerIItemComponent;
import com.test.androidtest.dependencies.ItemModule;
import com.test.androidtest.dependencies.ViewModelModule;

import javax.inject.Inject;

public class MainScreenFragment extends Fragment {

    @Inject
    MainScreenViewModel mViewModel;

    private RecyclerView mCurrenciesRecycler;
    private CurrenciesAdapter mCurrenciesAdapter;
    private TextView mSimpleTitle;
    private CurrenciesAdapter.IOnItemClick mOnItemClick = new CurrenciesAdapter.IOnItemClick() {
        @Override
        public void onClick(String newBaseCurrency) {
            mViewModel.changeBaseCurrency(newBaseCurrency);
        }

        @Override
        public void onChangeAmountClick(String newAmount) {
            mViewModel.changeAmount(newAmount);
        }
    };

    public static MainScreenFragment newInstance() {
        Bundle args = new Bundle();

        MainScreenFragment fragment = new MainScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        MainApplication.getApplicationComponent()
                .plusViewModelComponent(new ViewModelModule(this))
                .inject(this);

        mCurrenciesAdapter = new CurrenciesAdapter();

        DaggerIItemComponent.builder()
                .itemModule(new ItemModule(mOnItemClick))
                .build()
                .inject(mCurrenciesAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mCurrenciesRecycler = view.findViewById(R.id.currencies_recycler);
        mSimpleTitle = view.findViewById(R.id.simple_title_tv);

        mCurrenciesRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCurrenciesRecycler.setAdapter(mCurrenciesAdapter);

        mViewModel.getSimpleTitle().observe(this, title -> mSimpleTitle.setText(title));
        mViewModel.getCurrencies().observe(this, currencies -> {
            if(currencies != null && currencies.size() > 0) {
                mCurrenciesAdapter.addData(currencies);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //mViewModel.loadData();
        mViewModel.loadNewData();
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModel.detach();
    }
}
