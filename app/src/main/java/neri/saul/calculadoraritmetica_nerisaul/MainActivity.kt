package neri.saul.calculadoraritmetica_nerisaul

import android.annotation.SuppressLint
import android.icu.util.Currency
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val calculadora: Calculadora = Calculadora()

    private var displayReference: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // botones de numeros de la calculadora
        val btn0: Button = this.findViewById(R.id.btnNumber0)
        val btn1: Button = this.findViewById(R.id.btnNumber1)
        val btn2: Button = this.findViewById(R.id.btnNumber2)
        val btn3: Button = this.findViewById(R.id.btnNumber3)
        val btn4: Button = this.findViewById(R.id.btnNumber4)
        val btn5: Button = this.findViewById(R.id.btnNumber5)
        val btn6: Button = this.findViewById(R.id.btnNumber6)
        val btn7: Button = this.findViewById(R.id.btnNumber7)
        val btn8: Button = this.findViewById(R.id.btnNumber8)
        val btn9: Button = this.findViewById(R.id.btnNumber9)
        val btnPoint: Button = this.findViewById(R.id.btnPoint)

        // botones para operaciones aritmeticas
        val btnPlusOperation: Button = this.findViewById(R.id.plus_op_btn)
        val btnMinusOperation: Button = this.findViewById(R.id.minus_op_btn)
        val btnMultiplicationOperation: Button = this.findViewById(R.id.multiplication_op_btn)
        val btnDivisionOperation: Button = this.findViewById(R.id.division_op_btn)

        // botones de utilidad de la calculadora
        val btnGetResult: Button = this.findViewById(R.id.get_result_op_btn)
        val btnClearDisplay: Button = this.findViewById(R.id.clear_display_btn)
        val btnDeleteOne: Button = this.findViewById(R.id.delete_one_btn)

        val displayTextContent: TextView = this.findViewById(R.id.displayTextContent)
        this.displayReference = displayTextContent

        btn0.setOnClickListener {

            

            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append("0")

            displayTextContent.setText(sb.toString())
        }

        btn1.setOnClickListener {
            val sb1: StringBuilder = StringBuilder()
            val currentDisplayText1: String = displayTextContent.text.toString()

            sb1.append(currentDisplayText1)
            sb1.append("1")

            displayTextContent.setText(sb1.toString())
        }

        btn2.setOnClickListener {
            val sb2: StringBuilder = StringBuilder()
            val currentDisplayText2: String = displayTextContent.text.toString()

            sb2.append(currentDisplayText2)
            sb2.append("2")

            displayTextContent.setText(sb2.toString())
        }

        btn3.setOnClickListener {
            val sb3: StringBuilder = StringBuilder()
            val currentDisplayText3: String = displayTextContent.text.toString()

            sb3.append(currentDisplayText3)
            sb3.append("3")

            displayTextContent.setText(sb3.toString())
        }

        btn4.setOnClickListener {
            val sb4: StringBuilder = StringBuilder()
            val currentDisplayText4: String = displayTextContent.text.toString()

            sb4.append(currentDisplayText4)
            sb4.append("4")

            displayTextContent.setText(sb4.toString())
        }

        btn5.setOnClickListener {
            val sb5: StringBuilder = StringBuilder()
            val currentDisplayText5: String = displayTextContent.text.toString()

            sb5.append(currentDisplayText5)
            sb5.append("5")

            displayTextContent.setText(sb5.toString())
        }

        btn6.setOnClickListener {
            val sb6: StringBuilder = StringBuilder()
            val currentDisplayText6: String = displayTextContent.text.toString()

            sb6.append(currentDisplayText6)
            sb6.append("6")

            displayTextContent.setText(sb6.toString())
        }

        btn7.setOnClickListener {
            val sb7: StringBuilder = StringBuilder()
            val currentDisplayText7: String = displayTextContent.text.toString()

            sb7.append(currentDisplayText7)
            sb7.append("7")

            displayTextContent.setText(sb7.toString())
        }

        btn8.setOnClickListener {
            val sb8: StringBuilder = StringBuilder()
            val currentDisplayText8: String = displayTextContent.text.toString()

            sb8.append(currentDisplayText8)
            sb8.append("8")

            displayTextContent.setText(sb8.toString())
        }

        btn9.setOnClickListener {
            val sb9: StringBuilder = StringBuilder()
            val currentDisplayText9: String = displayTextContent.text.toString()

            sb9.append(currentDisplayText9)
            sb9.append("9")

            displayTextContent.setText(sb9.toString())
        }

        // listeners de operaciones aritmeticas
        btnPlusOperation.setOnClickListener {
            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append("+")

            displayTextContent.setText(sb.toString())
        }

        btnMinusOperation.setOnClickListener {
            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append("-")

            displayTextContent.setText(sb.toString())
        }

        btnMultiplicationOperation.setOnClickListener {
            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append("*")

            displayTextContent.setText(sb.toString())
        }

        btnDivisionOperation.setOnClickListener {
            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append("/")

            displayTextContent.setText(sb.toString())
        }

        // listener de los botones de utilidades
        btnDeleteOne.setOnClickListener {
            val currentDisplayText: String = displayTextContent.text.toString()

            if (currentDisplayText.length != 0) {
                val newDisplayContent: String = currentDisplayText.dropLast(1)
                displayTextContent.setText(newDisplayContent)
            }
        }

        btnClearDisplay.setOnClickListener {
            displayTextContent.setText("")
        }

        btnGetResult.setOnClickListener {
            try {
                val result: Double = this.calculadora.evaluar(displayTextContent.text.toString())
                displayTextContent.setText(result.toString())
            } catch (ex: IndexOutOfBoundsException) {
                displayTextContent.setText(R.string.nan_result)
            } catch (ex: NumberFormatException) {
                displayTextContent.setText(R.string.syntax_error)
            }
        }

        btnPoint.setOnClickListener {
            val sb: StringBuilder = StringBuilder()
            val currentDisplayText: String = displayTextContent.text.toString()

            sb.append(currentDisplayText)
            sb.append(".")

            displayTextContent.setText(sb.toString())
        }

    }

    fun preventCrashBySyntaxError() {
        if (this.displayReference != null) {
            val result: String = this.displayReference?.text.toString()
            if (result == R.string.nan_result.toString() || result == R.string.syntax_error.toString()) {
                this.displayReference?.setText("")
            }
        }
    }
}