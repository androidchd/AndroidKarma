package com.KarmaLakeLand1;

class Contacts {
    public String name;
    String phone;
    //    boolean selected;
    boolean checkbox;


    public Contacts(String name, String phone, boolean status) {
        this.name = name;

        this.phone = phone;
        this.checkbox = status;
    }

//    public boolean isCheckbox() {
//        return checkbox;
//    }

//    public void setCheckbox(boolean checkbox) {
//
//        this.checkbox = checkbox;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getPhone() {
//        return phone;
//    }

//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public boolean isSelected() {
//        return selected;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
}
