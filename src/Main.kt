//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("### Probando Cuenta de Ahorros ###")

    // 1. Creamos una instancia de CuentaAhorros
    // Saldo inicial de 20000 y tasa anual del 5%
    val miCuentaAhorros = CuentaAhorro(20000f, 5.0f)
    miCuentaAhorros.Imprimir()

    // 2. Realizamos operaciones
    miCuentaAhorros.Consignar(5000f) // Saldo: 25000
    miCuentaAhorros.Retirar(2000f)   // Saldo: 23000
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)
    miCuentaAhorros.Retirar(1000f)   // 5to retiro, generará comisión extra

    // 3. Generamos el extracto mensual
    // Se cobrará 1000 de comisión por el retiro extra y se calculará el interés
    miCuentaAhorros.ExtractoMensual()

    // 4. Mostramos el estado final de la cuenta
    miCuentaAhorros.Imprimir()

    // Prueba de cuenta inactiva
    println("\n### Probando cuenta inactiva ###")
    val cuentaInactiva = CuentaAhorro(9000f, 5.0f)
    cuentaInactiva.Imprimir()
    cuentaInactiva.Consignar(100f) // Debería fallar
    cuentaInactiva.Retirar(500f)  // Debería fallar

}