<?php
$passage = 'Carly has a large family.She lives with four people.Carly also has two pets.Carl\'s mom is a doctor. Carly\'s mom worksat the hospital. Carly\'s mom helps people who are sick.Carly\'s dad works at home. Carly\'s dadcooks for the family. Carly\'s dad drives the kids
to soccer practice.Carly has two brothers. James is ten years old. Scott is fourteen years old.Carly has two pets. Jinx is a small, black cat.Diego is a large, brown dog.Carly loves her family!';
$questions = array('1How many people are in Carly\'s family?','2Carly\'s mom works at the ?','
3This passage is mostly about Carly\'s?','4Which of the following is most likely true?','5The oldest brother in Carly\'s family is ?');



$opt1 = array('four','five','six','three');
$opt2 = array('restaurant','mall','hospital','theatre');
$opt3 = array('family','pets','soccer team','playground');
$opt4 = array('Carly\'s mom coaches the soccer team','James is the best soccer player in the family','jinx and Diego are part of Carly\'s family','none of the above');
$opt5 = array('James','Scott','Diego','jinx');
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('five','hospital','family','jinx and Diego are part of Carly\'s family','Scott');

$payload = array("passage"=>$passage,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>
