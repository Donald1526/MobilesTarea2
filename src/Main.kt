//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("### Probando Cuenta de Ahorros ###")


    val miCuentaAhorros = CuentaAhorro(20000f, 5.0f)
    miCuentaAhorros.Imprimir()

    miCuentaAhorros.Consignar(5000f)
    miCuentaAhorros.Retirar(2000f)
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)


    miCuentaAhorros.ExtractoMensual()

    miCuentaAhorros.Imprimir()


    println("\n### Probando cuenta inactiva ###")
    val cuentadeNaze = CuentaAhorro(9000f, 5.0f)
    cuentadeNaze.Imprimir()
    cuentadeNaze.Consignar(100f)
    cuentadeNaze.Retirar(500f)
//meu dios naze
}