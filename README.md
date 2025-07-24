# 🕹️ **Java Swing 2D Spider Dodging Game**

A **simple yet engaging 2D game** built using Java Swing. Control the player and **dodge falling spiders**. Reach the end of the screen to win!

🖼️ **Gameplay preview screenshots** available in the `screenshots/` folder.

---

## 🎮 **Gameplay Features**

* 🏆 **Victory** when you cross the screen width
* 🚪 **Player movement** using arrow keys (Left, Right)
* 👇 **Spiders** fall from the top
* 💥 **Game Over** when you collide with a spider
* ⟳ **Restart or play again** using keyboard keys

---

## 💻 **Tech Stack**

* **Java 8+**
* **Swing GUI** (AWT, JPanel, JFrame)
* **Timer-based game loop**
* **BufferedImage** for background
* **Keyboard input handling**

---

## 🗂️ **Directory Structure**

```
JavaGame/
├── README.md
├── screenshots/
│   └── screenshot1.png
├── src/
│   └── com/
│       └── brainmentors/
│           ├── gaming/
│           │   ├── Board.java
│           │   ├── GameFrame.java
│           │   └── GameState.java
│           └── gaming/
│               └── sprites/
│                   ├── Player.java
│                   ├── Enemy.java
│                   └── sprite.java
└── resources/
    └── game-ab.jpeg
```

---

## 🚀 **How to Run (Eclipse Setup)**

1. **Open Eclipse**
2. **Create a new Java Project**
3. Go to `src` folder → Right click → `New → Package` → name it `com.brainmentors.gaming`
4. Create subpackage `com.brainmentors.gaming.sprites`
5. **Copy the Java files** into the appropriate packages
6. **Add all image files** (`.jpeg`, `.gif`) to the `resources` folder inside the project
7. Right-click the project → `Build Path → Configure Build Path`

   * Under `Source`, add the `resources` folder as a resource folder
8. **Run `GameFrame.java` as a Java Application**

---

## 💡 **Controls**

| Key     | Action                |
| ------- | --------------------- |
| `→`     | **Move Right**        |
| `←`     | **Move Left**         |
| `ENTER` | **Start Game**        |
| `R`     | **Restart after End** |

---

## 🧰 **Tested On**

* **Windows 11**
* **Java 17 (OpenJDK)**
* **Eclipse IDE & VS Code**

---

## 🌟 **Future Enhancements**

* 🎯 **Score system**
* 🔊 **Sound effects** (win/loss)
* ❤️ **Health bar or lives system**
* 🔫 **Shooting mechanics**
* 🚀 **Level progression**

---

## 🖼️ **Gameplay Screenshots**

Gameplay screenshots are available in the `screenshots/` folder. You can open them to preview the game interface.

---

## 📜 **License**

This project is licensed under the **MIT License**.
