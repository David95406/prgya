<?php
header('Access-Control-Allow-Origin: *');
header('Content-Type: application/json');
header("Access-Control-Allow-Methods: POST, DELETE");


require "../../common/db.inc.php";

$method = $_SERVER['REQUEST_METHOD'];

function json_encode_uft8($values) {
    return json_encode($values, JSON_UNESCAPED_UNICODE);
}

switch ($method) {
    case "POST":
        $input = json_decode(file_get_contents('php://input'), true);
        create_karakter($pdo, $input);
        break;
    case "DELETE":
        $input = json_decode(file_get_contents('php://input'), true);
        remove_karakter($pdo, $input);
        break;
    default:
        http_response_code(405);
        echo json_encode_uft8(array("hiba" => "hibas metodus"));
        break;
}

function create_karakter($pdo, $input) {
    if (count($input) == 5 and isset($input['nev']) and isset($input['szint']) and isset($input['ero']) and isset($input['ugyesseg']) and isset($input['faj_id'])) {
        $nev = strip_tags($input['nev']);
        $szint = intval(strip_tags($input['szint']));
        $ero = intval(strip_tags($input['ero']));
        $ugyesseg = intval(strip_tags($input['ugyesseg']));
        $faj_id = intval(strip_tags($input['faj_id']));

        $sql = "INSERT INTO karakterek (nev, szint, ero, ugyesseg, faj_id) VALUES ('$nev', $szint, $ero, $ugyesseg, $faj_id)";
        $stmt = $pdo->query($sql);
        $response = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $new_id = $pdo->lastInsertId();
        http_response_code(201);
        echo json_encode_uft8(array("id" => intval($new_id)));
    } else {
        http_response_code(400);
        echo json_encode_uft8(array("hiba" => "Hiányzó adat vagy érvénytelen faj"));
    }
}

function remove_karakter($pdo, $input) {
    if (count($input) == 1 and isset($input['id'])) {
        $target_id = intval(strip_tags($input['id']));

        $sql = "DELETE FROM karakterek WHERE id = ($target_id)";
        $stmt = $pdo->query($sql);
        $response = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if ($stmt->rowCount() > 0) {
            http_response_code(204);
        } else {
            http_response_code(404);
        }
    } else {
        http_response_code(400);
        echo json_encode_uft8(array("hiba" => "Hiányzó adat!"));
    }
}
