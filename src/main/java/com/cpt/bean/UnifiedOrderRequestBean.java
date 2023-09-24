package com.cpt.bean;

public class UnifiedOrderRequestBean {
    String MchOrderNo;
    String WayCode;
    int Amount;
    String currency;
    String Subject;
    String Body;
    String NotifyUrl;
    String ReturnUrl;
    String ExtParam;

    int ExpiredTime;
    String ClientIp;

    public String getMchOrderNo() {
        return MchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        MchOrderNo = mchOrderNo;
    }

    public String getWayCode() {
        return WayCode;
    }

    public void setWayCode(String wayCode) {
        WayCode = wayCode;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getNotifyUrl() {
        return NotifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        NotifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return ReturnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        ReturnUrl = returnUrl;
    }

    public String getExtParam() {
        return ExtParam;
    }

    public void setExtParam(String extParam) {
        ExtParam = extParam;
    }

    public int getExpiredTime() {
        return ExpiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        ExpiredTime = expiredTime;
    }

    public String getClientIp() {
        return ClientIp;
    }

    public void setClientIp(String clientIp) {
        ClientIp = clientIp;
    }
}
