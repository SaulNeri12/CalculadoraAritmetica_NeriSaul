package neri.saul.calculadoraritmetica_nerisaul

class Calculadora {
    var resultado: Double = 0.0

    private fun tokenizar(expr: String): List<String> {
        val tokens = mutableListOf<String>()
        var i = 0
        val cleanExpr = expr.replace(" ", "")

        while (i < cleanExpr.length) {
            val c = cleanExpr[i]

            if (c in "+*/") {
                tokens.add(c.toString())
                i++
            } else if (c == '-') {
                // Es signo negativo si está al inicio o después de un operador
                if (i == 0 || cleanExpr[i - 1] in "+-*/") {
                    var num = "-"
                    i++
                    while (i < cleanExpr.length && (cleanExpr[i].isDigit() || cleanExpr[i] == '.')) {
                        num += cleanExpr[i]
                        i++
                    }
                    tokens.add(num)
                } else {
                    tokens.add("-")
                    i++
                }
            } else if (c.isDigit() || c == '.') {
                var num = ""
                while (i < cleanExpr.length && (cleanExpr[i].isDigit() || cleanExpr[i] == '.')) {
                    num += cleanExpr[i]
                    i++
                }
                tokens.add(num)
            } else {
                throw IllegalArgumentException("Carácter no permitido: '$c'")
            }
        }

        return tokens
    }

    public fun evaluar(expresion: String): Double {

        // convertir a una lista mutable
        val lista = tokenizar(expresion).toMutableList()

        // procesar * y /
        var i = 0
        while (i < lista.size) {
            when (lista[i]) {
                "*" -> {
                    val resultado = lista[i - 1].toDouble() * lista[i + 1].toDouble()
                    lista[i - 1] = resultado.toString()
                    lista.removeAt(i)     // remove '*'
                    lista.removeAt(i)     // remove next operand
                    i--
                }
                "/" -> {
                    val resultado = lista[i - 1].toDouble() / lista[i + 1].toDouble()
                    lista[i - 1] = resultado.toString()
                    lista.removeAt(i)
                    lista.removeAt(i)
                    i--
                }
                else -> i++
            }
        }

        // Paso 4: procesar + y -
        i = 0
        while (i < lista.size) {
            when (lista[i]) {
                "+" -> {
                    val resultado = lista[i - 1].toDouble() + lista[i + 1].toDouble()
                    lista[i - 1] = resultado.toString()
                    lista.removeAt(i)
                    lista.removeAt(i)
                    i--
                }
                "-" -> {
                    val resultado = lista[i - 1].toDouble() - lista[i + 1].toDouble()
                    lista[i - 1] = resultado.toString()
                    lista.removeAt(i)
                    lista.removeAt(i)
                    i--
                }
                else -> i++
            }
        }

        return lista.first().toDouble()
    }
}