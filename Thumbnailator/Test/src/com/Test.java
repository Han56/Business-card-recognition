package com;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import java.io.IOException;

public class Test {

//    public String img_url="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\fiximg\\psc.jpg";
//    public String save_url="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\fixed\\";

    //对图片进行固定大小的缩放
//    public void  scale() throws IOException {
//        Thumbnails.of(img_url).size(100,100)
//                .toFile(save_url+"psc_scale.jpg");
//        System.out.printf("图片已缩放完毕");
//    }

    //对图片进行固定大小的缩放 并且保持比例不变
    public void scalekpratio(String img_url,String save_url,String img_name) throws IOException {
        Thumbnails.of(img_url).size(1000, 1000).keepAspectRatio(false)
                .toFile(save_url+img_name+".jpg");
        System.out.println("图片已按照固定比例缩放完毕");
    }

    //旋转——将psc逆时针旋转90度
    public void rotate(String img_url,String save_url,String img_name) throws IOException {
        Thumbnails.of(img_url)
                .size(1000,1000).rotate(-90)
                .toFile(save_url+img_name+".jpg");
        System.out.printf("图片已进行逆时针旋转");
    }

    //转换图片格式
    public void changeKind() throws IOException {
        Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("png").toFile("C:/image_1280x1024.png");
    }

    //裁剪
    public void scissors() throws IOException {
        //1.裁剪图片中心400*400的area
        Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("C:/image_region_center.jpg");

        //裁剪右下400*400的area
        Thumbnails.of("images/test.jpg").sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("C:/image_region_bootom_right.jpg");

        //指定坐标
        Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400, 400).size(200, 200).keepAspectRatio(false).toFile("C:/image_region_coord.jpg");
    }

}
