package com.example.ver10;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    int counter = 0;

    MQTTHelper mqttHelper;
    public void startMQTT(){
        mqttHelper = new MQTTHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                Log.w("Debug",mqttMessage.toString());
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }

    public void sendDataToMQTT(final String ID, final String value1, final String value2){
        final Timer aTimer = new Timer();
        TimerTask aTask = new TimerTask() {
            @Override
            public void run() {
                MqttMessage msg = new MqttMessage();
                msg.setId(1234);
                msg.setQos(0);
                msg.setRetained(true);

                //String data = ID + ":[" + value1 + "," + value2 + "]";
                String data = "[{\"device_id\":\"Speaker\", \"values\":[\"" + value1 + "\",\"" + value2 + "\"]}]";
                byte[] b = data.getBytes(Charset.forName("UTF-8"));
                msg.setPayload(b);

                try {
                    mqttHelper.mqttAndroidClient.publish("Topic/Speaker", msg);
                    Log.e("publish","published");

                }catch (MqttException e){
                }
            }
        };
        aTimer.schedule(aTask, 10000, 10000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_area, R.id.nav_setting, R.id.nav_notify)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        startMQTT();
        sendDataToMQTT("Speaker","0","0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
