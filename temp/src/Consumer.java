public class Consumer implements Runnable {
    private DataBox dBox;

    public Consumer(DataBox dBox) {
        this.dBox = dBox;
    }

    @Override
    public void run() {
        while (true){
            int x= dBox.get();
            if(x==-1)
            {
                System.out.println("\t"+Thread.currentThread().getName()+":数据结束");
                return;
            }
            System.out.println("\t"+Thread.currentThread().getName()+":"+x*x);
            try{
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
