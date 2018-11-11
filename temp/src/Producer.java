public class Producer implements Runnable{
    private DataBox dBox;
    private int []x={1,3,5,7,9,-1};
    public Producer(DataBox d)
    {
        dBox=d;
    }
    public void run()
    {
        for(int n=0;n<x.length;n++)
        {
            System.out.println(Thread.currentThread().getName()+":"+x[n]);
            dBox.put(x[n]);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
