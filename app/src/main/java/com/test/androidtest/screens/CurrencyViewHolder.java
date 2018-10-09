package com.test.androidtest.screens;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.androidtest.R;
import com.test.androidtest.model.CurrencyItem;
import com.test.androidtest.utils.CurrenciesStringUtil;

public class CurrencyViewHolder extends RecyclerView.ViewHolder {

    private static final String CURRENCY_VIEW_HOLDER_TAG = "CurrencyViewHolder";

    private View mMainView;
    private ImageView mCurrencyFlag;
    private TextView mCurrencyAbbreviation;
    private TextView mCurrencyName;
    private EditText mCurrencyAmount;

    public CurrencyViewHolder(@NonNull View itemView) {
        super(itemView);

        mMainView = itemView;

        mCurrencyFlag = itemView.findViewById(R.id.flag);
        mCurrencyAbbreviation = itemView.findViewById(R.id.currency_abbreviation);
        mCurrencyName = itemView.findViewById(R.id.currency_name);
        mCurrencyAmount = itemView.findViewById(R.id.currency_amount);
    }

    public void bind(CurrencyItem item, CurrenciesAdapter.IOnItemClick mClick) {
        mCurrencyAbbreviation.setText(item.getAbbreviation());
        mCurrencyName.setText(item.getFullName());
        mCurrencyAmount.setText(CurrenciesStringUtil.generateAmountString(item.getValue()));
        mCurrencyAmount.setSelection(mCurrencyAmount.getText().length());

        mMainView.setOnClickListener(view -> mClick.onClick(mCurrencyAbbreviation.getText().toString()));
    }
}
