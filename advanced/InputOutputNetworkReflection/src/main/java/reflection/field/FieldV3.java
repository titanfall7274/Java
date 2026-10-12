package reflection.field;

import reflection.data.Team;
import reflection.data.User;

public class FieldV3 {

    public static void main(String[] args) {
        // String 속성인 name에 null, Integer 속성인 age에 null
        User user = new User("id1", null, null);
        // String 속성인 name에 null
        Team team = new Team("team1", null);

        System.out.println("====== before =======");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
        // 리플렉션 활용
        // 저장할 대는 반드시 null을 사용하면 안된다고 가정해보자

        // String이 null이면 ""로 변경한다.
        // Integer가 null 이면 0으로 변경한다
        if(user.getId() == null) {
            user.setId("");
        }
        if(user.getName() == null) {
            user.setName("");
        }
        if(user.getAge() == null) {
            user.setAge(0);
        }

        if(team.getId() == null) {
            team.setId("");
        }
        if(team.getName() == null) {
            team.setName("");
        }

        System.out.println("====== after ======");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        // 이렇게 각각의 객체에 들어있는 데이터를 직접 다 찾아서 값을 입력해야한다.
        // 만약 User, Team 뿐만 아니라 Order, Cart, Delivery 등등 수많은 객체에 이걸 모두 적용할것인가?
    }
}
