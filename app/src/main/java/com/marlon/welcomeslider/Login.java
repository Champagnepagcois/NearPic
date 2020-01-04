package com.marlon.welcomeslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marlon.welcomeslider.Singup.Register;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Random;

public class Login extends AppCompatActivity {

    TextView textViewsingup;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btn_SingIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotificationWithImage();
                Intent log = new Intent(Login.this, Into.class);
                startActivity(log);
                finish();
            }
        });
        textViewsingup = (TextView) findViewById(R.id.tv_register);
        textViewsingup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent goRegister = new Intent(Login.this, Register.class);
                startActivity(goRegister);
            }
        });
    }
    private  void showNotificationWithImage(){
        new AsyncTask<String,Void, Bitmap>(){
            @Override
            protected Bitmap doInBackground(String... strings) {
                InputStream inputStream;
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    inputStream = connection.getInputStream();
                    return BitmapFactory.decodeStream(inputStream);
                }catch (Exception ignored){
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                ShowNotification(bitmap);

            }
        }.execute("https://a.wattpad.com/cover/85992670-352-k248170.jpg");
    }

    private void ShowNotification(Bitmap bitmap){
        int notificationId  =new Random().nextInt(100);
        String channelId = "notification_channeel_1";

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent  intentNoti = new Intent(getApplicationContext(),Into.class);
        intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intentNoti,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                getApplicationContext(),channelId
        );
        builder.setSmallIcon(R.drawable.logofinal);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setContentTitle("Iniciaste sesion en NearPic");
        builder.setContentText("Se acaba de iniciar sesion dentro de la aplicacion" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //builder.setStyle(new NotificationCompat.BigTextStyle().bigText("JJAJA SALU2 XD "));
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            if (notificationManager != null && notificationManager.getNotificationChannel(channelId)== null){

                NotificationChannel notificationChannel = new NotificationChannel(
                    channelId,
                    "Notification channel 1",
                    NotificationManager.IMPORTANCE_HIGH
                );
                notificationChannel.setDescription("This notification channel is  used  to notify user.");
                notificationChannel.enableVibration(true);
                notificationChannel.enableLights(true);
                notificationManager.createNotificationChannel(notificationChannel);

            }

        }

        Notification notification = builder.build();
        if (notificationManager != null){
            notificationManager.notify(notificationId, notification);

        }
    }
}
