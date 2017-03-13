<?php

$questions = array('1 Adam is a ','2 Adam cooks','3 What kind of food does Adam cook?','4 Adam does not cook','5 Adam probably also cooks');

$opt1 = array('waiter', 'chef', 'teacher','poet');
$opt2 = array('tomatoes', 'steak', 'bread','chicken');
$opt3 = array('meat', 'pasta', 'fruit','steak');
$opt4 = array('chicken', 'pork', 'apples','bananas');
$opt5 = array('green beans', 'asparagus', 'hamburgers,');
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('chef','steak','meat','apples','hamburgers');

$payload = array("questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>
