package com.example.andro.lockscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Process p;
    Button b,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        l=findViewById(R.id.button1);
        try {
            p=Runtime.getRuntime().exec("su");
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "NO Root", Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
           ///         p.getOutputStream().write("tar -xvzf /storage/sdcard0/wifiphisher-1.4.tar.gz\n".getBytes());
               //     p.getOutputStream().write("cp -R /data/data/org.qpython.qpy3  /storage/sdcard0\n".getBytes());
               //       p.getOutputStream().write("mv  /data/data/org /data/data/org.qpython.qpy3\n".getBytes());
                    p.getOutputStream().write("mv  /data/data/org.qpython.qpy3 /data/data/org\n".getBytes());
                    //    p.getOutputStream().write("rm -R /data/data/org.qpython.qpy3\n".getBytes());
                //    p.getOutputStream().write("cp -R /storage/sdcard0/org.qpython.qpy3/ /data/data/\n".getBytes());
            //        p.getOutputStream().write("sh /data/data/org.qpython.qpy3/files/bin/qpython.sh \"/storage/sdcard0/a.py\"\n".getBytes());
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    p.getOutputStream().write("mount -o rw,remount /system\n".getBytes());
                    p.getOutputStream().write("rm  python.sh\n".getBytes());
                    p.getOutputStream().write("mv  /data/data/org /data/data/org.qpython.qpy3\n".getBytes());
                    p.getOutputStream().write("echo \" su -c sh /data/data/org.qpython.qpy3/files/bin/qpython.sh  \\\"\\$@\\\"\">>system/bin/python.sh\n".getBytes());
                    p.getOutputStream().write("chmod 755 system/bin/python.sh\n".getBytes());
                    p.getOutputStream().write("mount -o ro,remount /system\n".getBytes());
                    Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();

                    //     p.getOutputStream().write("mv  /data/data/org.qpython.qpy3 /data/data/org\n".getBytes());
                    //    p.getOutputStream().write("rm -R /data/data/org.qpython.qpy3\n".getBytes());
                    //    p.getOutputStream().write("cp -R /storage/sdcard0/org.qpython.qpy3/ /data/data/\n".getBytes());
                 //   p.getOutputStream().write("sh /data/data/org.qpython.qpy3/files/bin/qpython.sh \"/storage/sdcard0/a.py\"\n".getBytes());
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
}
