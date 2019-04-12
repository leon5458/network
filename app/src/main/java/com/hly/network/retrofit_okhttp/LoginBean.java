package com.hly.network.retrofit_okhttp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/4/12~~~~~~
 * ~~~~~~更改时间:2019/4/12~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class LoginBean implements Serializable {
    public static final int RIGHT_CODE = 1;
    /**
     * status : 1
     * msg : 成功！
     * data : {"birthday":"","addTime":"","customerVerify":"","townCode":0,"cityCode":0,"nickName":"","provinceCode":0,"accountType":"android","sex":"","updateTime":"","idNumber":"","availableBalance":0,"token":"d9081a835de24a6eb3b8ef60f0f67338","sumIntegral":0,"streetAddress":"","freezingAmount":0,"name":"","tel":"","id":0,"state":0,"headPortrait":"http://img.upincar.com/ne/customer/default.png","pwd":"","account":"17601290637"}
     */

    private int status;
    private String msg;
    private DataBean data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * birthday :
         * addTime :
         * customerVerify :
         * townCode : 0
         * cityCode : 0
         * nickName :
         * provinceCode : 0
         * accountType : android
         * sex :
         * updateTime :
         * idNumber :
         * availableBalance : 0
         * token : d9081a835de24a6eb3b8ef60f0f67338
         * sumIntegral : 0
         * streetAddress :
         * freezingAmount : 0
         * name :
         * tel :
         * id : 0
         * state : 0
         * headPortrait : http://img.upincar.com/ne/customer/default.png
         * pwd :
         * account : 17601290637
         */

        private String birthday;
        private String addTime;
        private String customerVerify;
        private String townCode;
        private String cityCode;
        private String nickName;
        private String provinceCode;
        private String accountType;
        private String sex;
        private String idNumber;
        private String availableBalance;
        private String token;
        private String sumIntegral;
        private String streetAddress;
        private String freezingAmount;
        private String name;
        private String tel;
        private String id;
        private String state;
        private String headPortrait;
        @SerializedName("pwd")
        private String pwdX;
        private String account;
        private String appAmount;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getCustomerVerify() {
            return customerVerify;
        }

        public void setCustomerVerify(String customerVerify) {
            this.customerVerify = customerVerify;
        }

        public String getTownCode() {
            return townCode;
        }

        public void setTownCode(String townCode) {
            this.townCode = townCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getAvailableBalance() {
            return availableBalance;
        }

        public void setAvailableBalance(String availableBalance) {
            this.availableBalance = availableBalance;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getSumIntegral() {
            return sumIntegral;
        }

        public void setSumIntegral(String sumIntegral) {
            this.sumIntegral = sumIntegral;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getFreezingAmount() {
            return freezingAmount;
        }

        public void setFreezingAmount(String freezingAmount) {
            this.freezingAmount = freezingAmount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }

        public String getPwdX() {
            return pwdX;
        }

        public void setPwdX(String pwdX) {
            this.pwdX = pwdX;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getAppAmount() {
            return appAmount;
        }

        public void setAppAmount(String appAmount) {
            this.appAmount = appAmount;
        }
    }
}
