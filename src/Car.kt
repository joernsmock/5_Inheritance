import kotlin.math.roundToInt

// Naming according to the rules?
open class Car(make: String, model: String, mpg: Double) {
    val tankSize = 15.25 // gallons
    open val image = ""
    open var gasTank = tankSize
    open var speed = 0
    open var odometer = 0
    open var fuelEconomy = mpg.toFloat()

    open fun refill() {
        println("refueling...")
        gasTank = tankSize
    }

    // when braking, acceleration is negative
    open fun accelerate(x: Int) {
        // I cannot write this on one line with the declaration???
        speed += x
    }

    open fun drive(miles: Int) {
        println("$this.drive() called, tank is ${gasTank.roundToInt()}, want to to $miles")
        // c-style printing: println("Tank is %.2f gal".format(gasTank))

        // calculate left miles at this speed?
        val leftmiles = (gasTank * fuelEconomy).toInt()
        if (leftmiles > miles) {
            gasTank -= miles / fuelEconomy // mpg
            odometer += miles
        } else {
            println("Not enough gas left (enough for $leftmiles).")
            odometer += leftmiles
            gasTank = 0.0
        }
    }

    open fun stop() {
        speed = 0
    }

    open fun driving(): Boolean {
        //return speed.absoluteValue > 0 // IntelliJ Idea is cool: Alt+Shift+Enter to make a 6-line-if-else into this
        return speed != 0 // IntelliJ Idea is cool: Alt+Shift+Enter to make a 6-line-if-else into this
    }

    open fun dashboard() {
        println("$this is doing $speed, ${gasTank.roundToInt()} gal left, odometer: ${odometer} mls")
    }

    init {
        println("$this object has been created")
        // to avoid writing to this before it is declared.
        // this is not logical since "init" is always (is it?)
        // run first when the object is instantiated
    }
}

class ConvertibleCar(make: String, model: String, mpg: Double) : Car(make, model, mpg) {
    override var gasTank = 10.85 // gallons
    override val image = "convertible.jpg"
    var isOpen: Boolean
    fun openTop() {
        isOpen = true
    }

    fun closeTop() {
        isOpen = false
    }

    init {
        isOpen = false // have to put "init" to the end,
    }
}

