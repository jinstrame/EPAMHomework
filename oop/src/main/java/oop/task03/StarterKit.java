package oop.task03;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import oop.task02.OfficeTool;
import oop.task03.erraseTools.WhiteCorrector;
import oop.task03.utils.Stapler;
import oop.task03.utils.StickerPack;
import oop.task03.writeTools.Marker;
import oop.task03.writeTools.Pen;

import java.util.ArrayList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class StarterKit {

    private final Pen bluePen;
    private final Marker transparentYellowMarker;
    private final Stapler smallStapler;
    private final StickerPack smallStickerPack;
    private final WhiteCorrector brushCorrector;


    //part of task04
    public ArrayList<OfficeTool> getCollection(){
        ArrayList<OfficeTool> ret = new ArrayList<>(5);
        ret.add(bluePen);
        ret.add(transparentYellowMarker);
        ret.add(smallStapler);
        ret.add(smallStickerPack);
        ret.add(brushCorrector);

        return ret;
    }

    public static StarterKit getKit(){
        Pen pen = new Pen(Pen.Types.BALL, 0.7, "Blue", 50, "StarterBluePen");
        Marker marker = new Marker(false, true, 7, "Yellow", 200, "StarterYellowMarker");
        Stapler stapler = new Stapler(10, 300, "StarterStapler");
        StickerPack stickerPack = new StickerPack(100, 30, 10, "Pink", 70, "StarterStickers");
        WhiteCorrector whiteCorrector = new WhiteCorrector(WhiteCorrector.Types.BRUSH, 150, "StarterCorrector");

        return new StarterKit(pen, marker, stapler, stickerPack, whiteCorrector);
    }
}
