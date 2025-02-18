<?php

include '../common/db.inc.php';
$input = json_decode(file_get_contents('php://input'), true);
$method = $_SERVER['REQUEST_METHOD'];

switch ($method) {
    case 'GET':
        handleGet($conn);
        break;
    case 'POST':
        handlePost($conn, $input);
        break;
    case 'PUT':
        handlePut($conn, $input);
        break;
    case 'DELETE':
        // handleDelete($conn, $input);
        break;
    default:
        echo json_encode(['message' => "Érvénytelen metódus!"]);
        break;
}

function handleGet($conn)
{
    try {
        $result = $conn->query("SELECT * FROM " . DB_PREFIX . "_osztaly");
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $resp[] = array("id" => $row["id"], "nev" => $row["nev"], "sor" => $row["sor"], "oszlop" => $row["oszlop"], "isAdmin" => $row["isAdmin"]);
            }
        }
        echo json_encode($resp);
    } catch (PDOException $e) {
        echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
    }

}

function handlePost($conn, $input)
{
    try {
        $sql = "INSERT INTO " . DB_PREFIX . "_osztaly (nev, sor, oszlop) VALUES (?, ?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("sii", $input['nev'], $input['sor'], $input['oszlop']);
        $stmt->execute();
        echo json_encode(['message' => 'Sikeresen hozzáadva!']);
    } catch (PDOException $e) {
        echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
    }
}

function handlePut($conn, $input)
{
    try {
        $sql = "UPDATE " . DB_PREFIX . "_osztaly SET nev = ? WHERE id = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("si", $input['nev'], $input['id']);
        $stmt->execute();
        echo json_encode(['message' => 'Sikeresen módosítva!']);
    } catch (PDOException $e) {
        echo json_encode(array('error' => 'Database error: ' . $e->getMessage()));
    }

}

function handleDelete($conn, $input)
{
    $sql = "DELETE FROM " . DB_PREFIX . "_osztaly WHERE id = :id";
    $stmt = $conn->prepare($sql);
    $stmt->execute(['id' => $input['id']]);
    echo json_encode(['message' => 'Sikeresen törölve']);
}
