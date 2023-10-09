package chap10.biz;

import chap10.dao.MemberDAO;
import chap10.entity.Member;

public class MemberService {
    public boolean register( Member member ) {
        MemberDAO dao = new MemberDAO();
        boolean result = dao.insertMember(member);
        
        return result;
    }

}
