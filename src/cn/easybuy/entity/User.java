package cn.easybuy.entity;

/**
 *用户表
 */
public class User {
    private Integer id;//用户id
    private String loginName;//用户网名
    private String userName;//用户名
    private String password;//密码
    private Integer   sex;//性别
    private String identityCode;//身份证号
    private String  email;//邮箱
    private String    mobile;//手机号;
    private Integer type;//用户类型

    public User(String loginName, String userName, String password, String email, String mobile) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", identityCode='" + identityCode + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public User() {
    }

    public User(Integer id, String loginName, String userName, String password, Integer sex, String identityCode, String email, String mobile, Integer type) {
        this.id = id;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
    }
}
