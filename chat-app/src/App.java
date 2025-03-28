import java.util.*;

public class App {

    private static final Set<String> registeredUsers = new HashSet<>();
    private static final Set<String> onlineUsers = new HashSet<>();
    private static final Map<String, String> userChatRoomMap = new HashMap<>();
    private static final Set<String> chatRooms = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            processInput(input);
        }
    }

    private static void processInput(String input) {
        String[] parts = input.split("\\s+");
        if (input.equals("EXIT")) {
            handleExit();
        } else if (input.matches("REGISTER\\s+\\S+")) {
            handleRegister(parts[1]);
        } else if (input.matches("LOGIN\\s+\\S+")) {
            handleLogin(parts[1]);
        } else if (input.matches("CREATE_ROOM\\s+\\S+")) {
            handleCreateRoom(parts[1]);
        } else if (input.matches("ADD\\s+\\S+\\s+TO\\s+\\S+")) {
            handleAddToRoom(parts[1], parts[3]);
        } else if (input.matches("USER_DETAIL\\s+\\S+")) {
            handleUserDetail(parts[1]);
        } else if (input.matches("LOGOUT\\s+\\S+")) {
            handleLogout(parts[1]);
        } else if (input.equals("LISTROOMS")) {
            handleListRooms();
        } else {
            System.out.println("REQUEST_PATTERN_INVALID");
        }
    }

    private static void handleExit() {
        System.out.println("User Count: " + registeredUsers.size());
        System.out.println("Chat Room Count: " + chatRooms.size());
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private static void handleRegister(String username) {
        if (username.contains(" ") || username.contains(";")) {
            System.out.println("REQUEST_PATTERN_INVALID");
        } else if (registeredUsers.contains(username)) {
            System.out.println("USERNAME_ALREADY_EXIST");
        } else {
            registeredUsers.add(username);
            System.out.println("SUCCESS");
        }
    }

    private static void handleLogin(String username) {
        if (!registeredUsers.contains(username)) {
            System.out.println("USERNAME_NOT_FOUND");
        } else if (onlineUsers.contains(username)) {
            System.out.println("USERNAME_ALREADY_ONLINE");
        } else {
            onlineUsers.add(username);
            System.out.println("SUCCESS");
        }
    }

    private static void handleCreateRoom(String roomName) {
        if (roomName.contains(" ") || roomName.contains(";")) {
            System.out.println("REQUEST_PATTERN_INVALID");
        } else if (chatRooms.contains(roomName)) {
            System.out.println("0");
        } else {
            chatRooms.add(roomName);
            System.out.println("SUCCESS");
        }
    }

    private static void handleAddToRoom(String username, String roomName) {
        if (!registeredUsers.contains(username)) {
            System.out.println("USERNAME_NOT_FOUND");
        } else if (!chatRooms.contains(roomName)) {
            System.out.println("ROOM_NAME_NOT_FOUND");
        } else if (!onlineUsers.contains(username)) {
            System.out.println("USERNAME_NOT_ONLINE");
        } else if (roomName.equals(userChatRoomMap.get(username))) {
            System.out.println("USER_ALREADY_ADDED");
        } else {
            userChatRoomMap.put(username, roomName);
            System.out.println("SUCCESS");
        }
    }

    private static void handleUserDetail(String username) {
        if (!registeredUsers.contains(username)) {
            System.out.println("USERNAME_NOT_FOUND");
        } else {
            System.out.println("Username: " + username);
            System.out.println("LoggedIn: " + onlineUsers.contains(username));
            System.out.println("Chat Room: " + userChatRoomMap.getOrDefault(username, "null"));
        }
    }

    private static void handleLogout(String username) {
        if (!registeredUsers.contains(username)) {
            System.out.println("USERNAME_NOT_FOUND");
        } else if (!onlineUsers.contains(username)) {
            System.out.println("USERNAME_NOT_ONLINE");
        } else {
            onlineUsers.remove(username);
            userChatRoomMap.remove(username);
            System.out.println("SUCCESS");
        }
    }

    private static void handleListRooms() {
        if (chatRooms.isEmpty()) {
            System.out.println("NO_ROOM_AVAILABLE");
        } else {
            System.out.println(String.join(";", chatRooms));
        }
    }
}

