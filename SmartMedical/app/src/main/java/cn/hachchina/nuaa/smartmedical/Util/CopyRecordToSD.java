package cn.hachchina.nuaa.smartmedical.Util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyRecordToSD {
    private Context context;
    private String recordFile;
    private boolean sdCardExit;


    public CopyRecordToSD(Context context,boolean sdCardExit) {
        this.context = context;
        this.sdCardExit=sdCardExit;
    }

    private void copyDataToSD(String strOutFileName) throws IOException {

        File sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        File file = new File(sdDir.toString() + "/SmartMedical/");
        if (!file.exists()) {
            file.mkdir();
        }

        String tmpFile = sdDir.toString() + "/SmartMedical/" + strOutFileName;
        File f = new File(tmpFile);
        if (f.exists()) {
            return;
        }
        InputStream myInput;
        java.io.OutputStream myOutput = new FileOutputStream(sdDir.toString() + "/gesturencnn/" + strOutFileName);
        myInput = context.getAssets().open(strOutFileName);
        byte[] buffer = new byte[1024];
        int length = myInput.read(buffer);
        while (length > 0) {
            myOutput.write(buffer, 0, length);
            length = myInput.read(buffer);
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();

    }


}
