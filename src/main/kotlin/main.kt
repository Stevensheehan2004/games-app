import model.Game
import service.GameService


val gameService = GameService()

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print(""" 
         > ----------------------------------
         > |        GAME MANAGER APP        |
         > ----------------------------------
         > | GAME MENU                      |
         > |   1) Add a game                |
         > |   2) List all games            |
         > |   3) Update a game             |
         > |   4) Delete a game             |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun runMenu() {
    var input: Int
    do {
        input = mainMenu()
        when (input) {
            1 -> addGame()
            2 -> listGames()
            3 -> println("Update game will be coded here")
            4 -> println("Delete game will be coded here")
            0 -> println("Exiting App")
            else -> println("Invalid Option")
        }
    } while (input != 0)
}

fun addGame() {
    print("Name: ")
    val name = readlnOrNull() ?: ""

    print("Genre: ")
    val genre = readlnOrNull() ?: ""

    print("Price: ")
    val price = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    print("Production Cost: ")
    val productionCost = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    print("Copies Sold: ")
    val copiesSold = readlnOrNull()?.toIntOrNull() ?: 0

    print("Company ID: ")
    val companyId = readlnOrNull()?.toIntOrNull() ?: 0

    gameService.addGame(
        Game(0, name, genre, price, productionCost, copiesSold, companyId)
    )

    println("Game added")
}

fun listGames() {
    println(gameService.getGames())
}
