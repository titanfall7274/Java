package collection.map.test.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberRepository {

    private final Map<String, Member> members;

    public MemberRepository() {
        members = new HashMap<>();
    }

    public MemberRepository(Map<String, Member> members) {
        this.members = members;
    }

    public void save(Member member) {
        members.put(member.getId(), member);
    }

    public Member findById(String id) {
        return members.get(id);
    }

    public Member findByValue(String name) {
        for (Member member : members.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    public void remove(String id) {
        members.remove(id);
    }
}
