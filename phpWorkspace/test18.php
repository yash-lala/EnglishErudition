<?php

$questions = array('1 Where is John?','2 What does John see?','
3 Which animal does John see?','4 John not see ',' 5 John probably also sees');

$opt1 = array('at the lake', 'at the park', 'at the store','at the playground');
$opt2 = array('people', 'friends', 'animals','plants');
$opt3 = array('pigs', 'tigers', 'birds','bulls');
$opt4 = array(' dogs', 'cats', 'birds','mice');
$opt5 = array(' squirrels', 'machines', 'computers','dinasours')
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('at the park','animals','birds','cats','squirrels');

$payload = array("passage"=>$passage,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>

