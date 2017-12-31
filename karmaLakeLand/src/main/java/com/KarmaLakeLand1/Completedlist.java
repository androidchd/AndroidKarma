package com.KarmaLakeLand1;

import java.io.Serializable;

class Completedlist implements Serializable {
    public String hole;
    public String players;
    public String time;
    public String date;
    public String amount;
    public String addOn;
    public String bookingid;
    private String paymentStatus;
    public String bookStatus;
    public String session;
    public String bucket;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

//    private String getPaymentStatus() {
//        return paymentStatus;
//    }

//    private void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }

    public String getBookStatus() {
        return paymentStatus;
    }

    public void setBookStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public String getHole() {
        return hole;
    }

    public void setHole(String hole) {
        this.hole = hole;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean getPaymentStatus() {
        return false;
    }
}
