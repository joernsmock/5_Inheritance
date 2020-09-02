import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    var m = Car(make = "Ford", model = "Focus", mpg = 23.5)
    var s = ConvertibleCar(make = "Porsche", model = "911SC", mpg = 18.5)
    var weather = "dry"

    if (weather == "dry") {
        s.openTop()
    }

    s.accelerate(55)
    s.drive(100)
    s.dashboard()

    if (s.speed > 0) {
        s.accelerate(35 - s.speed) // brake till < 35 (speed limit!)
    }
    s.dashboard()

    s.drive(20)
    s.dashboard()

    s.closeTop()
    s.drive(40)
    s.dashboard()

    s.stop()
    s.refill()
    s.dashboard()
}
