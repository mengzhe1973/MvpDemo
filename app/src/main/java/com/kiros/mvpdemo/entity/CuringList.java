package com.kiros.mvpdemo.entity;

import java.util.List;

/**
 * Created by kiros on 2019/8/21.
 */

public class CuringList {

    /**
     * code : 1
     * msg : 获取成功
     * time : 1566264893
     * data : [{"id":1,"dno":"2019061000001","name":"小院老灶火锅(卫辉店)","xh":"BTX-201523","areacode_id":"410781","addr":"新乡市卫辉市仿古街中段158号","installtime":"2019-06-10 00:00:00","company_id":1,"px":"114.074877064766","py":"35.420968272596","duty_uid":2,"user_id":null,"wb_time":null,"un_work":0},{"id":2,"dno":"2019061000002","name":"世魁牛肉","xh":"BTX-201502","areacode_id":"410781","addr":" 河南省新乡市卫辉市第二完全小学(比干大道北)","installtime":"2019-06-10 00:00:00","company_id":2,"px":"114.075990963598","py":"35.422052736474","duty_uid":2,"user_id":null,"wb_time":null,"un_work":0},{"id":3,"dno":"2019061000003","name":"德胜楼","xh":"BTX-201508","areacode_id":"410781","addr":"新乡市卫辉市人民路","installtime":"2019-06-10 00:00:00","company_id":3,"px":"114.077181218399","py":"35.420067277040","duty_uid":2,"user_id":null,"wb_time":null,"un_work":0},{"id":4,"dno":"2019061000005","name":"谷养元粥铺","xh":"BTX-2015062","areacode_id":"410781","addr":"河南省新乡市卫辉市中国农业银行(健康路北)","installtime":"2019-06-10 00:00:00","company_id":4,"px":"114.071719520898","py":"35.417405213211","duty_uid":2,"user_id":null,"wb_time":null,"un_work":0}]
     */

    private int code;
    private String msg;
    private String time;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * dno : 2019061000001
         * name : 小院老灶火锅(卫辉店)
         * xh : BTX-201523
         * areacode_id : 410781
         * addr : 新乡市卫辉市仿古街中段158号
         * installtime : 2019-06-10 00:00:00
         * company_id : 1
         * px : 114.074877064766
         * py : 35.420968272596
         * duty_uid : 2
         * user_id : null
         * wb_time : null
         * un_work : 0
         */

        private int id;
        private String dno;
        private String name;
        private String xh;
        private String areacode_id;
        private String addr;
        private String installtime;
        private int company_id;
        private String px;
        private String py;
        private int duty_uid;
        private Object user_id;
        private Object wb_time;
        private int un_work;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDno() {
            return dno;
        }

        public void setDno(String dno) {
            this.dno = dno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getAreacode_id() {
            return areacode_id;
        }

        public void setAreacode_id(String areacode_id) {
            this.areacode_id = areacode_id;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getInstalltime() {
            return installtime;
        }

        public void setInstalltime(String installtime) {
            this.installtime = installtime;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getPx() {
            return px;
        }

        public void setPx(String px) {
            this.px = px;
        }

        public String getPy() {
            return py;
        }

        public void setPy(String py) {
            this.py = py;
        }

        public int getDuty_uid() {
            return duty_uid;
        }

        public void setDuty_uid(int duty_uid) {
            this.duty_uid = duty_uid;
        }

        public Object getUser_id() {
            return user_id;
        }

        public void setUser_id(Object user_id) {
            this.user_id = user_id;
        }

        public Object getWb_time() {
            return wb_time;
        }

        public void setWb_time(Object wb_time) {
            this.wb_time = wb_time;
        }

        public int getUn_work() {
            return un_work;
        }

        public void setUn_work(int un_work) {
            this.un_work = un_work;
        }
    }
}
