import java.util.Scanner;
abstract class CourseDetails{
    String courseCode;
    String courseName;
    int credits;
    CourseDetails(String courseCode, String courseName, int credits){
        this.courseCode= courseCode;
        this.courseName= courseName;
        this.credits= credits;
    }
    abstract double calculateFee();
    abstract void displayCourseDetails();
}
class RegularCourse extends CourseDetails{
    RegularCourse(String code,String name,int credits) {
        super(code,name,credits);
    }
    double calculateFee(){
        return credits*5000;
    }
    void displayCourseDetails(){
        System.out.println(courseName + " (" + courseCode+ ") - RegularCourse - Fee: " + calculateFee());
    }
}
class OnlineCourse extends CourseDetails{
    OnlineCourse(String code,String name,int credits){
        super(code,name,credits);
    }
    double calculateFee(){
        return credits*3000;
    }
    void displayCourseDetails(){
        System.out.println(courseName + " (" + courseCode+ ") - OnlineCourse - Fee: " + calculateFee());
    }
}
class CertificationCourse extends CourseDetails{
    CertificationCourse(String code,String name,int credits){
        super(code,name,credits);
    }
    double calculateFee(){
        return credits*2000+1000;
    }
    void displayCourseDetails(){
        System.out.println(courseName + " (" + courseCode+ ") - CertificationCourse - Fee: " + calculateFee());
    }
}
public class Course{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CourseDetails[] courses =new CourseDetails[n];
        for(int i = 0; i < n; i++){
            String type=sc.next();
            String code=sc.next();
            String name=sc.next();
            int credits=sc.nextInt();
            if(type.equals("REGULAR")){
                courses[i]= new RegularCourse(code,name,credits);
            }
            else if(type.equals("ONLINE")){
                courses[i]= new OnlineCourse(code,name,credits);
            }
            else{
                courses[i]= new CertificationCourse(code,name,credits);
            }
        }
        for(int i = 0; i < n; i++){
            courses[i].displayCourseDetails();
        }
        sc.close();
    }
}
