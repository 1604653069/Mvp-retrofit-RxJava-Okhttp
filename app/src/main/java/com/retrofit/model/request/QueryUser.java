package com.retrofit.model.request;

/**
 * 向服务器发送数据封装类
 */
public class QueryUser {
    private String useraccount;
    private String userpwd;

    public QueryUser() {
    }

    public QueryUser(String useraccount, String userpwd) {
        this.useraccount = useraccount;
        this.userpwd = userpwd;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public String toString() {
        return "QuestUser{" +
                "useraccount='" + useraccount + '\'' +
                ", userpwd='" + userpwd + '\'' +
                '}';
    }
}
