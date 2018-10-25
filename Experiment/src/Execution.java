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
//            currStep += data[currPos];
//            for (int i = 0; i < currNumber ; i++) {
//                System.out.print(data[i]+"  ");
//            }
//            System.out.println("\n杀死的人为: "+ data[currPos] + "   位置为: "+currPos+"   此时数组长度为: "+ currNumber+ "  步长为: "+currStep);
//            for (int i = currPos; i < currNumber - 1; i++) {
//                data[i] = data[i + 1];
//            }
//            currNumber--;
//            if(currPos+currStep<currNumber)
//            {
//                currPos=(int)(currPos+currStep-1);
//                continue;
//            }
//            long temp = currStep +currPos-1;
//            if (currPos == currNumber) {
//                currPos = 0;
//            }
//            currPos = (int) (temp + 1) % currNumber;
//            if (currPos == 0) {
//                currPos = currNumber-1;
//                continue;
//            }
//            if(currPos>=1)
//            {
//                currPos--;
//            }
        }
        //请添加自己的代码
    }
    //请添加所需成员变量和成员方法：

}
