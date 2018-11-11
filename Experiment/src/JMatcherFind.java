import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JMatcherFind {
    public static void main(String []args){
        String str="zhangsan,a,1391234567,zahngsan@cau.edu.cn\n"+
                "lisi,b,1397654321,li@163.com\n"+
                "wangwu,c,1890000001,wuwang@sina.com\n";
        String mf= "\\w+([-_]\\w+)*@\\w+([-_])*.\\w+";
        Pattern p =Pattern.compile(mf);
        Matcher m = p.matcher(str);
        System.out.println("email有");
        while(m.find()==true)
        {
            int p1=m.start();
            int p2=m.end();
            System.out.println(p1+"-"+p2+":"+str.substring(p1,p2));
        }
    }
}
