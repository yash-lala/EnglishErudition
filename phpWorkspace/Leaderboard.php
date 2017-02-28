<?php
require_once "Actions.php";
$trigger = new Actions();
$response = array();
$result = $trigger->getLeaderboard();
$response['list'] = $result;
echo json_encode($response);
 ?>
