package yd.cafe1637;

import java.io.Serializable;


class C20_ItemsAll implements Serializable {
    private String cId;     //쿠폰 번호
    private String flag;    //쿠폰 상태


    String getcId() {
        return cId;
    }

    String getFlag() {
        return flag;
    }


    C20_ItemsAll(String cId, String flag) {
        this.cId = cId;
        this.flag = flag;
    }
}
