package collection.set.member;

// Object가 제공하는 hashCode, equals 기능을 사용합니다.
public class MemberNoHashEq {

    private String id;

    public MemberNoHashEq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MemberNoHashEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
