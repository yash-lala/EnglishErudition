<?php
$music = 'test15.mp3';
$questions = array('1 Anna is ',' 2 Anna draws things that are in the','3 Anna draws','4 Anna does not draw ?',' 5 Anna probably also draws');

$opt1 = array('artist','doctor','actor','player');
$opt2 = array('ground','ocean','sky','buildings');
$opt3 = array('shells','stars','flowers','animals');
$opt4 = array('the moon','clouds','trees','cars');
$opt5 = array('airoplanes','trees','fishes,''mountains')
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('artist','sky','stars','trees','airoplanes');

$payload = array("music"=>$music,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>
