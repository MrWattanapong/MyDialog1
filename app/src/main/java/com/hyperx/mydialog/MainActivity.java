package com.hyperx.mydialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String[] CLUBS = {"Arsenal", "Chelsea", "Liverpool", "Man. City", "Man. Utd"};
    String msgSelected;
    ArrayList<Integer> msgMultiSelected;

    Button buttonSimple;
    Button buttonList;
    Button buttonSingle;
    Button buttonMulti;
    Button buttonCustom;
    Button buttonCustom2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSimple = (Button)findViewById(R.id.btnSimple);
        buttonList = (Button)findViewById(R.id.btnList);
        buttonSingle = (Button)findViewById(R.id.btnSingle);
        buttonMulti = (Button)findViewById(R.id.btnMulti);
        buttonCustom = (Button)findViewById(R.id.btnCustom);
        buttonCustom2 = (Button)findViewById(R.id.btnCustom2);

        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to build a snowman?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Ohhh...You love snowman", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No",null);
                builder.create();
                builder.show();
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select your favorite");
                builder.setItems(CLUBS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected = CLUBS[i];
                        Toast.makeText(getApplicationContext(), "you likes " + selected, Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Don't like any teams",null);
                builder.create();
                builder.show();
            }
        });

        buttonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select your favorite");
                builder.setSingleChoiceItems(CLUBS, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected = CLUBS[i];
                        Toast.makeText(getApplicationContext(), "you likes " + selected, Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Don't like any teams",null);
                builder.create();
                builder.show();
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgMultiSelected = new ArrayList<Integer>();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select your favorite");
                builder.setMultiChoiceItems(CLUBS, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if (isChecked){
                            msgMultiSelected.add(i);
                        }
                        else if (msgMultiSelected.contains(i)){
                            msgMultiSelected.remove(Integer.valueOf(i));
                        }
                    }
                });
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuffer buffer = new StringBuffer();
                        for (Integer team:msgMultiSelected){
                            buffer.append("  ");
                            buffer.append(CLUBS[team]);
                        }
                        Toast.makeText(getApplicationContext(), "you likes " + buffer.toString(), Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Don't like any teams",null);
                builder.create();
                builder.show();
            }
        });

        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Login Dialog");
                dialog.setContentView(R.layout.dialog_custom);

                final EditText username = (EditText)dialog.findViewById(R.id.username2);
                final EditText password = (EditText)dialog.findViewById(R.id.password2);
                final Button buttonLogin = (Button)dialog.findViewById(R.id.login);
                final Button buttonCancel = (Button)dialog.findViewById(R.id.cancel);

                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (username.getText().toString().equals("admin")&& password.getText().toString().equals("1234")){
                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login Fail!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog.show();
            }
        });

        buttonCustom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_custom2);

                final ImageView logo = (ImageView)dialog.findViewById(R.id.logo);
                final EditText username = (EditText)dialog.findViewById(R.id.username2);
                final EditText password = (EditText)dialog.findViewById(R.id.password2);
                final Button loginbtn = (Button)dialog.findViewById(R.id.loginbtn);
                final Button closebtn = (Button)dialog.findViewById(R.id.closebtn);

                closebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                loginbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (username.getText().toString().equals("admin")&& password.getText().toString().equals("1234")){
                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login Fail!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog.show();
            }
        });
    }
}
