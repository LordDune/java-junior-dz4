package pac.main;

public class Main {
    public static void main(String[] args) {

        CoursesRepositoryImpl coursesRepository = new CoursesRepositoryImpl();
        for (int i = 0; i < 3; i++) {
            Courses courses = Courses.create();
            coursesRepository.add(courses);
        }
        System.out.println(coursesRepository.getById(0));
        System.out.println(coursesRepository.getById(1));
        System.out.println(coursesRepository.getById(2));
        Courses coursesForUpdate = coursesRepository.getById(2);
        coursesForUpdate.updateDuration();
        coursesForUpdate.updateName();
        coursesRepository.update(coursesForUpdate);
        System.out.println(coursesRepository.getById(2));
        coursesRepository.delete(coursesForUpdate);
        for (Courses courses : coursesRepository.getAll()) {
            System.out.println(courses);
        }


    }

}