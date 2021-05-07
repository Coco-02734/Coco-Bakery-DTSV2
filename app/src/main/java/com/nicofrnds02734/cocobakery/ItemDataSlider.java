package com.nicofrnds02734.cocobakery;

import java.util.ArrayList;

public class ItemDataSlider {
    private static int[] itemSlider = {
      R.drawable.gmr_1,
      R.drawable.gmr_2,
      R.drawable.gmr_1,
      R.drawable.gmr_2,
      R.drawable.gmr_1,
      R.drawable.gmr_2

    };

    static ArrayList<Slider> getListItem(){
        ArrayList<Slider> list = new ArrayList<>();
        for (int posisi = 0; posisi < itemSlider.length; posisi++){
            Slider slider = new Slider();
            slider.setSlider(itemSlider[posisi]);
            list.add(slider);
        }
        return list;
    }
}
