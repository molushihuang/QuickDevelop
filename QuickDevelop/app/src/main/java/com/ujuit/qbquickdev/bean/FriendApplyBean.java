package com.ujuit.qbquickdev.bean;


/**
 * Created by 东爷大帅比 on 2016/11/17.
 */

public class FriendApplyBean {

/**
 * 1	inviteMemberId	string	*	好友Id
 2	faceImg	string	*	好友头像
 3	isUploadFaceImg	string	*	是否上传头像,0:未上传，1：上传
 4	memberName	string	*	昵称或备注名
 5	nickName	string	*	好友本人的昵称
 6	proveStatus	String	*	实名认证状态 0未认证 1审核中（提交认证）2认证通过 3认证未通过
 7	callPhone	string	*	好友的电话号码
 8	operation	string	*	添加状态，0：请求添加，1：已经同意，2：已经拒绝
 9	messageId	string	*	消息id
 */


    private String inviteMemberId;
    private String faceImg;
    private int isUploadFaceImg;
    private String memberName;
    private String nickName;
    private String proveStatus;
    private String callPhone;
    private int operation;
    private String messageId;


    public String getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getInviteMemberId() {
        return inviteMemberId;
    }

    public void setInviteMemberId(String inviteMemberId) {
        this.inviteMemberId = inviteMemberId;
    }

    public int getIsUploadFaceImg() {
        return isUploadFaceImg;
    }

    public void setIsUploadFaceImg(int isUploadFaceImg) {
        this.isUploadFaceImg = isUploadFaceImg;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public String getProveStatus() {
        return proveStatus;
    }

    public void setProveStatus(String proveStatus) {
        this.proveStatus = proveStatus;
    }
}
