package fanshe.ioc.com.iocfindviewbyid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import fanshe.ioc.com.baselibrary.findview.OnClick;
import fanshe.ioc.com.baselibrary.findview.ViewById;
import fanshe.ioc.com.baselibrary.findview.ViewUtils;

public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.btn1)
    Button mButton1;
    @ViewById(R.id.btn2)
    Button mButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        mButton1.setText("dian 1");
        mButton2.setText("dian 2");
        AsyncTask asyncTask=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                return null;
            }
        }.execute();
    }

    @OnClick(R.id.btn2)
    private void OnClick(){
        Toast.makeText(this,"button 2 点击了",Toast.LENGTH_SHORT).show();
    }
}
