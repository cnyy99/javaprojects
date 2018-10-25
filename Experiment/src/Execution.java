class Execution implements Execute {
    int[] data; //存放现有犯人的序号
    int currNumber; //存放现有犯人的总数
    int currPos; //存放下一次要被处死的犯人在数组中的位置
    long currStep; //存放下一次寻找犯人的步长

    public void initData(int totalNumber, int initPos, long initStep) {
        currNumber = totalNumber;
        currPos = initPos;
        currStep = initStep;
        data = new int[totalNumber];
        for (int i = 0; i < totalNumber; i++)
            data[i] = i;
    }

    public int getSurvival() {
        return data[0];
    }

    public void execute() {
        while (currNumber != 1) {
            currStep+=data[currPos];
            for (int i = currPos; i < currNumber - 1; i++) {
                data[i] = data[i + 1];
            }
            currNumber--;
            currPos= (int) ((currPos+currStep-1)%currNumber);
        }
        //请添加自己的代码
    }
    //请添加所需成员变量和成员方法：

}
