# Command-Line Chat Application
A simple Java-based command-line chat application where users can register, log in, create and join chat rooms, view user details, and list available chat rooms. 
This project is ideal for practicing object-oriented programming, command parsing, and handling in-memory data structures in Java.

## 📌 Project Overview
This application allows users to interact through the command line interface by issuing commands to manage accounts and chat rooms. It maintains a minimal interface without graphical UI but effectively simulates chat app behavior from the terminal.


## 🚀 Features
- Register a unique user
- Log in and log out users
- Create chat rooms with unique names
- Add online users to existing chat rooms
- View detailed information of a user (status and chat room)
- List all available chat rooms
- Clean exit with summary

## 🛠️ Tech Stack
- **Language:** Java 8+
- **Build Tool:** No external dependencies, simple Java class
- **Libraries Used:** Standard Java Collections (HashSet, HashMap, LinkedHashSet)

## 📂 Project Structure
com.chatter.platform ├── App.java // Main application logic
## How to Run
1. Install Java JDK 8
2. Clone the repository: git clone github_url
3. navigate to the project directory: cd command-line-chat-app
4. Compile the code: javac -d . src/com/chatter/platform/App.java
5. Run the application: java com.chatter.platform.App

💬 Sample Commands
  - REGISTER Alice 
  - LOGIN Alice
  - CREATE_ROOM DevTalk
  - ADD Alice TO DevTalk
  - USER_DETAIL Alice
  - LISTROOMS
  - LOGOUT Alice
  - EXIT

🧠 Notes
  - Usernames must not contain spaces or semicolons.
  - You must log in before joining a room.
  - A user can only be in one room at a time.
  - Data is stored in memory and reset on every restart.
      
      
