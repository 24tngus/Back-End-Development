package chap10.entity;

public class Member {
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
    
    public void setTfMemberID( String tfMemberID ){
        this.tfMemberID = tfMemberID;
    }
    public void setTfName( String tfName ){
        this.tfName = tfName;
    }
    public void setTfPassword( String tfPassword ) {
        this.tfPassword = tfPassword;
    }
    public void setTfAddress( String tfAddress ) {
        this.tfAddress = tfAddress;
    }
    public void setTfPhone( String tfPhone ){
        this.tfPhone = tfPhone;
    }
    public void setSelPasswordQuestion( String selPasswordQuestion ){
        this.selPasswordQuestion = selPasswordQuestion;
    }
    public void setTfPasswordAnswer( String tfPasswordAnswer ){
        this.tfPasswordAnswer = tfPasswordAnswer;
    }
    public void setRdMarriage( String rdMarriage ){
        this.rdMarriage = rdMarriage;
    }
    public void setChkHobby( String chkHobby ){
        this.chkHobby = chkHobby;
    }
    public void setEtc( String etc ){
        this.etc = etc;
    }
    public String getTfMemberID(){ return this.tfMemberID; }
    public String getTfName(){ return this.tfName; }
    public String getTfPassword(){ return this.tfPassword; }
    public String getTfAddress(){ return this.tfAddress; }
    public String getTfPhone(){ return this.tfPhone; }
    public String getSelPasswordQuestion(){ return this.selPasswordQuestion; }
    public String getTfPasswordAnswer(){ return this.tfPasswordAnswer; }
    public String getRdMarriage(){ return this.rdMarriage; }
    public String getChkHobby(){ return this.chkHobby; }
    public String getEtc(){ return this.etc; }

}
















