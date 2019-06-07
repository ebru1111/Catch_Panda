package com.example.renk.p_yakala;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import android.media.MediaPlayer;
public class MainActivity extends AppCompatActivity {


    TextView textSCORE;
    TextView textTIME;
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;
    ImageView imageview4;
    ImageView imageview5;
    ImageView imageview6;
    ImageView imageview7;
    ImageView imageview8;
    ImageView imageview9;
    int score;
    ImageView [] image_array;//array i diziyi olusturdum bu sekilde image ları arraye atıp icinde rastgele gezebilicem.
    private int millisUntilFinished;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview1= findViewById(R.id.imageView);
        imageview2= findViewById(R.id.imageView2);
        imageview3= findViewById(R.id.imageView3);
        imageview4= findViewById(R.id.imageView4);
        imageview5= findViewById(R.id.imageView5);
        imageview6= findViewById(R.id.imageView6);
        imageview7= findViewById(R.id.imageView7);
        imageview8= findViewById(R.id.imageView8);
        imageview9= findViewById(R.id.imageView9);
        image_array=new ImageView[]{imageview1,imageview2,imageview3,imageview4,imageview5,imageview6,imageview7,imageview8,imageview9};
        score = 0;
        rastgeleSakla();
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                textTIME= findViewById(R.id.textTIME);
                     textTIME.setText("TIME:"+millisUntilFinished/1000);//HERGERİKALAN SANİYEYİ MİLİSANİYEYE BÖLÜP GÖSTERİR
            }

            @Override
            public void onFinish() {
                textTIME= findViewById(R.id.textTIME);
                textTIME.setText("GAME OVER");
                handler.removeCallbacks(runnable);//kodu durdurur rastgele fonksiyonu durur
                for (ImageView image : image_array) { //bittikten sonra skor artısını engellemek icin
                    //icindeki her imajla ilgili islem yapabiliriz.HRPSİNİ GÖRUNMEZ YAPTIK
                    image.setVisibility(View.INVISIBLE);//ACINCA HİCBİR KENNY GÖRÜNMEZ OLUR AMA BİZ BİR TANESİ GÖRÜNSÜN İSTİYORUZ
                }
            }
        }.start();

    }


    public void increaseScore(View view)
    {
        textSCORE= findViewById(R.id.textSCORE);
        score++;
        textSCORE.setText("score:"+score);
    }

    public void rastgeleSakla()//pandanın kacma islemi yapılıyor
    {
        handler =new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                for (ImageView image : image_array) {
                    //icindeki her imajla ilgili islem yapabiliriz.HRPSİNİ GÖRUNMEZ YAPTIK
                    image.setVisibility(View.INVISIBLE);//ACINCA HİCBİR KENNY GÖRÜNMEZ OLUR AMA BİZ BİR TANESİ GÖRÜNSÜN İSTİYORUZ
                }
                Random r = new Random();
                int i = r.nextInt(8 - 0);// 8 ile 0 arasındaki imagelerın arasından secer
                image_array[i].setVisibility(View.VISIBLE);//.ARRAYI BULUP GÖRÜNÜR HALE GETİRİR YADA RANDOMLA DA SECEBİLİRİX
                handler.postDelayed (this,500);
            }

        };

        handler.post(runnable);
        }
}
