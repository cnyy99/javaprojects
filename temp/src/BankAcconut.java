class BankAcconut {
    String name;
    int number;
    double num;

    BankAcconut(String name, int number, double num) {
        this.name = name;
        this.num = num;
        this.number = number;
    }
    public boolean equals(Object x)
    {
        if(this.getClass()!=x.getClass())
            return false;
        BankAcconut b =(BankAcconut) x;
        return ((this.name).equals(b.name)&&this.num==b.num&&this.number==b.number);
    }
}
