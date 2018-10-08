package com.test.androidtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class ApiResponse {

    @SerializedName("base")
    private String mBase;
    @SerializedName("date")
    private String mDate;
    @SerializedName("rates")
    private HashMap<String, Double> mRates;

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        mBase = base;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public HashMap<String, Double> getRates() {
        return mRates;
    }

    public void setRates(HashMap<String, Double> rates) {
        mRates = rates;
    }

//    public RatesBean getRates() {
//        return mRates;
//    }
//
//    public void setRates(RatesBean rates) {
//        mRates = rates;
//    }

//    public static class RatesBean {
//        @SerializedName("AUD")
//        private double mAUD;
//        @SerializedName("BGN")
//        private double mBGN;
//        @SerializedName("BRL")
//        private double mBRL;
//        @SerializedName("CAD")
//        private double mCAD;
//        @SerializedName("CHF")
//        private double mCHF;
//        @SerializedName("CNY")
//        private double mCNY;
//        @SerializedName("CZK")
//        private double mCZK;
//        @SerializedName("DKK")
//        private double mDKK;
//        @SerializedName("GBP")
//        private double mGBP;
//        @SerializedName("HKD")
//        private double mHKD;
//        @SerializedName("HRK")
//        private double mHRK;
//        @SerializedName("HUF")
//        private double mHUF;
//        @SerializedName("IDR")
//        private double mIDR;
//        @SerializedName("ILS")
//        private double mILS;
//        @SerializedName("INR")
//        private double mINR;
//        @SerializedName("ISK")
//        private double mISK;
//        @SerializedName("JPY")
//        private double mJPY;
//        @SerializedName("KRW")
//        private double mKRW;
//        @SerializedName("MXN")
//        private double mMXN;
//        @SerializedName("MYR")
//        private double mMYR;
//        @SerializedName("NOK")
//        private double mNOK;
//        @SerializedName("NZD")
//        private double mNZD;
//        @SerializedName("PHP")
//        private double mPHP;
//        @SerializedName("PLN")
//        private double mPLN;
//        @SerializedName("RON")
//        private double mRON;
//        @SerializedName("SEK")
//        private double mSEK;
//        @SerializedName("SGD")
//        private double mSGD;
//        @SerializedName("THB")
//        private double mTHB;
//        @SerializedName("TRY")
//        private double mTRY;
//        @SerializedName("USD")
//        private double mUSD;
//        @SerializedName("ZAR")
//        private double mZAR;
//        @SerializedName("EUR")
//        private double mEUR;
//        @SerializedName("RUB")
//        private double mRUB;
//
//        public double getAUD() {
//            return mAUD;
//        }
//
//        public void setAUD(double aUD) {
//            mAUD = aUD;
//        }
//
//        public double getBGN() {
//            return mBGN;
//        }
//
//        public void setBGN(double bGN) {
//            mBGN = bGN;
//        }
//
//        public double getBRL() {
//            return mBRL;
//        }
//
//        public void setBRL(double bRL) {
//            mBRL = bRL;
//        }
//
//        public double getCAD() {
//            return mCAD;
//        }
//
//        public void setCAD(double cAD) {
//            mCAD = cAD;
//        }
//
//        public double getCHF() {
//            return mCHF;
//        }
//
//        public void setCHF(double cHF) {
//            mCHF = cHF;
//        }
//
//        public double getCNY() {
//            return mCNY;
//        }
//
//        public void setCNY(double cNY) {
//            mCNY = cNY;
//        }
//
//        public double getCZK() {
//            return mCZK;
//        }
//
//        public void setCZK(double cZK) {
//            mCZK = cZK;
//        }
//
//        public double getDKK() {
//            return mDKK;
//        }
//
//        public void setDKK(double dKK) {
//            mDKK = dKK;
//        }
//
//        public double getGBP() {
//            return mGBP;
//        }
//
//        public void setGBP(double gBP) {
//            mGBP = gBP;
//        }
//
//        public double getHKD() {
//            return mHKD;
//        }
//
//        public void setHKD(double hKD) {
//            mHKD = hKD;
//        }
//
//        public double getHRK() {
//            return mHRK;
//        }
//
//        public void setHRK(double hRK) {
//            mHRK = hRK;
//        }
//
//        public double getHUF() {
//            return mHUF;
//        }
//
//        public void setHUF(double hUF) {
//            mHUF = hUF;
//        }
//
//        public double getIDR() {
//            return mIDR;
//        }
//
//        public void setIDR(double iDR) {
//            mIDR = iDR;
//        }
//
//        public double getILS() {
//            return mILS;
//        }
//
//        public void setILS(double iLS) {
//            mILS = iLS;
//        }
//
//        public double getINR() {
//            return mINR;
//        }
//
//        public void setINR(double iNR) {
//            mINR = iNR;
//        }
//
//        public double getISK() {
//            return mISK;
//        }
//
//        public void setISK(double iSK) {
//            mISK = iSK;
//        }
//
//        public double getJPY() {
//            return mJPY;
//        }
//
//        public void setJPY(double jPY) {
//            mJPY = jPY;
//        }
//
//        public double getKRW() {
//            return mKRW;
//        }
//
//        public void setKRW(double kRW) {
//            mKRW = kRW;
//        }
//
//        public double getMXN() {
//            return mMXN;
//        }
//
//        public void setMXN(double mXN) {
//            mMXN = mXN;
//        }
//
//        public double getMYR() {
//            return mMYR;
//        }
//
//        public void setMYR(double mYR) {
//            mMYR = mYR;
//        }
//
//        public double getNOK() {
//            return mNOK;
//        }
//
//        public void setNOK(double nOK) {
//            mNOK = nOK;
//        }
//
//        public double getNZD() {
//            return mNZD;
//        }
//
//        public void setNZD(double nZD) {
//            mNZD = nZD;
//        }
//
//        public double getPHP() {
//            return mPHP;
//        }
//
//        public void setPHP(double pHP) {
//            mPHP = pHP;
//        }
//
//        public double getPLN() {
//            return mPLN;
//        }
//
//        public void setPLN(double pLN) {
//            mPLN = pLN;
//        }
//
//        public double getRON() {
//            return mRON;
//        }
//
//        public void setRON(double rON) {
//            mRON = rON;
//        }
//
//        public double getSEK() {
//            return mSEK;
//        }
//
//        public void setSEK(double sEK) {
//            mSEK = sEK;
//        }
//
//        public double getSGD() {
//            return mSGD;
//        }
//
//        public void setSGD(double sGD) {
//            mSGD = sGD;
//        }
//
//        public double getTHB() {
//            return mTHB;
//        }
//
//        public void setTHB(double tHB) {
//            mTHB = tHB;
//        }
//
//        public double getTRY() {
//            return mTRY;
//        }
//
//        public void setTRY(double tRY) {
//            mTRY = tRY;
//        }
//
//        public double getUSD() {
//            return mUSD;
//        }
//
//        public void setUSD(double uSD) {
//            mUSD = uSD;
//        }
//
//        public double getZAR() {
//            return mZAR;
//        }
//
//        public void setZAR(double zAR) {
//            mZAR = zAR;
//        }
//
//        public double getEUR() {
//            return mEUR;
//        }
//
//        public void setEUR(double eUR) {
//            mEUR = eUR;
//        }
//
//        public double getRUB() {
//            return mRUB;
//        }
//
//        public void setRUB(double RUB) {
//            mRUB = RUB;
//        }
//    }
}
