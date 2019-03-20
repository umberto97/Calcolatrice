package com.example.calcolatrice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//eseguo le varie operazioni a secondo da quale bottone viene selezionato
        somma.setOnClickListener{calcolo(Operazione.Somma)}
        diff.setOnClickListener{calcolo(Operazione.Differenza)}
        mol.setOnClickListener{calcolo(Operazione.Moltiplicazione)}
        div.setOnClickListener{calcolo(Operazione.Rapporto)}
    }
//funzione che esegue le varie operazioni
    private fun calcolo(scelta:Operazione) {
//uso un try catch poiché l'utente potrebbe inserire valori che creano delle eccezioni
        try{
    //prendo i due operandi
            val op1=n1.text.toString().toDouble()
            val op2=n2.text.toString().toDouble()
    //creo la costante che conterrà il risultato
            var r:Double?=null
    //a seconda di ciò che è stato passato svolgo una delle operazioni
            when (scelta.simb) {
                "+" -> r=op1+op2
                "-" -> r=op1-op2
                "*" -> r=op1*op2
                "/" -> {
                    if(op2!=0.0) { r=op1/op2 }
                    else  { ris.text="Divisione per zero non possibile" }
                }
            }
            if(r!=null) ris.text=r.toString()
        }   catch(e: NumberFormatException) {
                ris.text="Operandi non validi"
            }
}
}
//creo una classe enum per indicare le varie operazioni
enum class Operazione(val simb:String) {
    Somma("+"),
    Differenza("-"),
    Moltiplicazione("*"),
    Rapporto("/")
}
