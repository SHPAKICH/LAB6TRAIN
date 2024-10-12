import kotlin.random.Random
class TrainManager {
    // Создаем направление
    fun createRoute(): Route {
        var start: String
        var destination: String
        do {
            start = cities.random()
            destination = cities.random()
        } while (start == destination)
        return Route(start, destination)
    }

    // Продажа билетов
    fun sellTickets(): Int = Random.nextInt(5, 201)

    // Формируем поезд
    fun formTrain(route: Route, passengers: Int): Train {
        val train = Train(route)
        train.passengers = passengers

        var remainingPassengers = passengers
        // Добавляем вагоны, пока все пассажиры не будут размещены
        while (remainingPassengers > 0) {
            val wagonCapacity = Random.nextInt(5, 26)
            train.addWagon(Wagon(wagonCapacity))
            remainingPassengers = remainingPassengers.minus(wagonCapacity)
        }

        return train
    }

    // Запуск программы
    fun start() {
        println("Добро пожаловать в программу по составлению плана поезда!")
        while (true) {
            println("Введите EXIT, чтобы завершить работу, или нажмите Enter для продолжения...")
            val input = readLine() ?: ""
            if (input.equals("EXIT", ignoreCase = true)) break

            // Создаем направление
            val route = createRoute()
            println("Создано направление: $route")

            // Продажа билетов
            val passengers = sellTickets()
            println("Продано билетов: $passengers")

            // Формируем поезд
            val train = formTrain(route, passengers)
            println("Поезд сформирован. Количество вагонов: ${train.getWagonCount()}")

            // Информация по каждому вагону
            train.printWagonInfo()

            // Отправка поезда
            train.send()
        }
        println("Программа завершена.")
    }
}