package Beans;

public class BaseBean {
    private String userName;
    private String Address;

    //UserNameセッター
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //UserNameゲッター
    public String getUserName() {
        return this.userName;
    }

    //Addressセッター
    public void setAddress(String Address) {
        this.Address = Address;

    }
    //Addressゲッター
    public String getAddress() {
        return this.Address;
    }

}
