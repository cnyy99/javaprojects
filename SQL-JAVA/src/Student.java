public class Student {
    private String no;
    private String name;
    private String sex;
    private String birth;
    private String classno;
    private String age;

    public Student(String no, String name, String sex, String birth, String classno, String age) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.classno = classno;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setClassno(String classno) {
        this.classno = classno;

    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public String getSex() {

        return sex;
    }

    public String getBirth() {
        return birth;
    }

    public String getClassno() {
        return classno;
    }

    public String getAge() {
        return age;
    }
}
