<?php

include '../common/db.inc.php';
$input = json_decode(file_get_contents('php://input'), true);

if (isset($_GET['sor']) && isset($_GET['oszlop'])) {
    $sor = $_GET['sor'];
    $oszlop = $_GET['oszlop'];

    try {
        $sql = "SELECT nev, sor, oszlop, felhasznalonev FROM " . DB_PREFIX . "_osztaly WHERE sor = :sor AND oszlop = :oszlop";
        $stmt = $pdo->prepare($sql);
        $stmt->execute(['sor' => $sor, 'oszlop' => $oszlop]);
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        if (empty($result)) {
            echo json_encode(array('error' => 'Nincs ilyen tanuló!'));
            return;
        }
        echo json_encode($result);

    } catch (PDOException $e) {
        echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
    }
} else {
    echo json_encode(array('error' => 'sor or oszlop parameter is missing!'));
}
