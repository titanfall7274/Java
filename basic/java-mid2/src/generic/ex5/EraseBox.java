package generic.ex5;

public class EraseBox<T> {

    // 자바는 T가 컴파일 이후 Object로 바뀌게 되고 모두 true를 뱉게될것이다. 컴파일러는 이런 오류를 미리 잡아준다.
    public boolean instanceCheck(Object param) {
//        return param instanceof T; // 오류 'Object' cannot be safely cast to 'T'
        return false;
    }

    // Eraser에 의해 return new Object()가 되며 개발자가 의도한것과는 다른 결과를 뱉게된다.
    // 하나의 직관적인 예시는 상한제한을 <T extends Animal>로 걸었을 경우 Dog라는 Type이 날아가고 Animal이 들어가
    // Dog가 리턴되는게 아니라 return new Animal()이 되어버린다
    public void create() {
//        return new T(); // Type parameter 'T' cannot be instantiated directly
    }
}
