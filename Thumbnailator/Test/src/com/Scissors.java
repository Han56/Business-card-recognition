package com;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import java.io.IOException;

public class Scissors {

    //读取照片地址，测试暂时写成常量
    public String img_url="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\fiximg\\pss.jpg";
    public String save_url="D:\\Program WorkSpace\\js_workspace\\Business-card-recognition\\sumfix\\";

    public void scissors() throws IOException {

        //裁剪200*200的图片的右下角
        Thumbnails.of(img_url)
                .sourceRegion(Positions.BOTTOM_RIGHT, 100, 100)
                .size(200, 200).keepAspectRatio(false)
                .toFile(save_url+"pss_br.jpg");
        System.out.printf("右下角已裁剪完毕");

        //裁剪左下角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.BOTTOM_LEFT,100,100)
                .size(200,200).keepAspectRatio(false)
                .toFile(save_url+"pss_bl.jpg");
        System.out.printf("左下角已裁剪完毕");

        //裁剪左上角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.TOP_LEFT,100,100)
                .size(200,200).keepAspectRatio(false)
                .toFile(save_url+"pss_tl.jpg");
        System.out.printf("左上角已裁剪完毕");

        //裁剪右上角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.TOP_RIGHT,100,100)
                .size(200,200).keepAspectRatio(false)
                .toFile(save_url+"pss_tr.jpg");
        System.out.printf("右上角已裁剪完毕");
    }


}
