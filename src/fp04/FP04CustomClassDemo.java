package fp04;

import fp04.data.Course;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClassDemo {
    public static void main(String[] args) {

        Course course1 = new Course(1, "Spring", "Framework", 98, 10000);
        Course course2 = new Course(2, "Spring Boot", "Framework", 95, 22000);
        Course course3 = new Course(3, "API", "Microservices", 97, 250000);
        Course course4 = new Course(4, "Microservices", "Microservices", 96, 14000);
        Course course5 = new Course(5, "AWS", "Cloud", 99, 30000);
        Course course6 = new Course(6, "GCP", "Cloud", 98, 45000);
        Course course7 = new Course(7, "Docker", "DevOps", 98, 20000);
        Course course8 = new Course(8, "Kubernetes", "DevOps", 98, 20000);
        Course course9 = new Course(9, "Full Stack", "Full Stack", 98, 100);

        List<Course> courses = List.of(course1, course2, course3,
                course4, course5, course6, course7, course8, course9);

        courses.stream().forEach(System.out::println);

        // noneMatch
        Predicate<Course> courseReviewScoreGE95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> courseReviewScoreGE90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> courseReviewScoreLT90Predicate = course -> course.getReviewScore() < 90;

        System.out.println("courseReviewScoreGE95Predicate :: allMatch => " +
                courses.stream().allMatch(courseReviewScoreGE90Predicate));

        System.out.println("courseReviewScoreGE95Predicate :: noneMatch => " +
                courses.stream().noneMatch(courseReviewScoreGE95Predicate));

        System.out.println("courseReviewScoreGE95Predicate :: anyMatch => " +
                courses.stream().anyMatch(courseReviewScoreGE95Predicate));

        System.out.println("courseReviewScoreGE90Predicate :: allMatch => " +
                courses.stream().allMatch(courseReviewScoreGE90Predicate));

        System.out.println("courseReviewScoreGE90Predicate :: noneMatch => " +
                courses.stream().noneMatch(courseReviewScoreGE90Predicate));

        System.out.println("courseReviewScoreGE90Predicate :: anyMatch => " +
                courses.stream().anyMatch(courseReviewScoreGE90Predicate));

        System.out.println("courseReviewScoreLT90Predicate :: noneMatch => " +
                courses.stream().noneMatch(courseReviewScoreLT90Predicate));

        System.out.println("courseReviewScoreLT90Predicate :: anyMatch => " +
                courses.stream().anyMatch(courseReviewScoreLT90Predicate));

        System.out.println("courseReviewScoreLT90Predicate :: allMatch => " +
                courses.stream().allMatch(courseReviewScoreLT90Predicate));

        //

        List<Course> sortedCoursesByNoOfStudents = courses.stream()
                .sorted(Comparator.comparingInt(Course::getNoOfStudents))
                .collect(Collectors.toList());
        System.out.println(sortedCoursesByNoOfStudents);

        List<Course> revSortedCoursesByNoOfStudents = courses.stream()
                .sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed())
                .collect(Collectors.toList());
        System.out.println(revSortedCoursesByNoOfStudents);

        List<Course> sortedByNoOfStudentsThenReviewScore = courses.stream()
                .sorted(Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore))
                .collect(Collectors.toList());
        System.out.println(sortedByNoOfStudentsThenReviewScore);

        
    }
}
