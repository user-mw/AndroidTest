package com.test.androidtest.screens;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    private CurrenciesAdapter.IOnItemClick mOnItemClick;
    private CurrenciesAdapter.IOnItemChangeAmount mOnItemChangeAmount;

    private TextWatcher mCustomTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(CURRENCY_VIEW_HOLDER_TAG, "beforeTextChanged: called");
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(CURRENCY_VIEW_HOLDER_TAG, "onTextChanged: called");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            mOnItemChangeAmount.onChangeAmount(editable.toString());
        }
    };

    public CurrencyViewHolder(@NonNull View itemView) {
        super(itemView);

        mMainView = itemView;

        mCurrencyFlag = itemView.findViewById(R.id.flag);
        mCurrencyAbbreviation = itemView.findViewById(R.id.currency_abbreviation);
        mCurrencyName = itemView.findViewById(R.id.currency_name);
        mCurrencyAmount = itemView.findViewById(R.id.currency_amount);
    }

    public void bind(CurrencyItem item, CurrenciesAdapter.IOnItemClick clickListener, CurrenciesAdapter.IOnItemChangeAmount onItemChangeAmount) {
        mCurrencyAbbreviation.setText(item.getAbbreviation());
        mCurrencyName.setText(item.getFullName());
        mCurrencyAmount.setText(CurrenciesStringUtil.generateAmountString(item.getValue()));
        mCurrencyAmount.setSelection(mCurrencyAmount.getText().length());
        mOnItemClick = clickListener;
        mOnItemChangeAmount = onItemChangeAmount;

        mMainView.setOnClickListener(view -> {
            String abbreviation = mCurrencyAbbreviation.getText().toString();
            String amount = mCurrencyAmount.getText().toString();

            mOnItemClick.onClick(abbreviation, amount);
        });

        if(getAdapterPosition() == 0) {
            mCurrencyAmount.removeTextChangedListener(mCustomTextChangedListener);
            mCurrencyAmount.addTextChangedListener(mCustomTextChangedListener);
        }
    }
}
