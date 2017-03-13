<?php

$questions = array(' 1 Where is Erin?',' 2 Erin eats ','
 3 What food does Erin eat?','4 Erin does not eat','5 Erin probably also eats ?');

$opt1 = array('She is at her house', 'She is at a restaurant', 'She is at school','She is at market');
$opt2 = array( 'breakfast', 'dinner', 'dessert','lunch');
$opt3 = array('cake', 'cheese', 'bananas','pie');
$opt4 = array('pie', 'cake', 'cookies','bananas');
$opt5 = array('bananas', 'chocolates', 'sandwiches','chips')
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('She is at her house','dessert','cake','pie','chocolates');

$payload = array("passage"=>$passage,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>

