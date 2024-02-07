public class Child extends Parent{
    private String course;
    public  String test;
    public Child(String name, String age,String course) {
        super(name, age);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
