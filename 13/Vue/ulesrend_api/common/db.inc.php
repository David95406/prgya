<?php
$servername = "127.0.0.1";
$username = "root";
$password = "";
//$dbname = "c31abrahamD_db";
$dbname = "php_teszt";

define('DB_PREFIX', 'x23da');

try {
    $pdo = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $conn = new mysqli($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
        throw new Exception("Connection failed: " . $conn->connect_error);
    }
} catch (PDOException $e) {
    die("Connection failed: " . $e->getMessage());
}

if ($conn->connect_error) {
    //die("Connection failed: " . $conn->connect_error);
    throw new Exception("Connection failed: " . $conn->connect_error);
}
