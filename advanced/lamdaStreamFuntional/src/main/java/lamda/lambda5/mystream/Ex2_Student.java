package lamda.lambda5.mystream;

import lamda.lambda5.filter.GenericFilter;
import lamda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        // 80점 이상인 학생의 이름을 추출해라.
        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> direct(List<Student> students) {
        ArrayList<String> result = new ArrayList<>();

        for (Student student : students) {
            boolean passed = student.getScore() >= 80;
            if(passed) {
                result.add(student.getName());
            }
        }

        return result;
    }

    private static List<String> lambda(List<Student> students) {
        List<Student> filter = GenericFilter.filter(students, s -> s.getScore() >= 80);
        return GenericMapper.map(filter, s -> s.getName());
    }
}
