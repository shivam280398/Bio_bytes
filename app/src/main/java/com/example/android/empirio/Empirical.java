package com.example.android.empirio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Empirical extends AppCompatActivity {

    public static Double[] atomicMasses ={1.0079, 4.0026, 6.941, 9.0122, 10.811, 12.0107, 14.0067, 15.9994, 18.9984, 20.1797, 22.9897, 24.305, 26.9815, 28.0855, 30.9738, 32.065, 35.453,
            39.0983, 39.948, 40.078, 44.9559, 47.867, 50.9415, 51.9961, 54.938, 55.845, 58.6934, 58.9332, 63.546, 65.39, 69.723, 72.64, 74.9216, 78.96, 79.904, 83.8, 85.4678, 87.62, 88.9059, 91.224,
            92.9064, 95.94, 98.0, 101.07, 102.9055, 106.42, 107.8682, 112.411, 114.818, 118.71, 121.76, 126.9045, 127.6, 131.293, 132.9055, 137.327, 138.9055, 140.116, 140.9077, 144.24, 145.0, 150.36,
            151.964, 157.25, 158.9253, 162.5, 164.9303, 167.259, 168.9342, 173.04, 174.967, 178.49, 180.9479, 183.84, 186.207, 190.23, 192.217, 195.078, 196.9665, 200.59, 204.3833, 207.2, 208.9804, 209.0,
            210.0, 222.0, 223.0, 226.0, 227.0, 231.0359, 232.0381, 237.0, 238.0289, 243.0, 244.0, 247.0, 247.0, 251.0, 252.0, 257.0, 258.0, 259.0, 261.0, 262.0, 262.0, 264.0, 266.0, 268.0, 272.0, 277.0, 0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};

    public static String[] elementNames = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
            "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb",
            "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm",
            "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Uut", "Fl", "Uup", "Lv", "Uus", "Uuo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empirical);

    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void calc(View view) {
        EditText reactant1 = (EditText) findViewById(R.id.reactant1);
        String reactant_one = reactant1.getText().toString();
        EditText reactant2 = (EditText) findViewById(R.id.reactant2);
        String reactant_two = reactant2.getText().toString();
        EditText reactant3 = (EditText) findViewById(R.id.reactant3);
        String reactant_three = reactant3.getText().toString();
        EditText mass1 = (EditText) findViewById(R.id.mass1);
        double mass_1 = Float.valueOf(mass1.getText().toString());
        EditText mass2 = (EditText) findViewById(R.id.mass2);
        double mass_2 = Float.valueOf(mass2.getText().toString());
        EditText mass3 = (EditText) findViewById(R.id.mass3);
        double mass_3 = Float.valueOf(mass3.getText().toString());
        TextView result = (TextView) findViewById(R.id.Final);
        result.setText("Result");
        String r = empirical(mass_1,mass_2,mass_3,reactant_one,reactant_two,reactant_three);
        result.setText(r.toString());
    }

    public static String empirical(double a,double b,double c,String e1,String e2,String e3){
        String s3 = "";
        double x1 = a/atmass(e1);
        double x2 = b/atmass(e2);
        double x3 = c/atmass(e3);
        double H = Math.min(x1, Math.min(x2, x3));
        int g1 = approx(x1/H);
        int g2 = approx (x2/H);
        int g3 = approx (x3/H);
        String fin;
        fin = e1+g1+e2+g2+e3+g3;
        return fin;
    }
    public static int approx(double a){
        return (int)Math.round(a);

    }

    public static int m;
    public static double atmass(String a){
        for(int i =0;i<115;i++){
            if(elementNames[i].equals(a)){
                m=i;
                break;
            }
        }
        double x=atomicMasses[m];
        return x;
    }

}
