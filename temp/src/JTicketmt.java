public class JTicketMT {
    public static void main(String args [])
    {
        TicketBox tb = new TicketBox(4);
        TicketWindow tw = new TicketWindow(tb);
        Thread t1 = new Thread(tw,"窗口1");
        Thread t2 = new Thread(tw,"窗口2");
        Thread t3 = new Thread(tw,"窗口3");
        Thread t4 = new Thread(tw,"窗口4");
        Thread t5 = new Thread(tw,"窗口5");
        long sTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        while(t1.getState()!=Thread.State.TERMINATED||
                t2.getState()!=Thread.State.TERMINATED||
                t3.getState()!=Thread.State.TERMINATED||
                t4.getState()!=Thread.State.TERMINATED||
                t5.getState()!=Thread.State.TERMINATED)
        {

        }
        long eTime  = System.currentTimeMillis();
        System.out.println("用时:"+ (eTime-sTime)/1000.0+"秒");
    }
}
