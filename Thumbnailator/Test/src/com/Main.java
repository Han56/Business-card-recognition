package com;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {



    public static void main(String[] args) throws IOException {
        //存储待修改文件的文件夹路径
        String src_path="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\unimg_test";
        //存储缩放后的文件的文件夹路径
        String scale_save="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\scale\\";
        //存储旋转后的文件的文件夹路径
        String rotate_save="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\rotate\\";
        //用于存储待修改文件夹中的所有文件路径
        ArrayList<String> file_path=new ArrayList<>();
        //用于存储待修改文件夹中的所有图片名称，利用字符串截取子字符串的方法
        ArrayList<String> img_name=new ArrayList<>();
        //定义图片裁剪对象
        Scissors scissors=new Scissors();
        //定义图片缩放与旋转对象
        Test test=new Test();
        file_path=queryAll(src_path);
        //通过文件路径提取所有图片名称
        for (int i=0;i<file_path.size();i++){
            //通过文件路径裁剪出图片名称
            String substr=file_path.get(i).substring(71,75);
            img_name.add(substr);
        }

        //将图片全部缩放并存至 scale文件夹中
        for (int j=0;j<img_name.size();j++){
            test.scalekpratio(src_path+"\\"+img_name.get(j)+".jpg",
                    scale_save,img_name.get(j));
        }
        System.out.println("图片已全部缩放完毕，存放至scale文件夹中");

        //将图片全部逆时针旋转90度 并存至rotate文件夹中
        for (int j=0;j<img_name.size();j++){
            test.rotate(scale_save+img_name.get(j)+".jpg",
                    rotate_save,img_name.get(j));
        }
        System.out.println("图片已全部旋转完毕，存放在rotate文件夹中");

        //将图片全部分割成四份，并存至sumfix文件夹中
        for (int j=0;j<img_name.size();j++){
            scissors.scissors();
        }

    }

    public static ArrayList<String> queryAll(String filePath){

        ArrayList<String> arrayList=new ArrayList<String>();
        File file=new File(filePath);
        File[] ts=file.listFiles();
        File[] fs=file.listFiles();

        for (int i=0;i<fs.length;i++){
            if (ts[i].isFile()){
                arrayList.add(ts[i].toString());
            }
        }

        return arrayList;
    }
}
