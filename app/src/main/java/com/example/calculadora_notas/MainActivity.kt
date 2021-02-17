package com.example.calculadora_notas

import android.app.Dialog
import android.app.PendingIntent.getActivity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = btnCalcular
        val resultado: TextView = txtResultado

        btnCalcular.setOnClickListener {
            if (nota1.text.toString().isBlank() || nota2.text.toString()
                    .isBlank() || faltas.text.toString().isBlank()
            ) {
                Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_LONG)
                    .show()
            } else {
                var nota1: Int = Integer.parseInt(nota1.text.toString())
                var nota2: Int = Integer.parseInt(nota2.text.toString())
                var faltas: Int = Integer.parseInt(faltas.text.toString())

                var media: Int = (nota1 + nota2) / 2

                if ((nota1 in 0..10) && (nota2 in 0..10)) {
                    if (faltas < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Faltas deve ser maior que 0",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        if (media >= 6 && faltas <= 10) {
                            resultado.setText(
                                """
                            Aluno foi Aprovado
                            Nota Final: $media
                            Quantidade de Faltas: $faltas
                        """.trimIndent()
                            )
                            resultado.setTextColor(Color.GREEN)
                        } else {
                            resultado.setText(
                                """
                            Aluno foi Reprovado
                            Nota Final: $media
                            Quantidade de Faltas: $faltas
                        """.trimIndent()
                            )
                            resultado.setTextColor(Color.RED)
                        }
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Nota deve está entre 0 e 10",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}