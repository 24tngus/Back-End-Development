package chap09;

public class MemberService
{
    public boolean register( Member member )
    {
        // 회원등록 작업을 수행함.
        System.out.println("회원등록작업을 수행함");
        System.out.println("ID: " + member.getTfMemberID());
        return true;
    }
}
