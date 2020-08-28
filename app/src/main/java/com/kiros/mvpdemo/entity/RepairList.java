package com.kiros.mvpdemo.entity;

import java.util.List;

/**
 * Created by kiros on 2019/8/21.
 */

public class RepairList {

    /**
     * code : 1
     * msg : 获取成功
     * time : 1567303541
     * data : [{"id":1,"title":"维修列表","content":"设备需要维修","createtime":"0000-00-00 00:00:00","create_uid":null,"device_uid":0,"closetime":null,"close_uid":null,"duty_uid":2,"create_uname":"Admin","device_no":null,"device_xh":null,"device_name":null,"close_uname":null,"duty_name":"刘备","areacode":"410781","area_name":null,"px":"114.074877064766","py":"35.420968272596","device_id":1,"dno":"2019061000001","name":"小院老灶火锅(卫辉店)","xh":"BTX-201523","areacode_id":"410781","addr":"新乡市卫辉市仿古街中段158号","installtime":"2019-06-10 00:00:00","company_id":1,"user_id":2,"wb_time":null,"un_work":0,"city_id":0,"county_id":0,"wb_status":0,"interval":0},{"id":3,"title":"设备故障，风扇坏了","content":"紧急故障，因操作不当，导致设备不能正常工作","createtime":"0000-00-00 00:00:00","create_uid":null,"device_uid":0,"closetime":null,"close_uid":null,"duty_uid":2,"create_uname":"Admin","device_no":null,"device_xh":null,"device_name":null,"close_uname":null,"duty_name":"刘备","areacode":"410781","area_name":null,"px":"114.077181218399","py":"35.420067277040","device_id":3,"dno":"2019061000003","name":"德胜楼","xh":"BTX-201508","areacode_id":"410781","addr":"新乡市卫辉市人民路","installtime":"2019-06-10 00:00:00","company_id":3,"user_id":2,"wb_time":null,"un_work":0,"city_id":0,"county_id":0,"wb_status":0,"interval":0}]
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
         * title : 维修列表
         * content : 设备需要维修
         * createtime : 0000-00-00 00:00:00
         * create_uid : null
         * device_uid : 0
         * closetime : null
         * close_uid : null
         * duty_uid : 2
         * create_uname : Admin
         * device_no : null
         * device_xh : null
         * device_name : null
         * close_uname : null
         * duty_name : 刘备
         * areacode : 410781
         * area_name : null
         * px : 114.074877064766
         * py : 35.420968272596
         * device_id : 1
         * dno : 2019061000001
         * name : 小院老灶火锅(卫辉店)
         * xh : BTX-201523
         * areacode_id : 410781
         * addr : 新乡市卫辉市仿古街中段158号
         * installtime : 2019-06-10 00:00:00
         * company_id : 1
         * user_id : 2
         * wb_time : null
         * un_work : 0
         * city_id : 0
         * county_id : 0
         * wb_status : 0
         * interval : 0
         */

        private int id;
        private String title;
        private String content;
        private String createtime;
        private Object create_uid;
        private int device_uid;
        private Object closetime;
        private Object close_uid;
        private int duty_uid;
        private String create_uname;
        private Object device_no;
        private Object device_xh;
        private Object device_name;
        private Object close_uname;
        private String duty_name;
        private String areacode;
        private Object area_name;
        private String px;
        private String py;
        private int device_id;
        private String dno;
        private String name;
        private String xh;
        private String areacode_id;
        private String addr;
        private String installtime;
        private int company_id;
        private int user_id;
        private Object wb_time;
        private int un_work;
        private int city_id;
        private int county_id;
        private int wb_status;
        private int interval;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getCreate_uid() {
            return create_uid;
        }

        public void setCreate_uid(Object create_uid) {
            this.create_uid = create_uid;
        }

        public int getDevice_uid() {
            return device_uid;
        }

        public void setDevice_uid(int device_uid) {
            this.device_uid = device_uid;
        }

        public Object getClosetime() {
            return closetime;
        }

        public void setClosetime(Object closetime) {
            this.closetime = closetime;
        }

        public Object getClose_uid() {
            return close_uid;
        }

        public void setClose_uid(Object close_uid) {
            this.close_uid = close_uid;
        }

        public int getDuty_uid() {
            return duty_uid;
        }

        public void setDuty_uid(int duty_uid) {
            this.duty_uid = duty_uid;
        }

        public String getCreate_uname() {
            return create_uname;
        }

        public void setCreate_uname(String create_uname) {
            this.create_uname = create_uname;
        }

        public Object getDevice_no() {
            return device_no;
        }

        public void setDevice_no(Object device_no) {
            this.device_no = device_no;
        }

        public Object getDevice_xh() {
            return device_xh;
        }

        public void setDevice_xh(Object device_xh) {
            this.device_xh = device_xh;
        }

        public Object getDevice_name() {
            return device_name;
        }

        public void setDevice_name(Object device_name) {
            this.device_name = device_name;
        }

        public Object getClose_uname() {
            return close_uname;
        }

        public void setClose_uname(Object close_uname) {
            this.close_uname = close_uname;
        }

        public String getDuty_name() {
            return duty_name;
        }

        public void setDuty_name(String duty_name) {
            this.duty_name = duty_name;
        }

        public String getAreacode() {
            return areacode;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public Object getArea_name() {
            return area_name;
        }

        public void setArea_name(Object area_name) {
            this.area_name = area_name;
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

        public int getDevice_id() {
            return device_id;
        }

        public void setDevice_id(int device_id) {
            this.device_id = device_id;
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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
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

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public int getCounty_id() {
            return county_id;
        }

        public void setCounty_id(int county_id) {
            this.county_id = county_id;
        }

        public int getWb_status() {
            return wb_status;
        }

        public void setWb_status(int wb_status) {
            this.wb_status = wb_status;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }
    }
}
