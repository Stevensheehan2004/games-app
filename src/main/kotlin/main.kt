import io.github.oshai.kotlinlogging.KotlinLogging
import model.Game
import service.GameService
import utils.readNextInt
import utils.readNextDouble
import utils.readNextInt
import utils.readNextLine

val gameService = GameService()
private val logger = KotlinLogging.logger {}

fun main() {
    logger.info { "Games App Started" }
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
         > """.trimMargin(">"))
    return readNextInt("==>> ")
}

fun runMenu() {
    var input: Int
    do {
        input = mainMenu()
        when (input) {
            1 -> addGame()
            2 -> listGames()
            3 -> updateGame()
            4 -> deleteGame()
            0 -> {
                println("Exiting App")
                logger.info { "Games App Exiting" }
            }

            else -> println("Invalid Option")
        }
    } while (input != 0)
}

fun addGame() {
    val name = readNextLine("Name: ")
    val genre = readNextLine("Genre: ")
    val price = readNextDouble("Price: ")
    val productionCost = readNextDouble("Production Cost: ")
    val copiesSold = readNextInt("Copies Sold: ")
    val companyId = readNextInt("Company ID: ")

    gameService.addGame(
        Game(0, name, genre, price, productionCost, copiesSold, companyId)
    )

    println("Game added")
}

fun listGames() {
    gameService.getGames().forEach { println(it) }
}

fun updateGame() {
    val id = readNextInt("Enter ID to update: ")
    val name = readNextLine("Name: ")
    val genre = readNextLine("Genre: ")
    val price = readNextDouble("Price: ")
    val productionCost = readNextDouble("Production Cost: ")
    val copiesSold = readNextInt("Copies Sold: ")
    val companyId = readNextInt("Company ID: ")

    val updated = Game(id, name, genre, price, productionCost, copiesSold, companyId)

    if (gameService.updateGame(id, updated)) {
        println("Updated")
    } else {
        println("Not found")
    }
}

fun deleteGame() {
    val id = readNextInt("Enter ID to delete: ")

    if (gameService.deleteGame(id)) {
        println("Deleted")
    } else {
        println("Not found")
    }
}