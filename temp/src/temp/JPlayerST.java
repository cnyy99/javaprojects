package temp;

public class JPlayerST {                    // 主类：单线程串行程序
    public static  void main(String[] args) {  // 主方法
        // 下载算法：模拟网络下载，显示5次信息"Downloading ..."
        int count = 1;       // 显示计数
        while (count <= 5) {  // 循环显示5次信息
            System.out.println("Downloading ..." +count);
            count++;
            // 每显示一次信息后让算法休眠（暂停）0.1秒，模拟下载过程
            try {  // 捕获并处理可能抛出的勾选异常
                Thread.sleep(100);  // 可能抛出勾选异常InterruptedException
            }
            catch (InterruptedException e) {  // 捕捉并处理异常
                System.out.println( e.getMessage() );
                return;  // 退出主方法，程序结束
            }
        }
        play();  // 下载完成后，调用子方法play()，模拟播放音乐
    }

    static  void play() {  // 子方法
        // 播放算法：模拟播放音乐，显示5次信息"Playing ..."
        int count = 1;       // 显示计数
        while (count <= 5) {  // 循环显示5次信息
            System.out.println("\t Playing ..." +count);
            count++;
            // 每显示一次信息后让算法休眠（暂停）0.1秒。模拟播放过程
            try {  // 捕获并处理可能抛出的勾选异常
                Thread.sleep(100);  // 可能抛出勾选异常InterruptedException
            }
            catch (InterruptedException e) {  // 捕捉并处理异常
                System.out.println( e.getMessage() );
                return;  // 退出子方法，返回主方法
            }
        }
    }  }
