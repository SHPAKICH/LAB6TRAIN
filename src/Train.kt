class Train(val route: Route) {
    private val wagons = mutableListOf<Wagon>()
    var passengers: Int = 0

    // Добавляем вагоны
    fun addWagon(wagon: Wagon) {
        wagons.add(wagon)
    }

    // Возвращаем количество вагонов
    fun getWagonCount(): Int = wagons.size

    // Выводим информацию по каждому вагону
    fun printWagonInfo() {
        var remainingPassengers = passengers
        for ((index, wagon) in wagons.withIndex()) {
            val passengersInWagon = minOf(remainingPassengers, wagon.capacity)
            println("Вагон ${index + 1}: вместимость ${wagon.capacity}, пассажиров в вагоне: $passengersInWagon")
            remainingPassengers -= passengersInWagon
        }
    }

    // Отправка поезда
    fun send() {
        println("Поезд по направлению ${route}, состоящий из ${getWagonCount()} вагонов, отправлен!")
    }
}