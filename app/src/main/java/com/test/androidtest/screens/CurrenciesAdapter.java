package com.test.androidtest.screens;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.androidtest.R;
import com.test.androidtest.model.CurrencyItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    @Inject
    public IOnItemClick mItemClick;

    @Inject
    public IOnItemChangeAmount mOnItemChangeAmount;

    private final AsyncListDiffer<CurrencyItem> mDiffer = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    private final static DiffUtil.ItemCallback<CurrencyItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<CurrencyItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CurrencyItem currencyItem, @NonNull CurrencyItem t1) {
            return currencyItem.getAbbreviation().equals(t1.getAbbreviation());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CurrencyItem currencyItem, @NonNull CurrencyItem t1) {
            return currencyItem.getValue() == t1.getValue();
        }
    };

    @Inject
    public CurrenciesAdapter() {

    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewHolderView = inflater.inflate(R.layout.currency_list_element, viewGroup, false);

        return new CurrencyViewHolder(viewHolderView);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder currencyViewHolder, int i) {
        currencyViewHolder.bind(mDiffer.getCurrentList().get(i), mItemClick, mOnItemChangeAmount);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDiffer.getCurrentList().size();
    }

    public void addData(List<CurrencyItem> items) {
//        if(items != null) {
//            int start = 0;
//
//            if(mCurrencyItems.size() > 0) {
//                if(mCurrencyItems.get(0).getAbbreviation().equals(items.get(0).getAbbreviation())) {
//                    start = 1;
//                }
//
//                mCurrencyItems.clear();
//            }
//
//            mCurrencyItems.addAll(items);
//            notifyItemRangeChanged(start, items.size());
//        }
        mDiffer.submitList(items);
    }

    public interface IOnItemClick {
        void onClick(String newBaseCurrency, String currencyAmount);
    }

    public interface IOnItemChangeAmount {
        void onChangeAmount(String newAmount);
    }
}