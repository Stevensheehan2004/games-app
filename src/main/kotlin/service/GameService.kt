package service

import model.Game

class GameService {

    private val games = ArrayList<Game>()
    private var lastId = 0
    private fun getId(): Int = lastId++

    fun addGame(game: Game) {
        game.id = getId()
        games.add(game)
    }

    fun getGames(): List<Game> {
        return games
    }

    fun updateGame(id: Int, updated: Game): Boolean {
        val index = games.indexOfFirst { it.id == id }
        if (index != -1) {
            games[index] = updated
            return true
        }
        return false
    }

    fun deleteGame(id: Int): Boolean {
        return games.removeIf { it.id == id }
    }

}