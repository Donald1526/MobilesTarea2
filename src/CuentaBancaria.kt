import com.sun.jdi.FloatType

open class CuentaBancaria (protected  var saldo:Float, protected  var tasa_anual: Float){
    protected var numeroConsignaciones: Int = 0
    protected var numeroRetiro : Int = 0
    protected var comisionMensual : Float = 0.0F

    open fun Consignar(cantidad:Float){
        if ( cantidad > 0 ){
            this.saldo += cantidad
            numeroConsignaciones++
        }
        else {
            println("La cantidad debe ser positiva")
        }
    }
    open fun Retirar(cantidad:Float){
        if ( cantidad > this.saldo){
            println("La cantidad no puede ser mayor al saldo")
        }
        else{
            this.saldo -= cantidad
            numeroRetiro++
        }
    }
    open fun CalcularInteres(){
        var monto_interes = saldo*(tasa_anual/12/100)
        saldo += monto_interes
    }
    open fun ExtractoMensual(){
        saldo -= comisionMensual
        CalcularInteres()
    }
    open fun Imprimir(){
        println("Saldo : " + this.saldo+" \n" +
            "Tasa Anual : " + this.tasa_anual+" \n" +
            "Numero de Retiros : " + this.numeroRetiro+" \n" +
            "Numero de Consignaciones : " + this.numeroConsignaciones+" \n" +
            "Comision Mensual : " + this.comisionMensual+" \n"
        )
    }
}