class DataBox {                    // 存放共享数据的数据箱类
    private boolean hasData = false;  // 数据标记：标记数据箱里的数据是否有效
    private int data = 0;            // 数据
    public synchronized  void put(int x) {         // 生产者调用该方法，存入数据x
        while (hasData == true) {  // 如已有数据则阻塞等待，直到消费者将它取走
            try {         // 方法wait()可能会抛出勾选异常InterruptedException
                wait();   // 当前的生产者线程被阻塞，等待被消费者线程唤醒
            }  catch(InterruptedException e) { }
        }
        data = x;  hasData = true;  // 存入数据x，设置数据标记为true（有效）
        notifyAll();        // 唤醒被阻塞的消费者线程，通知它们可以取数据了
    }

    public synchronized  int get() {  // 消费者调用该方法，取出数据
        while (hasData != true) {   // 如没有数据，则阻塞等待，直到生产者存入数据
            try {            // 方法wait()可能会抛出勾选异常InterruptedException
                wait();      // 当前的消费者线程被阻塞，等待被生产者线程唤醒
            }  catch(InterruptedException e) { }
        }
        int x = data;  hasData = false;  // 取出数据，设置数据标记为false（无效）
        notifyAll();        // 唤醒被阻塞的生产者线程，通知它们可以生产数据了
        return x;
    }
}
