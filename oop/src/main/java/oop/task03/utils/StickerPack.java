package oop.task03.utils;

import lombok.Getter;
import oop.task02.OfficeTool;

@SuppressWarnings("unused")
@Getter
public class StickerPack extends OfficeTool {

    private int count;

    private double stickerWidth;

    private double stickerLength;

    private String color;

    public  StickerPack(int stickerCount, double stickerLength, double stickerWidth, String color, int price, String name){
        super(price, name);

        this.count = stickerCount;
        this.stickerLength = stickerLength;
        this.stickerWidth = stickerWidth;
        this.color = color;

    }

    public  StickerPack(int stickerCount, double stickerLength, double stickerWidth, String color, int price){
        this(stickerCount, stickerLength, stickerWidth, color, price, stickerCount + "Sticker Pack");
    }


    public void take() throws Exception{
        if (count > 0)
            count--;
        else throw new Exception("No Stickers in Pack");
    }

}
