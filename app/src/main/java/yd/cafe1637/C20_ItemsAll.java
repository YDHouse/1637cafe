package yd.cafe1637;

import java.io.Serializable;


class C20_ItemsAll implements Serializable {
    private String cId;     //쿠폰 번호
    private String flag;    //쿠폰 상태
    private String status;  //무료 쿠폰 사용 여부


    String getcId() {
        return cId;
    }

    String getFlag() {
        return flag;
    }

    String getStatus() { return  status; }


    C20_ItemsAll(String cId, String flag, String status) {
        this.cId = cId;
        this.flag = flag;
        this.status = status;
    }
}
