package com.example.configurar.sistema_clinico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class AreaGeneralLayout extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_general);

        GridView gridView = (GridView) findViewById( R.id.GridView1 );
        gridView.setAdapter( new GridViewImageAdapter(this) );
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        Toast.makeText(AreaGeneralLayout.this,"HEMATOLOGIA: Se encarga del estudio de la Sangre, Médula ósea, Ganglios Linfáticos, Bazo",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 1:{
                        Toast.makeText(AreaGeneralLayout.this, "INMUNOLOGIA: Estudia el sistema inmunitario, los órganos, tejidos y células", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2:{
                        Toast.makeText(AreaGeneralLayout.this, "BIOQUIMICA: Estudia la composición química de los seres vivos, proteínas, carbohidratos, lípidos y ácidos nucleicos", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 3:{
                        Toast.makeText(AreaGeneralLayout.this, "MICROBIOLOGIA: Estudia a los microorganismos, seres vivos no visibles al ojo humano", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 4:{
                        Toast.makeText(AreaGeneralLayout.this, "ORINA: Es la evaluación física, química y microscópica de la orina", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 5:{
                        Toast.makeText(AreaGeneralLayout.this, "HECES: Consiste en la obtención de una muestra de heces que posteriormente será conservada y llevada a analizar", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
                //Toast.makeText(AreaGeneralLayout.this, "INMUNOLOGIA" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
