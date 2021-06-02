package sg.edu.rp.c346.id20008787.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String selection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDBS = findViewById(R.id.btnDBS);
        registerForContextMenu(btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        registerForContextMenu(btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == btnDBS) {
            selection = "DBS";
        } else if (v == btnOCBC) {
            selection = "OCBC";
        } else if (v == btnUOB) {
            selection = "UOB";
        }

        menu.add(0, 0, 0, "Website 银行网站");
        menu.add(0, 1, 1, "Call the bank 银行热线");
        menu.add(0, 2, 2, "Langauge 语言");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "Website is selected",
                    Toast.LENGTH_SHORT).show();
            if (selection.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }
            else if(selection.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }
            else if(selection.equalsIgnoreCase("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
        }


        else if(item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Call Bank is selected",
                        Toast.LENGTH_LONG).show();
                if (selection.equalsIgnoreCase("DBS")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel:" + "18001111111"));
                    startActivity(intent);
                } else if (selection.equalsIgnoreCase("OCBC")) {
                    Intent intent = new  Intent(Intent.ACTION_DIAL, Uri.parse("Tel:" + "18003633333"));
                    startActivity(intent);
                } else if (selection.equalsIgnoreCase("UOB")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel:" + "18002222121"));
                    startActivity(intent);
                }
            }


        else if(item.getItemId() == 2) {
            Toast.makeText(MainActivity.this, "Change of Language is Selected",
                        Toast.LENGTH_LONG).show();
            if(selection.equalsIgnoreCase("DBS")) {
                btnDBS.setText("星展银行");
            } else if(selection.equalsIgnoreCase("OCBC")) {
                btnOCBC.setText("华侨银行");
            } else if(selection.equalsIgnoreCase("UOB")) {
                btnUOB.setText("大华银行");
            }
        }
        return super.onContextItemSelected(item);
    }
}