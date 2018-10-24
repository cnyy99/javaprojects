class A {
    int x = 2;
    public void setx(int i) {x = i;}
    void printa() {
        System.out.println(x);
    }
}
class B extends A {
    int x = 100;
    void printb() {
        super.x = super.x + 10;
        System.out.println("super.x= " + super.x + "  x= " + x);
    }
}
