package com.retrofit.model.response;

public class User {

    /**
     * deptName : 手术室
     * userAccount : 0083
     * expire : 43200000
     * id : 25
     * userType : 1
     * userName : 林艾羽
     * depNum : 40324
     * token : 6f789bbad41d4dbc87fe12a4406a3c25
     */

    private String deptName;
    private String userAccount;
    private int expire;
    private int id;
    private int userType;
    private String userName;
    private String depNum;
    private String token;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepNum() {
        return depNum;
    }

    public void setDepNum(String depNum) {
        this.depNum = depNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "deptName='" + deptName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", expire=" + expire +
                ", id=" + id +
                ", userType=" + userType +
                ", userName='" + userName + '\'' +
                ", depNum='" + depNum + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
