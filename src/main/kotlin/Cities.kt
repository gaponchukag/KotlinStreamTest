data class City(
    val name: String,
    val population: Long
)

fun main() {
    val city = City("Омск", 1000_000_000)
    println(city.name)

    val cities = listOf(
        City("Париж", 2_148_327),
        City("Москва", 12_678_079),
        City("Берлин", 3_644_826),
        City("Мадрид", 3_266_126),
    )

    //перебор всех элементов
    cities.forEach { city -> println(city) }
    //перебор с index
    cities.forEachIndexed { index, city -> println("Index $index == ${city.name}") }
    //Преобразование элементов списка
    val cityNames = cities.map { city -> city.name }
    println(cityNames)
    //Фильтрация элементов списка
    val filterCities = cities.filter { city -> city.population > 6_000_000 }
    println(filterCities)
    //Возврат первого значения списка или null
    val cityFirst: City? = cities.firstOrNull()
    println(cityFirst)
    ////Возврат первого значения списка или exception если null
    val cityFirstNull: City = cities.first()
    println(cityFirstNull)
//    val cities2 = emptyList<String>()
//    cities2.first()
    println("=============================")
    //Возврат первого значения списка с фильтром
    val cityFirstWithFilter: City? = cities.firstOrNull() { city -> city.name.startsWith("М") }
    println("$cityFirstWithFilter")

    println("=========Sorting==========")
    var sortedCity = cities.sortedByDescending { city -> city.name }
    println(sortedCity)
    sortedCity = cities.sortedBy { city -> city.name }
    println(sortedCity)

    println("=======Объединение нескольких строк в одну=========")
//    префикс (строка, добавляемая перед первым элементом);
//    постфикс (строка, добавляемая после последнего элемента);
//    ограничение на максимальное количество элементов, которые будут включены в результирующую строку;
//    а также специальную строку, которая будет сигнализировать о том, что в результат поместились не все элементы (по умолчанию это многоточие).
    val cityString = cities.map { city -> city.name }.joinToString (separator = ",")
    println(cityString)
}