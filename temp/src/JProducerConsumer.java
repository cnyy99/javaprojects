public class JProducerConsumer {
    public static void main(String[] args){
    DataBox db = new DataBox();
    Producer p = new Producer(db);
    Consumer c = new Consumer(db);
    Thread tp = new Thread(p,"Producer");
    Thread tc = new Thread(c,"Consumer");
    tp.start();
    tc.start();
    }
}
