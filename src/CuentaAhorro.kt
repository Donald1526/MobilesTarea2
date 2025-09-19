class CuentaAhorro (
    saldo: Float,
    tasaAnual: Float
) : CuentaBancaria(saldo, tasaAnual) {
    val cuentaActiva: Boolean
        get() = saldo >= 10000
    override fun Consignar(cantidad:Float){
        if (cuentaActiva){
            super.Consignar(cantidad)
        }
        else{
            println("La cuenta no estaActiva")
        }
    }

    override fun Retirar(cantidad: Float) {
        if(cuentaActiva){
            super.Retirar(cantidad)
        }
        else{
            println("La cuenta no esta Activa")
        }
    }

    override fun ExtractoMensual() {
        if(super.numeroRetiro > 4){
            super.comisionMensual += (numeroRetiro - 4 ) * 1000
        }
        super.ExtractoMensual()
        println("Extracto mensual ")
        if(!cuentaActiva){
            println("La cuenta ha quedado inactiva")
        }

    }
    override fun Imprimir(){
        super.Imprimir()
        var suma = super.numeroRetiro + super.numeroConsignaciones
        println("Numero de Transaciones " + suma )
    }

}
