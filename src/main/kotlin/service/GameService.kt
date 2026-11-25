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

}