package com.example.javafxwelcome;

public class User {
    private String username;
    private String password;
    private static final int PASSWORD_LENGTH = 8;

    public User(String username, String password) throws IllegalArgumentException {
        setUsername(username);
        setPassword(password);
    }


    private static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    private static boolean is_Numeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private boolean is_Valid_Password() {

        if (getPassword().length() < getPASSWORD_LENGTH()) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < getPassword().length(); i++) {

            char ch = getPassword().charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }

        return (charCount >= 2 && numCount >= 2);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) throws IllegalArgumentException {
        this.password = password;
    }

    protected static int getPASSWORD_LENGTH() {
        return PASSWORD_LENGTH;
    }

    public boolean isAdmin() {
        return (getUsername().equals("admin") && getPassword().equals("admin"));
    }
}
