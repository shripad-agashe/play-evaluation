###value =  "this is validation file"
alert value###
cofeeFunc = ->
  coffeeAns =  confirm "Ready for coffee?"
  ans = if coffeeAns then "Wooow U R Ready for Coffee :) " else "Ohh Not ready for Coffee :( "
  alert ans
###Another function to validate input of term ###
checkForTerm=(term) -> if term is ''
  alert("Term Required..!!!")
  false
else
  true

