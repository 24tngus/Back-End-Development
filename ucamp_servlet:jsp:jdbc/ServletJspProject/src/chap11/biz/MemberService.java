package chap11.biz;

import chap11.dao.MemberDAO;
import chap11.entity.Member;

public class MemberService {
    public boolean register( Member member ) {
        MemberDAO dao = new MemberDAO();
        boolean result = dao.insertMember(member);
        
        return result;
    }

}
