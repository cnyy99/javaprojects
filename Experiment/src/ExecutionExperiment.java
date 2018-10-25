import java.io.*;

interface Execute {
    void initData(int totalNumber, int initPos, long initStep); //数据初始化

    void execute(); //模拟执行处死犯人

    int getSurvival(); //返回生存下来的犯人的序号
}

public class ExecutionExperiment {
    public static void experiment(Execute exec) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        System.out.println("请输入：犯人总数  起始犯人号  初始步长");
        try {
            line = br.readLine();//读取一行数据
        } catch (IOException ioe) {
        }
        if (line.equals("finish")) //如果用户的一行输入是“finish”，则程序全部退出。
            System.exit(0);
        String[] numbers = line.split(" ");
        //把输入的一行数据解析出三个参数：犯人总数、初始犯人号、初始步长
        int total = Integer.parseInt(numbers[0]);
        int begin = Integer.parseInt(numbers[1]);
        long step = Long.parseLong(numbers[2]);
        exec.initData(total, begin, step);
        exec.execute();
        int survival = exec.getSurvival();
        System.out.println("逃生的犯人是：" + survival + "号");
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            Execution execution = new Execution();
            experiment(execution); //对象上转型和接口回调
        }
    }
}
