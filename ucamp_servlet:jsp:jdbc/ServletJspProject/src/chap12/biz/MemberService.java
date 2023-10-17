package chap12.biz;

import chap12.dao.MemberDAO;
import chap12.entity.Member;

public class MemberService {
    public boolean register( Member member ) {
        MemberDAO dao = new MemberDAO();
        boolean result = dao.insertMember(member);
        
        return result;
    }

}
