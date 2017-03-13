<?php
$passage = "All spiders spin webs. That\'s because webs help spiders.Webs help spiders do three things. Webs help spiders hold eggs.Webs help spiders hide. And webs help spiders catch food.Webs help spiders hold eggs. Many spiders like to lay their eggs in their webs. The webs help keep the eggs together. Webs help spiders keep their eggs safe. Webs help spiders hide. Most spiders are dark. They are brown, grey, or black. But spider webs are light. They are white and cloudy. When spiders hide in their webs, they are harder to see. Webs help spiders catch food. Spider webs are sticky. When a bug flies into the web, it gets stuck. It moves around. It tries to get out. But it can\'t. It is trapped! Spiders can tell that the bug is trapped. That\'s because spiders feel the web move. And the spider is hungry. The spider goes to get the bug. As you can see, webs help spiders hold eggs. Webs help spiders hide. And webs help spiders catch food. Without webs, spiders would not be able to live like they do. Spiders need their webs to survive!";
$questions = array('1 This passage is mostly about','Spider webs help spiders I. hold eggs II. catch food III. find water','3 As used in paragraph 4, the word trapped most nearly means','4 How can spiders tell when something is trapped in their web?','5 As used in the last sentence of the passage, the word survive means to stay');
$opt1 = array('spider colors','spider webs','spider eggs','spider eggs and webs');
$opt2 = array('I only','I and II','I II and III','none of the above');
$opt3 = array('stuck','hidden','eaten','left it');
$opt4 = array('they feel it','they smell it','they sense it','they throw it');
$opt5 = array('alive','hidden','caught','eaten')
$options = array($opt1,$opt2,$opt3,$opt4,$opt5);

$answers = array('spider colors','I and II','stuck','they feel it','alive');

$payload = array("passage"=>$passage,"questions"=>$questions,"options"=>$options,"answers"=>$answers );
echo json_encode($payload);

 ?>
