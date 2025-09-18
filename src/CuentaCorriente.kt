class CuentaCorriente(
    saldo: Float,
    tasaAnual: Float
) : CuentaBancaria(saldo, tasaAnual) {

    var sobregiro: Float = 0f

    // Redefinimos el método retirar para permitir sobregiros.
    override fun Retirar(cantidad: Float) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad
            } else {
                sobregiro += (cantidad - saldo)
                saldo = 0f
            }
            numeroRetiro++
            println("Retiro exitoso por: $$cantidad")
        } else {
            println("La cantidad a retirar debe ser positiva.")
        }
    }

    // Redefinimos el método consignar para cubrir el sobregiro primero.
    override fun Consignar(cantidad: Float) {
        if (cantidad > 0) {
            var cantidadReal = cantidad
            if (sobregiro > 0) {
                if (cantidad <= sobregiro) {
                    sobregiro -= cantidad
                    cantidadReal = 0f
                } else {
                    cantidadReal -= sobregiro
                    sobregiro = 0f
                }
            }
            if(cantidadReal > 0) {
                // Llamamos a la implementación original de consignar solo si queda dinero
                super.Consignar(cantidadReal)
            } else {
                println("Consignación usada para cubrir sobregiro. Sobregiro restante: $$sobregiro")
            }
        } else {
            println("La cantidad a consignar debe ser positiva.")
        }
    }

    // El extracto mensual invoca directamente al del padre.
    override fun ExtractoMensual() {
        super.ExtractoMensual()
        println("Extracto mensual generado para Cuenta Corriente.")
    }

    // Redefinimos el método imprimir.
    override fun Imprimir() {
        println("--- CUENTA CORRIENTE ---")
        println("Saldo: $$saldo")
        println("Comisión Mensual: $$comisionMensual")
        val totalTransacciones = numeroConsignaciones + numeroRetiro
        println("Número total de transacciones: $totalTransacciones")
        println("Valor de sobregiro: $$sobregiro")
        println("--------------------------")
    }
}
