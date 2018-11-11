import javax.sound.sampled.*;

public class JRecordWavTest {
    public static void main(String []args)
    {
        AudioFormat af;
        TargetDataLine tLine;
        SourceDataLine sLine;
        byte buf[]=new byte[1024*100];
        af = new AudioFormat(8000f,16,1,true,true);
        try{
            DataLine.Info info= new DataLine.Info(TargetDataLine.class,af);
            if(!AudioSystem.isLineSupported(info))
            {
                System.out.println("Line not supported");
                return;
            }

        }
    }
}
