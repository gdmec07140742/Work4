package com.example.administrator.work4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactsActivity extends AppCompatActivity {
    private EditText nameET,moblieET,qqET,danweiET,addressET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nameET = (EditText) findViewById(R.id.name);
        moblieET = (EditText) findViewById(R.id.moblie);
        qqET = (EditText) findViewById(R.id.qq);
        danweiET = (EditText) findViewById(R.id.danwei);
        addressET = (EditText) findViewById(R.id.address);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contacts, menu);
        menu.add(0, 1, 1, "保存");
        menu.add(0,2,2,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case 1:
                if (!nameET.getText().toString().equals("")){
                    User user = new User();
                    user.setName(nameET.getText().toString());
                    user.setMoblie(moblieET.getText().toString());
                    user.setDanwei(danweiET.getText().toString());
                    user.setQq(qqET.getText().toString());
                    user.setAddress(addressET.getText().toString());
                    ContactsTable ct=new ContactsTable(AddContactsActivity.this);
                    if (ct.addDate(user)){
                        Toast.makeText(AddContactsActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddContactsActivity.this, "添加失败！", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddContactsActivity.this, "请先输入数据！", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
