package animaltree

abstract class Animal {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String

    abstract fun makeNoise()

    abstract fun eat()

    open fun roam(){
        println("The Animal is roaming")
    }

    fun sleep(){
        println("The Animal is sleeping")
    }
}
