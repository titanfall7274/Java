package collection.set.member;

import java.util.Objects;

// Object가 제공하는 equals 기능을 사용합니다.
public class MemberOnlyHash {

    private String id;

    public MemberOnlyHash(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /*@Override
    public boolean equals(Object x) {
        return (x == this);
    }*/
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MemberNoHashEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
