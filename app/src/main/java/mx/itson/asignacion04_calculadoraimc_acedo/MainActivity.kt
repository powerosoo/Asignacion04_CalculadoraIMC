package mx.itson.asignacion04_calculadoraimc_acedo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.annotation.SuppressLint

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var weight : EditText = findViewById(R.id.weight) as EditText
        var height : EditText = findViewById(R.id.height) as EditText
        var imc : TextView = findViewById(R.id.imc) as TextView
        var range : TextView = findViewById(R.id.range) as TextView
        val calcular: Button =findViewById(R.id.calcular)

        calcular.setOnClickListener {
            var peso: Float = weight.getText().toString().toFloat()
            var estatura: Float = height.getText().toString().toFloat()
            var sum: Float=peso/(estatura*estatura)
            imc.setText(sum.toBigDecimal().toString())
            if (sum < 18.5) {
                range.setText("Bajo peso")
                range.setBackgroundResource(R.color.colorOrange)
            } else if (sum >= 18.5 && sum <= 24.9) {
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreen)
            } else if (sum >= 25 && sum <= 29.9) {
                range.setText("Sobrepeso")
                range.setBackgroundResource(R.color.colorGreenish)
            } else if (sum >= 30 && sum <=34.9) {
                range.setText("Obesidad grado 1")
                range.setBackgroundResource(R.color.colorYellow)
            }else if (sum >= 35 && sum <=39.9) {
                range.setText("Obesidad grado 2")
                range.setBackgroundResource(R.color.colorOrange)
            } else if (sum >= 40) {
                range.setText("Obesidad grado 3")
                range.setBackgroundResource(R.color.colorRed)
            }
        }
    }
}