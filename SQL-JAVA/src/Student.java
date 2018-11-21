public class Student {
    private String no;      //学号
    private String name;    //姓名
    private String sex;     //性别
    private String birth;   //生日
    private String classno; //班级号
    private int age;        //年龄

    //构造函数
    public Student(String no, String name, String sex, String birth, String classno, int age) {
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

    public void setAge(int age) {
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

    public int getAge() {
        return age;
    }
}
