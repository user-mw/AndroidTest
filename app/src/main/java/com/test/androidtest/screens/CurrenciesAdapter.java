package com.test.androidtest.screens;

import android.graphics.drawable.Drawable;
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
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    @Inject
    public IOnItemClick mItemClick;

    @Inject
    public IOnItemChangeAmount mOnItemChangeAmount;

    @Inject
    public HashMap<String, String> mFullNames;
    @Inject
    public HashMap<String, Drawable> mFlags;

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
        CurrencyItem currentItem = mDiffer.getCurrentList().get(i);
        currentItem.setFullName(mFullNames.get(currentItem.getAbbreviation()));
        currentItem.setFlagResource(mFlags.get(currentItem.getAbbreviation()));
        currencyViewHolder.bind(currentItem, mItemClick, mOnItemChangeAmount);
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
        mDiffer.submitList(items);
    }

    public interface IOnItemClick {
        void onClick(String newBaseCurrency, String currencyAmount);
        void onEdit(double amount, int position);
        void onFocusChanged(int position, double amount);
    }

    public interface IOnItemChangeAmount {
        void onChangeAmount(String newAmount);
    }
}