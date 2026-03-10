# Pokémon Ga-Olé — Console Battle Game

A console-based turn-based Pokémon battle game in Java, inspired by the arcade game *Pokémon Ga-Olé*. The game features ASCII art animations, interactive roulette mechanics, type effectiveness, Pokémon capture, and a persistent leaderboard.

---

## How to Play

1. **Title Screen** — Press `Enter` to start.
2. **Choose Your Pokémon** — Press `1`, `2`, or `3` to pick one Pokémon. Your team will be that choice plus one random Pokémon. The enemy team is always 2 random Pokémon.
3. **Battle** — Turns alternate between attacking and defending:
   - **Your Turn (Attack):** Stop the attack roulette with `Space` to get a damage boost (10×, 20×, or 35×), then mash `Space` during the spirit phase to raise your spirit multiplier. Damage = `(boost × spirit × attack power) / 10`, modified by type effectiveness.
   - **Enemy Turn (Defend):** Stop the defense roulette with `Space` (0×, 10×, or 20× defense). The enemy deals random damage; your defense reduces it. If an ally's HP drops to 0, they faint.
4. **Catch Phase** — Once both enemy Pokémon are defeated, spin the Pokéball roulette to select a ball (Normal/Great/Ultra/Master). Catch success depends on ball quality vs. enemy grade and a random chance roll.
5. **Results** — Enter your name; your score (total damage dealt) is saved. The top 5 scores are displayed on the leaderboard.

---

## Project Structure

```
final_proj/src/
│
├── Game.java                 Entry point — orchestrates the full game flow
├── Player.java               Stores player name and score
├── Battle.java               Main battle loop (attack/defend phases, win/loss checks)
├── Catch.java                Catch logic and probability checks
│
├── PokemonPack/              Data models
│   ├── Pokemon.java          Pokémon entity (name, type, stats, grade)
│   ├── PokemonType.java      Type system (Fire/Water/Electric) and effectiveness matrix
│   ├── Stats.java            HP, AttackPower, DefensePower container
│   ├── Ally.java             Player team — 1 random + 1 chosen Pokémon
│   └── Enemy.java            Enemy team — 2 random Pokémon
│
├── game_mechanics/           Core gameplay mechanics
│   ├── Mash.java             KeyListener for real-time keyboard input
│   ├── Attack.java           Attack phase and damage calculation
│   ├── Defend.java           Defense phase and damage mitigation
│   ├── Roulette.java         Base roulette animation (cycles slides until Space)
│   ├── AttackRoulette.java   Attack roulette — 3 boost levels (10×/20×/35×)
│   ├── DefendRoulette.java   Defense roulette — 3 boost levels (0×/10×/20×)
│   ├── PokeballRoulette.java Pokéball roulette — 4 ball types
│   ├── Spirit.java           Static spirit multiplier tracker (increases on mash)
│   └── Ball.java             Pokéball data (type, catch chance, min grade)
│
└── Render/                   UI and display (all ASCII art via stdout)
    ├── Display.java          Base display — shows stats for all 4 Pokémon
    ├── TitleScreen.java      Animated ASCII title screen
    ├── GameOver.java         Game over screen
    ├── Leaderboard.java      Reads/writes scores to score.txt, shows top 5
    ├── CatchingScreen.java   Catch anticipation animation
    ├── MashButton.java       Spirit phase animation with current spirit level
    ├── PokemonRender.java    Static ASCII art for Pikachu, Charmander, Squirtle
    ├── FireAttack.java       Fire-type attack animation
    ├── WaterAttack.java      Water-type attack animation
    └── LightningAttack.java  Electric-type attack animation
```

---

## Key Mechanics

### Type Effectiveness
| Attacker \ Defender | Fire | Water | Electric |
|---------------------|------|-------|----------|
| Fire                | 0.5× | 1.0×  | 1.0×     |
| Water               | 1.5× | 0.5×  | 1.0×     |
| Electric            | 1.0× | 1.5×  | 0.5×     |

### Damage Formula
```
Damage = (RouletteBoost × Spirit × AttackPower) / 10 × TypeMultiplier
Net Damage to Ally = max(0, EnemyDamage − PlayerDefense)
```

### Catch Mechanics
- The enemy must be defeated (HP ≤ 0).
- The selected Pokéball's grade must be ≥ the enemy Pokémon's grade.
- A random roll must fall within the ball's catch rate: Normal 10%, Great 30%, Ultra 50%, Master 90%.

### Score & Leaderboard
- Score equals total damage dealt during the battle.
- Saved to `score.txt` in `name|score` format.
- Top 5 scores are displayed at the end of each run.

---

## Pokémon Roster

Six preset Pokémon are available: **Charmander**, **Squirtle**, **Pikachu**, **Vulpix**, **Voltorb**, and **Gyarados**, each with unique stats, a type, and a capture grade.

---

## Running the Game

Compile all `.java` files from the `final_proj/src/` directory and run `Game`:

```bash
javac -d out $(find final_proj/src -name "*.java")
java -cp out Game
```

> **Note:** The game uses a `JFrame` window (hidden) solely to capture keyboard input via `KeyListener`. A graphical window will briefly appear — this is expected.
