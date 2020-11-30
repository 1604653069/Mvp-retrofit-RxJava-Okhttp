package com.retrofit.model.request;

public class QuestUser {
    private String useraccount;
    private String userpwd;

    public QuestUser() {
    }

    public QuestUser(String useraccount, String userpwd) {
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
