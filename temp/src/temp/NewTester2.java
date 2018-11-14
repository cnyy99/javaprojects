package temp;

class NewTester2 {
        public static void main(String[] args) {
            A a1 = new A();
            a1.setx(4);
            a1.printa();
            B b1 = new B();  //b1,x=2
            b1.printb();
            b1.printa(); //改变了x为12了
            b1.setx(6);  // 将继承来的x值设置为6
            b1.printb();
            b1.printa();
            a1.printa();
        }

}
