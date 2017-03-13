<?php
$passage = "A robot is a machine. But it is not just any machine. It is a special kind of machine. It is a machine that moves. It follows
instructions. The instructions come from a computer. Because it is a machine, it does not make mistakes. And it does not get tired. And it
never complains. Unless you tell it to Robots are all around us. Some robots are used to make things. For example, robots can help make cars. Some robots are used to explore dangerous places. For example, robots can help explore volcanoes. Some robots are used to clean things. These
robots can help vacuum your house. Some robots can even recognize words. They can be used to help answer telephone calls. Some robots look like humans. But most robots do not. Most robots just look like machines.Long ago, people imagined robots. Over 2,000 years ago, a famous poet imagined robots. The poet\'s name was Homer. His robots were made of gold. They cleaned things and they made things. But they were not real. They were imaginary. Nobody was able to make a real robot. The first real robot was made in 1961. It was called Unimate. It was used to help make cars. It looked like a giant arm.In the future, we will have even more robots. They will do things that we can�t do. Or they will do things that we don�t want to do. Or they will do things that are too dangerous for us. Robots will help us fight fires. They will help us fight wars. They will help us fight sickness. They will help us discover things. They will help make life better";
$questions = array('1 As used in paragraph 1, we can understand that something special is NOT?','2 According to the author  robots may be used to I. make cars II. explore volcanoes III. answer telephone calls ','3 What is the main purpose of paragraph 2?','4 According to the passage, when was the first real robot made? ','5 Using the information in the passage as a guide, which of these gives the best use of a robot?');

$opt1 = array('normal','expensive','perfect','tired');
$opt2 = array('only I','I and II','II and III','I II III');
$opt3 = array('perfect','II and III','to describe the things a robot can do','2003','to help read a book');
$opt4 = array('to show how easy it is to make a robot','to tell what a robot is','to explain the difference between a robot and a machine','to explain the difference between a robot and a machine');
$opt5 = array('to help make a sandwich','to help tie shoes','to help read a book','to help explore mars');
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('normal','I II and III','to describe the things a robot can do','1961','to help explore mars');

$payload = array("passage"=>$passage,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>