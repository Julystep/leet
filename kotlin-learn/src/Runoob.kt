class Runoob {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun printSum(a: Int, b: Int): Unit {
        var x = "xxx"
        print(a + b)
    }

    fun check(a: Int): Boolean {
        if (a in 0..50) {
            print("xxx");
        } else if (a !in 51..132) {
            print ("jjj")
        }
        return true
    }

}

fun main() {

}