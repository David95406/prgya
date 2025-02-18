<?php

include '../common/db.inc.php';
$input = json_decode(file_get_contents('php://input'), true);
$method = $_SERVER['REQUEST_METHOD'];

if ($method == 'PUT') { // add tanulo to empty space ( - )
    try {
        $sql = "SELECT nev FROM " . DB_PREFIX . "_osztaly WHERE sor = :sor AND oszlop = :oszlop";
        $stmt = $pdo->prepare($sql);
        $stmt->execute(['sor' => $input['sor'], 'oszlop' => $input['oszlop']]);
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        if (str_contains($result['nev'], '-')) {
            $sql = "UPDATE " . DB_PREFIX . "_osztaly SET nev = :nev, felhasznalonev = :felhasznalonev, jelszo = :jelszo WHERE sor = :sor AND oszlop = :oszlop";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['nev' => $input['nev'], 'felhasznalonev' => $input['felhasznalonev'], 'jelszo' => $input['jelszo'], 'sor' => $input['sor'], 'oszlop' => $input['oszlop']]);
            echo json_encode(['message' => 'Sikeresen hozzáadva!']);
        } else {
            echo json_encode(array('error' => 'Érvénytelen érték vagy ezen a helyen már ül tanuló!'));
        }
    } catch (PDOException $e) {
        echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
    }
} else {
    echo json_encode(array('error' => 'Method not allowed'));
}

