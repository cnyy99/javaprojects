public class TicketWindow implements Runnable{
    private final TicketBox tBox;

    TicketWindow(TicketBox tBox) {
        this.tBox = tBox;
    }

    @Override
    public void run() {
        prepare();
        sale();
    }

    private void prepare() {
        System.out.println(Thread.currentThread().getName()+"购票前准备...");
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private  void sale(){
        synchronized (tBox){
        int tickets=tBox.get();
        if(tickets>0){
            tickets--;
            tBox.set(tickets);
            System.out.println(Thread.currentThread().getName()+"成功,剩余票数 "+tickets);
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+"无票");
        }
    }
    }
}
