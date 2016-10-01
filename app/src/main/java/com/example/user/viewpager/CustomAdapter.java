package com.example.user.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CustomAdapter extends PagerAdapter {

    private int [] imageResources ={ //массив из картинок, хранящихся в ресурсах
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };

    private Context ctx; // контекст
    private LayoutInflater layoutInflater; //экземпляр клааса

    public CustomAdapter(Context c)
    {
        ctx=c;
    } //констурктор

    @Override
    public int getCount() {

        return imageResources.length; //получаем размер массива с картинками
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=layoutInflater.inflate(R.layout.swap_layout,container,false);//из содержимого layout-файла создать View-элемент
        ImageView imageView=(ImageView) itemView.findViewById(R.id.image_view); // находим нужный элемент в лейаут-файле
        imageView.setImageResource(imageResources[position]); //устанавливаем картинку из массива на вью
        container.addView(itemView); //поместить вью в контейнер
        return itemView; //вернуть вью
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) { //класс деструктор
        container.removeView((LinearLayout)object); //удаляет из контейнера содержимое
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return  (view==(LinearLayout)object);
    }
}

