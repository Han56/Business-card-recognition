package com;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import java.io.IOException;

public class Scissors {


    public void scissors(String img_url,String save_url,String img_name) throws IOException {

        //裁剪200*200的图片的右下角
        Thumbnails.of(img_url)
                .sourceRegion(Positions.BOTTOM_RIGHT, 500, 500)
                .size(1000, 1000).keepAspectRatio(false)
                .toFile(save_url+img_name+"_br.jpg");
        System.out.printf("右下角已裁剪完毕");

        //裁剪左下角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.BOTTOM_LEFT,500,500)
                .size(1000,1000).keepAspectRatio(false)
                .toFile(save_url+img_name+"_bl.jpg");
        System.out.printf("左下角已裁剪完毕");

        //裁剪左上角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.TOP_LEFT,500,500)
                .size(1000,1000).keepAspectRatio(false)
                .toFile(save_url+img_name+"_tl.jpg");
        System.out.printf("左上角已裁剪完毕");

        //裁剪右上角图片
        Thumbnails.of(img_url)
                .sourceRegion(Positions.TOP_RIGHT,500,500)
                .size(1000,1000).keepAspectRatio(false)
                .toFile(save_url+img_name+"_tr.jpg");
        System.out.printf("右上角已裁剪完毕");
    }


}
