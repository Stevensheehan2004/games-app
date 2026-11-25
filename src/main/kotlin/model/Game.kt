package model

data class Game(
    var id: Int,
    var name: String,
    var genre: String,
    var price: Double,
    var productionCost: Double,
    var copiesSold: Int,
    var companyId: Int
) {
    override fun toString(): String {
        return "[$id] $name | $genre | Price: EUR $price | Production Cost: EUR $productionCost | Sold: $copiesSold | Company ID: $companyId"
    }
}