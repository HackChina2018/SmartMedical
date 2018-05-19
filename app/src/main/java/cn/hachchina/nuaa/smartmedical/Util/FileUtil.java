package cn.hachchina.nuaa.smartmedical.Util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.hachchina.nuaa.smartmedical.Bean.FileBean;

/**
 * Created by Administrator on 2018/5/19.
 */

public class FileUtil {


    public static File[] getFiles(String path) {
        File file = new File(path);
        File[] files = null;
        if(!file.exists()) {
            file.mkdir();
        }
        if(!file.exists()) {
//            AppUtil.alert(UI.operation_specification_folder_not_found, getActivity());
            Log.i("error:", "123");
        } else {
            files = file.listFiles();
        }

        return files;
    }




//    private static FileUtil mInstance;
//    private static Context mContext;
//    public static ContentResolver mContentResolver;
//    private static Object mLock = new Object();
//    /**文档类型*/
//    public static final int TYPE_DOC = 0;
//    /**apk类型*/
//    public static final int TYPE_APK = 1;
//    /**压缩包类型*/
//    public static final int TYPE_ZIP = 2;
//
//    public static FileUtil getInstance(Context context){
//        if (mInstance == null){
//            synchronized (mLock){
//                if (mInstance == null){
//                    mInstance = new FileUtil();
//                    mContext = context;
//                    mContentResolver = context.getContentResolver();
//                }
//            }
//        }
//        return mInstance;
//    }
//
//    private static List<FileBean> getFilesByType(int fileType) {
//        List<FileBean> files = new ArrayList<FileBean>();
//        // 扫描files文件库
//        Cursor c = null;
//        try {
//            c = mContentResolver.query(MediaStore.Files.getContentUri("external"), new String[]{"_id", "_data", "_size"}, null, null, null);
//            int dataindex = c.getColumnIndex(MediaStore.Files.FileColumns.DATA);
//            int sizeindex = c.getColumnIndex(MediaStore.Files.FileColumns.SIZE);
//
//            while (c.moveToNext()) {
//                String path = c.getString(dataindex);
//
//                if (FileUtil.getFileType(path) == fileType) {
//                    if (!FileUtil.isExists(path)) {
//                        continue;
//                    }
//                    long size = c.getLong(sizeindex);
////                    FileBean fileBean = new FileBean(path, FileUtil.getFileIconByPath(path));
////                    files.add(fileBean);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (c != null) {
//                c.close();
//            }
//        }
//        return files;
//    }
//
//    /**
//     * 从文件的全名得到文件的拓展名
//     *
//     * @param filename
//     * @return
//     */
//    public static String getExtFromFilename(String filename) {
//        int dotPosition = filename.lastIndexOf('.');
//        if (dotPosition != -1) {
//            return filename.substring(dotPosition + 1, filename.length());
//        }
//        return "";
//    }
//
//    /**
//     * 判断文件是否存在
//     * @param path 文件的路径
//     * @return
//     */
//    public static boolean isExists(String path) {
//        File file = new File(path);
//        return file.exists();
//    }
//
//    public static int getFileType(String path) {
//        path = path.toLowerCase();
//        if (path.endsWith(".doc") || path.endsWith(".docx") || path.endsWith(".xls") || path.endsWith(".xlsx")
//                || path.endsWith(".ppt") || path.endsWith(".pptx")) {
//            return TYPE_DOC;
//        }else if (path.endsWith(".apk")) {
//            return TYPE_APK;
//        }else if (path.endsWith(".zip") || path.endsWith(".rar") || path.endsWith(".tar") || path.endsWith(".gz")) {
//            return TYPE_ZIP;
//        }else{
//            return -1;
//        }
//    }
}
