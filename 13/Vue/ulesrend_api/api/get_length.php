<?php

include '../common/db.inc.php';

try {
    $sql = "SELECT * FROM " . DB_PREFIX . "_osztaly WHERE nev != 'Tanár úr' AND nev != ' - '";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode(array('length' => count($result)));
} catch (PDOException $e) {
    echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
}
