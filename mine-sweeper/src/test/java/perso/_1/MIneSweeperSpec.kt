package perso._1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MIneSweeperSpec {
    @Test fun `empty grid`() {
        val mineCount = MineGrid("").toMineCount()
        assertThat(mineCount).isEqualTo("")
    }
    @Test fun `1 square 1 one mine`() {
        val mineCount = MineGrid("*").toMineCount()
        assertThat(mineCount).isEqualTo("*")
    }
    @Test fun `1 square no mine`() {
        val mineCount = MineGrid(".").toMineCount()
        assertThat(mineCount).isEqualTo("0")
    }
    @Test fun `1 line 2 squares no mines`() {
        val mineCount = MineGrid("..").toMineCount()
        assertThat(mineCount).isEqualTo("0")
    }
}

class MineGrid(private val grid: String) {
    fun toMineCount(): String {
        if (grid == ".") return "0"
        return grid
    }
}
