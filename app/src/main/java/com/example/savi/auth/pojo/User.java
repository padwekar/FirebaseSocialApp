package com.example.savi.auth.pojo;


public class User {

    final static int MSG_USER_DATA_SUCCESS_IN = 0;
    final static int MSG_USER_DATA_SUCCESS_OUT = MSG_USER_DATA_SUCCESS_IN + 1;

    //PROFILE STATUS
    public final static int NEW = -9891 ;
    public final static int ACTIVE = -9892 ;


    //FRIENDSHIP STATUS
    public final static int NOT_FRIENDS = 0;
    public final static int REQUEST_SENT = NOT_FRIENDS + 1;
    public final static int FRIENDS = REQUEST_SENT + 1;
    public final static int FRIEND_REQUEST = FRIENDS + 1;// FRIEND REQUEST FROM ANOTHER PERSON

    //FRIENDSHIP ACTIONS
    public final static int ACTION_SEND_REQUEST = 0;
    public final static int ACTION_CANCEL_REQUEST = ACTION_SEND_REQUEST + 1;
    public final static int ACTION_UNFRIEND = ACTION_CANCEL_REQUEST + 1;
    public final static int ACTION_ACCEPT_REQUEST = ACTION_UNFRIEND + 1;
    public final static int ACTION_REJECT_REQUEST = ACTION_ACCEPT_REQUEST + 1;


    public final static String[] friendshipStatus = {"NOT FRIENDS", "SEND FRIEND REQUEST", "FRIENDS", "REQUEST FROM"};

    public final static String[] friendshipActions = {"SEND FRIEND REQUEST", "CANCEL FRIEND REQUEST", "UNFRIEND", "ACCEPT/REJECT"};

    private String uid;
    private String userName ;
    private String displayName;
    private String status;
    private String email;
    private String token;
    private String profileDownloadUri;
    private int profileStatus;
    private int picPosition;
    private transient int friendShipStatus;

    public User() {
        super();
        profileStatus = NEW ;
        displayName = "";
        status = "";
        email = "";
        picPosition = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProfileDownloadUri() {
        return profileDownloadUri;
    }

    public void setProfileDownloadUri(String profileDownloadUri) {
        this.profileDownloadUri = profileDownloadUri;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPicPosition() {
        return picPosition;
    }

    public void setPicPosition(int picPosition) {
        this.picPosition = picPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFriendShipStatus() {
        return friendShipStatus;
    }

    public void setFriendShipStatus(int friendShipStatus) {
        this.friendShipStatus = friendShipStatus;
    }

    @Override
    public boolean equals(Object obj) {
        return ((User) obj).getUid().equals(uid);
    }

    public int getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(int profileStatus) {
        this.profileStatus = profileStatus;
    }
}