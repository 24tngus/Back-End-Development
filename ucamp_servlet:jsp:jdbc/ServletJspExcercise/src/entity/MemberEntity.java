/*------------------------------------------------------------------------------
 * Name : MemberEntity
 * Description : 멤버 정보에 대한 Entity 클래스
 * Version  : 1.0
 * Project : VCC Phase I - Web Workshop
 * Copyright 2008 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   변        경        사        항
 *------------------------------------------------------------------------------
 *     DATE       AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2008. 1. 1.   기술대학원    Ver1.0 작성
 *----------------------------------------------------------------------------*/

package entity;

/**
 * <pre>
 *  멤버 정보에 대한 Entity 클래스
 * </pre>
 * 
 * @author LG CNS 기술대학원
 * @version 1.0, 2008/01/01
 */
public class MemberEntity {

    private String tfMemberID;
    private String tfName;
    private String tfPassword;
    private String tfAddress;
    private String tfPhone;
    private String selPasswordQuestion;
    private String tfPasswordAnswer;
    private String rdMarriage;
    private String chkHobby;
    private String etc;

    public MemberEntity() {

    }

    public MemberEntity( String tfMemberID, String tfName, String tfPassword, String tfAddress,
            String tfPhone, String selPasswordQuestion, String tfPasswordAnswer, String rdMarriage,
            String chkHobby, String etc ) {

        this.setTfMemberID( tfMemberID );
        this.setTfName( tfName );
        this.setTfPassword( tfPassword );
        this.setTfAddress( tfAddress );
        this.setTfPhone( tfPhone );
        this.setSelPasswordQuestion( selPasswordQuestion );
        this.setTfPasswordAnswer( tfPasswordAnswer );
        this.setRdMarriage( rdMarriage );
        this.setChkHobby( chkHobby );
        this.setEtc( etc );
    }

    public void setTfMemberID( String tfMemberID ) {

        this.tfMemberID = tfMemberID;
    }

    public void setTfName( String tfName ) {

        this.tfName = tfName;
    }

    public void setTfPassword( String tfPassword ) {

        this.tfPassword = tfPassword;
    }

    public void setTfAddress( String tfAddress ) {

        this.tfAddress = tfAddress;
    }

    public void setTfPhone( String tfPhone ) {

        this.tfPhone = tfPhone;
    }

    public void setSelPasswordQuestion( String selPasswordQuestion ) {

        this.selPasswordQuestion = selPasswordQuestion;
    }

    public void setTfPasswordAnswer( String tfPasswordAnswer ) {

        this.tfPasswordAnswer = tfPasswordAnswer;
    }

    public void setRdMarriage( String rdMarriage ) {

        this.rdMarriage = rdMarriage;
    }

    public void setChkHobby( String chkHobby ) {

        this.chkHobby = chkHobby;
    }

    public void setEtc( String etc ) {

        this.etc = etc;
    }

    public String getTfMemberID() {

        return this.tfMemberID;
    }

    public String getTfName() {

        return this.tfName;
    }

    public String getTfPassword() {

        return this.tfPassword;
    }

    public String getTfAddress() {

        return this.tfAddress;
    }

    public String getTfPhone() {

        return this.tfPhone;
    }

    public String getSelPasswordQuestion() {

        return this.selPasswordQuestion;
    }

    public String getTfPasswordAnswer() {

        return this.tfPasswordAnswer;
    }

    public String getRdMarriage() {

        return this.rdMarriage;
    }

    public String getChkHobby() {

        return this.chkHobby;
    }

    public String getEtc() {

        return this.etc;
    }
}
