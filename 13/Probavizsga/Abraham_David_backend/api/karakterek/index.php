<?php
header('Access-Control-Allow-Origin: *');
header('Content-Type: application/json');
header("Access-Control-Allow-Methods: GET, POST");


require "../../common/db.inc.php";

$method = $_SERVER['REQUEST_METHOD'];

function json_encode_uft8($values) {
    return json_encode($values, JSON_UNESCAPED_UNICODE);
}

switch ($method) {
    case "GET":
        get_karakter($pdo);
        break;
    case "POST":
        $input = json_decode(file_get_contents('php://input'), true);
        create_karakter($pdo, $input);
        break;
    default:
        http_response_code(405);
        echo json_encode_uft8(array("hiba" => "hibas metodus"));
        break;
}

function get_karakter($pdo) {
    if (isset($_GET['faj']) and count($_GET) == 1) {
        $u_faj = strip_tags($_GET['faj']);
        
        $sql = "SELECT karakterek.id, karakterek.nev, karakterek.szint, karakterek.ero, karakterek.faj_id, karakterek.ugyesseg, fajok.id, fajok.nev as faj_nev FROM karakterek INNER JOIN fajok ON fajok.id = karakterek.faj_id WHERE fajok.nev = '$u_faj'"; //  
        $stmt = $pdo->query($sql);
        $response = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $er = [];
        foreach($response as $r) {
            array_push($er, array(
                "id" => intval($r['id']),
                "nev" => $r['nev'],
                "szint" => intval($r['szint']),
                "ero" => intval($r['ero']),
                "ugyesseg" => intval($r['ugyesseg']),
                "faj" => array(
                    "id" => intval($r['faj_id']),
                    "nev" => $r['faj_nev']
                )
            ));
        }

        if (count($er) == 0) {
            echo json_encode_uft8(array("hiba" => "nincs talalat!"));
        }
    } else {
        echo json_encode_uft8(array("hiba" => "Hibás vagy hiányzó paraméter"));
    }
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
        echo json_encode_uft8(array("id" => $new_id));
    } else {
        http_response_code(400);
        echo json_encode_uft8(array("hiba" => "Hibás vagy hiányzó adatok!"));
    }
}